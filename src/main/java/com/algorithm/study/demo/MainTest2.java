package com.algorithm.study.demo;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * 在输入文件（/tmp/input.txt）中存储了数百个任意的文件夹绝对路径（可能重复，也可能相互包含），每个路径一行。
 * 请读入input文件内容，计算各文件夹所占用的磁盘空间大小并按占用空间由大到小的顺序进行排序。
 * 将排序后的路径及其所占用的空间大小写入到输出文件（/tmp/output.txt）。
 * 要求：
 * 1、仅可使用标准JDK工具类
 * 2、请通过多线程对各统计任务进行加速
 * 3、请尽量减少全部统计任务的整体完成时间Å
 * 4、请尽量保证代码规范和代码规约
 * 5、限时60分钟内完成，可任意查阅资料、博客及搜索引擎
 * 输入文件示例：
 * ==================
 * /home/guest
 * /usr
 * /usr/bin
 * /var
 * /root
 * ……
 * ==================
 * 输出文件示例：
 * ==================
 * /root 1234567
 * /var 123456
 * /home/guest 12345
 * /usr 1234
 * /usr/bin 123
 * ……
 * ==================
 * @Author: liuxun
 * @CreateDate: 2019/3/14
 * @Version: 1.0
 */
public class MainTest2 {
    private final static String INPUT="/tmp/input.txt";
    private final static String OUTPUT="/tmp/output.txt";

    public static void main(String[] args) {
        doReadTxt(new File(INPUT));
        System.out.println("执行结束");
    }

    public static String doReadTxt(File file) {
        if (null==file || !file.exists()){
            return null;
        }
        BufferedReader br=null;
        try {
            /**创建一个线程池**/
            ExecutorService executors = new ThreadPoolExecutor(8, 8,
                    60L, TimeUnit.SECONDS,new ArrayBlockingQueue(10));
            /**读取一个文件**/
            br = new BufferedReader(new FileReader(file));
            String s = null;
            Map<String,Future<Long>> folders=new ConcurrentHashMap<>();
            while ((s = br.readLine()) != null) {
                Future<Long> folderSizeFuture = executors.submit(new DoFolderSize(new File(s)));
                folders.put(s,folderSizeFuture);
            }
            /**获取统计结果**/
            Map<String,Long> resultMap=new HashMap<>();
            for (Map.Entry<String, Future<Long>> me:folders.entrySet()){
                String fileStr=me.getKey();
                Long size=me.getValue().get();
                resultMap.put(fileStr,size);
            }
            /**排序**/
            Map<String, Long> sortMap = sortMapByValue(resultMap);
            for (Map.Entry<String,Long> fileInfo:sortMap.entrySet()){
                doOutTxt(OUTPUT,fileInfo.getKey()+" "+fileInfo.getValue());
            }
            executors.shutdown();//关闭线程池
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * 异步获取文件夹大小
     */
    static class DoFolderSize implements Callable<Long>{
        private File file;
        public DoFolderSize(File file){
            this.file=file;
        }
        @Override
        public Long call() throws Exception {
            return getFolderTotalSize(file);
        }
    }
    /**
     * 计算文件夹大小
     * @param file
     * @return
     */
    private static long getFolderTotalSize(File file) {
        if (null == file) {
            return 0L;
        }
        if (file.isFile()) {
            return file.length();
        }
        long total = 0;
        File[] files = file.listFiles();
        for (final File f : files) {
            total += getFolderTotalSize(f);
        }
        return total;
    }

    /**
     * 对map value进行排序
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortMapByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted((o1,o2)->o2.getValue().compareTo(o1.getValue()))
                .forEach(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }

    /**
     * txt写入
     * @param path
     * @param content
     */
    public static void doOutTxt(String path,String content){
        try {
            //构造函数中的第二个参数true表示以追加形式写文件
            FileWriter fw = new FileWriter(path,true);
            fw.write(content+System.lineSeparator());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

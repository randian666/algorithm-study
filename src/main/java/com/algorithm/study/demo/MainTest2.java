package com.algorithm.study.demo;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * @Author: liuxun
 * @CreateDate: 2019/3/11 下午9:43
 * @Version: 1.0
 */
public class MainTest2 {
    public static void main(String[] args) {
        doReadTxt(new File("/Users/liuxun/Downloads/temp/input.txt"));
        System.out.println("执行结束");
    }
    public static String doReadTxt(File file) {
        try {
            /**创建一个线程池**/
            ExecutorService executors = Executors.newFixedThreadPool(8);
            /**读取一个文件**/
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            Map<String,Future<Long>> futures=new HashMap<>();
            while ((s = br.readLine()) != null) {
                Future<Long> future = executors.submit(new DoFolderSize(new File(s)));
                futures.put(s,future);
            }
            /**获取统计结果**/
            Map<String,Long> resultMap=new HashMap<>();
            for (Map.Entry<String, Future<Long>> me:futures.entrySet()){
                String fileStr=me.getKey();
                Long size=me.getValue().get();
                resultMap.put(fileStr,size);
            }
            /**排序**/
            Map<String, Long> sortMap = sortMapByValue(resultMap);
            for (Map.Entry<String,Long> fileInfo:sortMap.entrySet()){
                doOutTxt("/Users/liuxun/Downloads/temp/out.txt",fileInfo.getKey()+"  "+fileInfo.getValue());
            }
            executors.shutdown();//关闭线程池
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
     *
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
    }}

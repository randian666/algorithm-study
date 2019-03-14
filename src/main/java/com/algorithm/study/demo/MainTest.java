package com.algorithm.study.demo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: liuxun
 * @CreateDate: 2019/1/2 上午11:29
 * @Version: 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        try {
            String filePath="/Users/liuxun/csv.txt";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

            File file=new File(filePath);
            File out=new File("/Users/liuxun/out.txt");
            createFile(out);

            BufferedReader reader=new BufferedReader(new FileReader(file));
            String temp=null;
            while ((temp=reader.readLine())!=null){
                StringBuffer sb=new StringBuffer();
                //双引号内的逗号不分割  双引号外的逗号进行分割
                String[] strArr = temp.trim().split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)",-1);
                if (strArr.length<=5){
                    System.out.println("数据格式不准确");
                    continue;
                }
                sb.append(Integer.valueOf(strArr[0])).append("\t");
                sb.append("'"+strArr[1]+"'").append("\t");
                sb.append("'"+strArr[2]+"'").append("\t");
                sb.append(Float.valueOf(strArr[3])).append("\t").append("\t");
                sb.append(sdf1.format(sdf.parse(strArr[4])));
                System.out.println(sb.toString());
                fileChaseFW("/Users/liuxun/out.txt",sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入TXT，追加写入
     * @param filePath
     * @param content
     */
    public static void fileChaseFW(String filePath, String content) {
        try {
            //构造函数中的第二个参数true表示以追加形式写文件
            FileWriter fw = new FileWriter(filePath,true);
            fw.write(content+"\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("文件写入失败！" + e);
        }
    }
    /**
     * 创建文件
     * @param fileName
     * @return
     */
    public static boolean createFile(File fileName)throws Exception{
        try{
            if(!fileName.exists()){
                fileName.createNewFile();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }


}

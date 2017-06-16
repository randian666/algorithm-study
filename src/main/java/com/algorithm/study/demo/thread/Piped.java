package com.algorithm.study.demo.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道输入/输出流和普通的文件输入/输出流或者网络输入/输出流不同之处在于，它主要
 用于线程之间的数据传输，而传输的媒介为内存。
 管道输入/输出流主要包括了如下4种具体实现：PipedOutputStream、PipedInputStream、
 PipedReader和PipedWriter，前两种面向字节，而后两种面向字符。
 * Created by liuxun on 2017/6/16.
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter writer=new PipedWriter();
        PipedReader reader=new PipedReader();
        writer.connect(reader);
        Thread t=new Thread(new Print(reader),"readerThread");
        Thread t1=new Thread(new Writer(writer),"readerThread");
        t.start();
        t1.start();
//        try {
//            int w=0;
//            while ((w=System.in.read())!=-1){
//                writer.write(w);
//            }
//        } finally {
//            writer.close();
//            reader.close();
//        }
    }

    static  class Print implements Runnable{
        private PipedReader reader;
        public Print(PipedReader reader){
            this.reader=reader;
        }
        public void run() {
            int i=0;
            try {
                while ((i=reader.read())!=-1){
                    System.out.println("读："+(char) i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static class Writer implements Runnable{
        private PipedWriter writer;
        public Writer(PipedWriter writer){
            this.writer=writer;
        }
        public void run() {
            while (true){
                try {
                    writer.write("hello");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

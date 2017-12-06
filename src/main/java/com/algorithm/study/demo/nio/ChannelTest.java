package com.algorithm.study.demo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author liuxun
 * @version V1.0
 * @Description: JavaNio Channel 
 * @date 2017/12/4
 */
public class ChannelTest {
    public static void main(String[] args) throws IOException {
        try {
            Charset charset = Charset.forName("GBK");
            //Java.nio.charset.Charset处理了字符转换问题。它通过构造CharsetEncoder和CharsetDecoder将字符序列转换成字节和逆转换。
            CharsetDecoder decoder = charset.newDecoder();

            RandomAccessFile raf = new RandomAccessFile("E:\\data.txt", "rw");
            FileChannel fc = raf.getChannel();

//            RandomAccessFile raf1 = new RandomAccessFile("E:\\count.txt", "rw");
//            FileChannel fc1 = raf1.getChannel();
//
//            fc1.transferTo(0, fc.size(),fc);

            //create buffer with capatity of 512 bytes
            ByteBuffer buffer = ByteBuffer.allocate(512);
            CharBuffer cb = CharBuffer.allocate(512);
            //写入数据到Buff
            int count = fc.read(buffer);
            while (count != -1) {
                System.out.println("count = "+count);
                //通过flip()方法将Buffer从写模式切换到读模式
                buffer.flip();
                decoder.decode(buffer, cb, false);
                cb.flip();
                //从Buffer中读取数据
                while (cb.hasRemaining()) {
                    System.out.print(cb.get());
                }
                System.out.println();
                //清空缓冲区
                buffer.clear();
                cb.clear();
                count = fc.read(buffer);
            }
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

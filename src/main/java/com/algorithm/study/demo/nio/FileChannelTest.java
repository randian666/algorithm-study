package com.algorithm.study.demo.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author liuxun
 * @version V1.0
 * @Description: Filechannel 操作
 * @date 2017/12/5
 */
public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        //向Filechannel写入数据
        RandomAccessFile aFile = new RandomAccessFile("E:\\nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        while(buf.hasRemaining()){
            channel.write(buf);
            System.out.println(channel.position());//通过调用position()方法获取FileChannel的当前位置
        }
        System.out.println(channel.size());//FileChannel实例的size()方法将返回该实例所关联文件的大小
        channel.force(true);//FileChannel.force()方法将通道里尚未写入磁盘的数据强制写到磁盘上。出于性能方面的考虑，操作系统会将数据缓存在内存中，所以无法保证写入到FileChannel里的数据一定会即时写到磁盘上。要保证这一点，需要调用force()方法。
        channel.close();

    }
}

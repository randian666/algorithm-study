package com.algorithm.study.demo.algorithm.huffman;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xun2.liu
 * @title: DataOutputStreamHuffman
 * @projectName algorithm-study
 * @description: TODO
 * @date 2019/11/19 17:03
 */
public class DataOutputStreamHuffman {

    public static final DataOutputStreamHuffman OUTPUT = new DataOutputStreamHuffman();

    public static final String path = "D:\\java\\test\\datastruct\\hoffman\\";

    public void outtoFile(byte[] value) {
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(path + "src.file");
            output.write(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != output) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void outHuffmantoFile(byte[] value) {
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(path + "out.huff");
            output.write(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != output) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

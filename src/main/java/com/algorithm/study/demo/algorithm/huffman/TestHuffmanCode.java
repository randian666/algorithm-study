package com.algorithm.study.demo.algorithm.huffman;


import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author xun2.liu
 * @title: TestHuffmanCode
 * @projectName algorithm-study
 * @description: huffman编码测试
 * @date 2019/11/19 17:08
 */
public class TestHuffmanCode {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int valueRand = ThreadLocalRandom.current().nextInt(1, 50);

            StringBuilder msg = new StringBuilder();

            for (int j = 0; j < valueRand; j++) {
                msg.append((char) ThreadLocalRandom.current().nextInt(65, 122));
            }

            String src = "我我我我我我我我我我我我是是是是是是小小小小小小thisis" + msg.toString();

            Map<Character, Integer> conMap = StrProc.countCharset(src);

            System.out.println(conMap);

            HuffmanCode instance = new HuffmanCode();
            Map<Character, String> huffCode = instance.getHuffManCode(conMap);
            System.out.println(huffCode);

            Integer value = Integer.parseInt("1010", 2);
            System.out.println(value);

            // Map<Character, Byte> parseTwo = instance.encodeHuf(huffCode);

            // String hufOutValue = instance.parseHuffman(src, parseTwo);
            String hufOutValue = instance.parseHuffman2(src, huffCode);

            // DataOutputStreamHuffman.OUTPUT.outtoFile(src.getBytes(StandardCharsets.UTF_8));
            // DataOutputStreamHuffman.OUTPUT.outHuffmantoFile(hufOutValue.getBytes());

            String deValue = instance.decodeHuffman(hufOutValue, instance.root);
            System.out.println("原始" + src);
            System.out.println("结果" + deValue);

//            Assert.assertEquals(src, deValue);

            System.out.println(
                    "--------------------------------------------------------------------------------");
        }
    }
}

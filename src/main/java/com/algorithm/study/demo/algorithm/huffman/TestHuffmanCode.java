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
//        for (int i = 0; i < 5; i++) {
            int valueRand = ThreadLocalRandom.current().nextInt(1, 50);
            StringBuilder msg = new StringBuilder();
            for (int j = 0; j < valueRand; j++) {
                msg.append((char) ThreadLocalRandom.current().nextInt(65, 122));
            }

            String src = "aabbcceed" + msg.toString();
            System.out.println("原始：" + src);

            Map<Character, Integer> conMap = StrProc.countCharset(src);

            System.out.println("字符频率统计："+conMap);

            HuffmanCode instance = new HuffmanCode();
            Map<Character, String> huffCode = instance.getHuffManCode(conMap);
            System.out.println("huffcode字符编码映射："+huffCode);

            String hufOutValue = instance.parseHuffman2(src, huffCode);
            System.out.println("最终编码："+hufOutValue);

            String deValue = instance.decodeHuffman(hufOutValue, instance.root);
            System.out.println("解压结果：" + deValue);

            System.out.println("--------------------------------------------------------------------------------");
        }
}

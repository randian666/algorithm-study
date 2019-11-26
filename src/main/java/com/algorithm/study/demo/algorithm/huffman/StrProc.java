package com.algorithm.study.demo.algorithm.huffman;

import java.util.HashMap;
import java.util.Map;
/**
 * @author xun2.liu
 * @title: StrProc
 * @projectName algorithm-study
 * @description: 对字符进行统计
 * @date 2019/11/19 17:07
 */
public class StrProc {
    /**
     * 对字符进行统计操作
     *
     * @param str
     * @return
     */
    public static Map<Character, Integer> countCharset(String str) {

        if (null != str && str.length() > 0) {

            Map<Character, Integer> result = new HashMap<>();

            char[] strChars = str.toCharArray();

            Integer value = null;
            for (int i = 0; i < strChars.length; i++) {
                value = result.get(strChars[i]);

                if (value == null) {
                    result.put(strChars[i], 1);
                } else {
                    result.put(strChars[i], value + 1);
                }
            }

            return result;
        }
        return null;
    }
}

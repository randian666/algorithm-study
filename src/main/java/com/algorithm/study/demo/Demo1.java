package com.algorithm.study.demo;

import com.algorithm.study.demo.model.User;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * @title: Demo1
 * @projectName algorithm-study
 * @description: TODO
 * @date 2019/9/24 15:59
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        User user=new User();
        user.setId(1);
        setUserName(user,"name","刘勋");
        System.out.println(JSON.toJSONString(user));
    }

    private static void setUserName(User t, String column, String name) throws Exception {
        Field f = t.getClass().getDeclaredField(column);
        f.setAccessible(true);
        f.set(t, name);
    }
}

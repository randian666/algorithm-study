package com.algorithm.study.demo;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @title: Demo1
 * @projectName algorithm-study
 * @description: TODO
 * @date 2019/9/24 15:59
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
//       String str="2020-01-07 19:42:06.386 INFO  [BUS_VCC_ORDER_DETAIL][common][][BJ2001071650476613943652869165056][VCC20200107173708DDPSYV]PsiDAOProxy 类 listBySerialNo 方法入参:BJ2001071650476613943652869165056";
//       String traceId="VCC20200107173708DDPSYV";
//       String p="["+traceId+"]";
//       if (str.indexOf(p)>0){
//           str=StringUtils.substring(str,str.indexOf("["+traceId+"]")+p.length());
//       }
//        System.out.println(str);
        String msg="asdfasdf";
        String throwable="asdfasdfasdfadaskdjfaskdjf";
        msg+=throwable;
        System.out.println(msg);
    }
}

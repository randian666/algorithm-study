package com.algorithm.study.demo.base;

public class MainTest {
    private static final String msgg="123";
    public static void main(String[] args) {
        MainTest mo=new MainTest();
        Mobile mobile=new IphoneXMobile();
        mobile.call();
        mobile.show();

        System.out.println(mobile);
        Mobile mobile2=new HuaweiMobile();
        mobile2.call();
        mobile2.show();

        System.out.println(mobile);


        IPerson per = new YellowPerson();
        per.eat();
    }
}

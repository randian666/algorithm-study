package com.algorithm.study.demo.mode.proxy;

public class MainTest {
    public static void main(String[] args) {
        /**
         * 为其他对象提供一种代理以控制对这个对象的访问
         *
         */
        IGamePlayer gamePlayer=new GamePlayer("刘勋");
        GamePlayerProxy proxy=new GamePlayerProxy(gamePlayer);
        proxy.login("liuxun","xxxxx");
        proxy.killBoss();
        proxy.upgrade();
    }
}

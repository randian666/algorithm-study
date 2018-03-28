package com.algorithm.study.demo.mode.proxy;

/**
 * 游戏者
 */
public class GamePlayer implements  IGamePlayer{
    private String name;

    public GamePlayer(String name) {
        this.name = name;
    }

    public void login(String userName, String password) {
        System.out.println(name+"开始登录，用户名为:"+userName+",密码为："+password);
    }

    public void killBoss() {
        System.out.println(name+"开始杀怪");
    }

    public void upgrade() {
        System.out.println(name+"开始升级");
    }
}

package com.algorithm.study.demo.mode.proxy;

/**
 * 游戏者接口
 */
public interface IGamePlayer {
    void login(String userName,String password);
    void killBoss();
    void upgrade();
}

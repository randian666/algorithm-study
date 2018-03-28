package com.algorithm.study.demo.mode.proxy;

/**
 * 游戏代练者
 */
public class GamePlayerProxy implements  IGamePlayer{
    private IGamePlayer iGamePlayer;
    public GamePlayerProxy(IGamePlayer iGamePlayer) {
        this.iGamePlayer=iGamePlayer;
    }

    public void login(String userName, String password) {
        iGamePlayer.login(userName,password);
    }

    public void killBoss() {
        iGamePlayer.killBoss();
    }

    public void upgrade() {
        iGamePlayer.upgrade();
    }
}

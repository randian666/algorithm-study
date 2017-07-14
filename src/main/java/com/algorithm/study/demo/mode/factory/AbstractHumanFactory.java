package com.algorithm.study.demo.mode.factory;

/**
 * 工厂抽象接口
 * Created by liuxun on 2017/7/14.
 */
public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> clazz);//注意这里T必须是Human的实现类才行，因为要造Human嘛

}

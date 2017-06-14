package com.algorithm.study.demo.LinearTable;

/**
 * 线性表的顺序存储结构
 * Created by liuxun on 2017/6/14.
 */
public interface MList<E> {
    E getElem(int index);
    E setElem(int index,E element);
    boolean addElem(int index,E element);
    boolean add(E element);
    boolean delElem(int index);
    boolean del(E element);
    boolean clear();
    int size();
}

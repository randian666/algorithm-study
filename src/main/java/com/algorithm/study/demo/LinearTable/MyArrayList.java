package com.algorithm.study.demo.LinearTable;

/**
 * 线性表的顺序存储结构
 * Created by liuxun on 2017/6/14.
 */
public class MyArrayList<E> implements MList{

    private Object[] data;//数组存储数据元素
    private final static int MAXSIZE=20;  //数组长度maxSize 存放线性表的存储空间长度，不变的。
    private int size;    //线性表当前的长度size，数据元素的个数，是变化的，长度小于等于数组的长度
    private final static int DEFAULT_CAPACITY=16;
    public MyArrayList(int capacity){
        this.data=new Object[Math.abs(capacity)];
        this.size=0;
    }
    /**
     * 初始化数组，长度为16
     */
    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * 根据下标获取元素
     * @param index
     * @return
     */
    public E getElem(int index){
        if (data.length==0 || index<0 || index>data.length){
            return null;
        }
        return (E) data[index];
    }

    /**
     * 设置index位置的对象为element
     * @param index
     * @param element
     * @return
     */
    public E setElem(int index, Object element) {
        if (index<0 || index>=size){
            throw new RuntimeException("数组越界 index:"+index+",size:"+size);
        }
        E old=(E)data[index];
        data[index]=element;
        return old;
    }

    /**
     * 在index位置插入element对象,后面的元素需要后移
     * @param index
     * @param element
     * @return
     */
    public boolean addElem(int index, Object element) {
        if (size==data.length){//如果数组已经满了需要扩容，每次扩两倍。
            Object[] temp=data;
            data=new Object[temp.length*2];
            for (int i=0;i<temp.length;i++){
                data[i]=temp[i];
            }
        }
        if (index<0 || index>size){
            throw new RuntimeException("数组越界 index:"+index+",size:"+size);
        }
        //元素后移
        for (int k=size-1;k>=index;k--){
            data[k+1]=data[k];
        }
        //插入新元素
        data[index]=element;
        size++;
        return true;
    }

    /**
     * 在末尾添加元素
     * @param element
     * @return
     */
    public boolean add(Object element) {
        return this.addElem(size,element);
    }

    /**
     * 删除下标index的元素
     * 该下标后的元素需要前移
     * @param index
     * @return
     */
    public boolean delElem(int index) {
        if (index<0 || index>=size){
            throw new RuntimeException("数组越界 index:"+index+",size:"+size);
        }
        for(int k=index;k<size-1;k++){
            data[k]=data[k+1];
        }
        data[size-1]=null;//最后一位需要清空
        size--;
        return true;
    }
    /**
     * 删除指定第一次出现的元素
     * @param element
     * @return
     */
    public boolean del(Object element) {
        for(int k=0;k<size;k++){
            if (data[k].equals(element)){
                return this.delElem(k);
            }
        }
        return false;
    }

    /**
     * 清空线性表
     * @return
     */
    public boolean clear() {
        if (size>0) {
            for (int k = 0; k < size - 1; k++) {
                data[k] = null;
            }
            size=0;
        }
        return true;
    }

    /**
     * 返回线性表长度
     * @return
     */
    public int size() {
        return size;
    }
}

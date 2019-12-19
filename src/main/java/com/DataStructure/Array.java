package com.DataStructure;

public class Array {

    private int[] data;
    private int size;

    /**
     * @param capacity 数组的容量
     */
    public Array(int capacity){
        data=new int[capacity];
        size=0;
    }

    //没有参数的构造函数
    public Array(){
        this(10);
    }

    //获取数组中元素的个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //判断是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //所有元素后添加一个元素
    public void addLast(int e){

        if(size==data.length)
            throw new IllegalArgumentException("数组长度不够");
        data[size]=e;
        size++;
    }

    public void add(int index,int e){
        if(size==data.length)
            throw new IllegalArgumentException("数组长度不够");

    }
}

package com.mrl.queue;


public class ArrayQueeDemo {
    public static void main(String[] args) {
    }
}

class ArryQueue {
    //存放值的数组
    private int[] arry;
    //队列头索引
    private int front;
    //队列尾索引;
    private int rear;
    //队列容量
    private int maxSize;

    //创建队列
    public ArryQueue(int maxSize) {
        this.maxSize = maxSize;
        arry = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //向队列中添加元素
    public void addElemt(int elemt) {
        if (isFull()) {
            throw new RuntimeException("队列已满,不能添加元素");
        }
        arry[++rear] = elemt;
    }

    //取元素
    public int getElemt() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有可以取出的元素");
        }
        front++;
        return arry[front];
    }

}
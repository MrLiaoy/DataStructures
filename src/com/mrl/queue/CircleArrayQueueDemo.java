package com.mrl.queue;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue caq = new CircleArrayQueue(3);
        caq.addElemt(1);
        caq.addElemt(2);
        caq.addElemt(3);
        caq.getElemt();
        caq.addElemt(4);
        caq.desc();
    }
}

class CircleArrayQueue {
    //存放值的数组
    private int[] arry;
    //队列头索引,初始值为零
    private int front;
    //队列尾索引，初始值也为零
    private int rear;
    //maxSize为数组大小并非队列的容量，其中有一个位置为预留位，预留位在变化，而预留位置为arry[((front-1)+maxsize)%maxsize];
    //这一位的主要目的是为了判断队列是否为空
    private int maxSize;

    //创建队列
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize + 1;
        arry = new int[maxSize + 1];
        front = 0;
        rear = 0;
    }

    //判断队列是否满
    //当队列值
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //向队列中添加元素
    public void addElemt(int elemt) {
        if (isFull()) {
            throw new RuntimeException("队列已满,不能添加元素");
        }
        arry[rear] = elemt;
        rear = (rear + 1) % maxSize;
    }

    //取元素
    public int getElemt() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有可以取出的元素");
        }
        int elemt = arry[front];
        front = (front + 1) % maxSize;
        return elemt;
    }

    // 遍历元素
    public void desc() {
        for (int i = front; i < front + getSize(); i++)
            System.out.println(arry[i % maxSize]);
    }

    public int getSize() {
        return (rear + maxSize - front) % maxSize;
    }
}
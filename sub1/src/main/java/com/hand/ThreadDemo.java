package com.hand;

/**
 * 线程实现的两种方法：
 * 1、继承Thread类
 * 2、实现Runnable接口
 * sleep/yield/join/setPriority/getName
 */


class MyThread extends Thread{
    private String name;

    public MyThread(String name){
        this.name = name;
    }

    public void run(){
        for(int i =0;i<10;i++){
            System.out.println(name+":"+i);
        }
    }
}

class MyRunnable implements Runnable{

    private String name;

    public MyRunnable(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0; i<100;i++){
//            System.out.println("当前线程对象："+Thread.currentThread().getName());
            System.out.println(this.name+";"+i);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if (i == 10){
                System.out.println("礼让");
                Thread.yield();
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String [] args){
        TestMyThread();
//        TestMyRunnable();
    }

    public static void TestMyThread(){
        MyThread t1 = new MyThread("A");
        MyThread t2 = new MyThread("B");
        MyThread t3 = new MyThread("C");
        // 设置优先级
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        // 通过start启动线程
        t1.start();
        t2.start();
        t3.start();
    }

    public static void TestMyRunnable(){
        MyRunnable r1 = new MyRunnable("a");
        MyRunnable r2 = new MyRunnable("b");
        Thread t3 = new Thread(r1);
        Thread t4 = new Thread(r2);
        System.out.println(t3.isAlive());
        t3.start();
        System.out.println(t3.isAlive());
        t3.start();

        for (int i = 0;i<50;i++){
            if (i>10){
                try {
                    t3.join();  //强行执行,作用于t1,t2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("主线程："+i);
        }
    }
}

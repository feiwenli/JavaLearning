package com.hand;

class MyThreadDemo implements  Runnable{
    private int ticket = 5;

    public void run(){
        for (int i = 0;i<10;i++){
            // 同步方法调用
            tell();

            // 同步代码块
//            synchronized (this) {
//                if (ticket > 0) {
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("tickets:" + ticket--);
//                }
//            }
        }
    }

    public synchronized void tell(){
        if (ticket > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("tickets:" + ticket--);
        }
    }
}


public class SynchroniedDemo {
    public static void main(String [] args){
        MyThreadDemo m = new MyThreadDemo();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        Thread t3 = new Thread(m);

        t1.start();
        t2.start();
        t3.start();
    }
}

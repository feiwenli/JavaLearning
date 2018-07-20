package com.hand;// shame
// 30题

public class JavaTest01 {
    /* 1
    public void methodA(int i){
        assert i >=0 : methodB();   //void type is not allowed here
        System.out.println(i);
    }

    public void methodB(){
        System.out.println("The value must be negative");
    }

    public static void main(String args []){
        javatestfansi test = new javatestfansi();
        test.methodA(-10);
    }
    */
    /* 2
    public static class Static {
    //public class Static {    //inner class can not have static declarations
        static{
            int x = 5;
        }
        static int x,y; // 覆盖上面的x
        public static void main(String args[]){
            System.out.println("x 00");
            System.out.println(x);  //0
            //x --;
            System.out.println("x-- 00");
            System.out.println(x--);    //--x:-1,x--:0

            System.out.println("x 01");
            System.out.println(x);  //-1
            myMethod();
            System.out.println("total");
            System.out.println(x + y+ ++x); //3
        }
        public static void myMethod(){
            y = x++ + ++x;
            System.out.println("x 02");
            System.out.println(x);  //1

            System.out.println("y 01");
            System.out.println(y);  //0
        }
    }
    */

    /*8
    public static void main(String args[])
    {
        int a = 5;
        System.out.println("Value is - " + ((a < 5) ? 9.9 : 9));    // Value is - 9.0
    }
    */

//}


/*3
class Value {
    public int i = 15;
}
public class javatestfansi {
    public static void main(String argv[]) {
        javatestfansi t = new javatestfansi();
        t.first();
    }
    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }
    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + " " + i);
    }
}
*/

    /*
    class MyParent {
        int x, y;
        MyParent(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int addMe(int x, int y) {
            return this.x + x + y + this.y;
        }
        public int addMe(MyParent myPar) {
            return addMe(myPar.x, myPar.y);
        }
    }
    class MyChild extends MyParent {
        int z;
        MyChild (int x, int y, int z) {
            super(x,y);
            this.z = z;
        }
        public int addMe(int x, int y, int z) {
            return this.x + x + this.y + y + this.z + z;
        }
        public int addMe(MyChild myChi) {
            return addMe(myChi.x, myChi.y, myChi.z);
        }
        public int addMe(int x, int y) {
            return this.x + x + this.y + y;
        }
    }
    public class javatestfansi {
        public static void main(String args[]) {
            MyChild myChi = new MyChild(10, 20, 30);
            MyParent myPar = new MyParent(10, 20);
            int x = myChi.addMe(10, 20, 30);//120
            int y = myChi.addMe(myChi);//120
            int z = myPar.addMe(myPar);//60
            System.out.println(x + y + z);
        }
    }
    */
    public static void main(String args[]){
        int Output = 10;
        boolean b1 = false;
        if((b1 == true) && ((Output += 10) == 20)) {
            System.out.println("We are equal " + Output);
        } else {
            System.out.println("Not equal! " + Output);
        }

    }
}

/*
class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread: run()");
    }
    public void start() {
        System.out.println("MyThread: start()");
    }
}
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("MyRunnable: run()");
    }
    public void start() {
        System.out.println("MyRunnable: start()");
    }
}
public class javatestfansi {
    public static void main(String args[]) {
        MyThread myThread = new MyThread();
        MyRunnable myRunnable = new MyRunna
        ble();
        Thread thread = new Thread(myRunnable);
        myThread.start();
        thread.start();
    }
}*/


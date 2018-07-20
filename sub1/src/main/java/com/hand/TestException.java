package com.hand;

/**
 * 异常
 */

class Exc{
    int a = 10;
    int b = 10;
}

// 自定义异常
class MyException extends Exception{
    MyException(String msg){
        super(msg);
    }
}

public class TestException {
    public static void main(String [] args){
        int temp;
        Exc e = new Exc();
        try {
            temp = e.a / e.b;
            System.out.println(temp);
            tell(e.a,e.b);
        }catch (NullPointerException e2){
            System.out.println("空指针异常："+e2);
        }catch (ArithmeticException e1){
            System.out.println("算数异常："+e1);
        }finally{
            System.out.println("exit");
        }

        yc();
    }

    private static void tell(int a,int b)throws ArithmeticException{
        int t;
        t = a/b;
        System.out.println("t = " + t);

    }

    private static void yc(){
        try{
            throw new MyException("实例化异常对象");
        }catch (MyException e){
            System.out.println(e+".");
        }
    }
}

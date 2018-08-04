package com.hand;

import java.util.Scanner;

/**
 * 动态加载类
 */

interface Office{
    void start();
}

class Word implements Office{

    @Override
    public void start() {
        System.out.println("word start.");
    }
}

class Excel implements Office{

    @Override
    public void start() {
        System.out.println("excel start.");
    }
}

public class ClassDemo02 {
    public static void main(String [] args){
        try {
            String s = new Scanner(System.in).next();
            Class c = Class.forName("com.hand."+s);
            Office office = (Office)c.newInstance();
            office.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

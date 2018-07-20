package com.hand;

import java.util.Scanner;

public class TestScanner {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        System.out.println("姓名：");
        String name = s.next();
        System.out.println("性别：");
        String sex = s.next();
        System.out.println("年龄：");
        int age = s.nextInt();
        System.out.println("Hi! My name is "+name+", I'm "+age+" years old, and i'm a "+sex+".");

    }
}

package com.hand;

/**
 * 获取类的所有方法信息
 */
public class ClassDemo4 {
    public static void main(String [] args){
        String s = "Hello";
        ClassUtil.printClassMessage(s);
        System.out.println("======================================================");
        ClassUtil.printFieldMessage(new Integer(1));
        System.out.println("======================================================");

        ClassUtil.printConMessage("hello");
    }
}

package com.hand;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassDemo5 {
    public static void main(String [] arga){
        //1.要获取一个方法就是获取类的信息，获取类的学习首先要获取类的类类型
        A a1 = new A();
        Class c = a1.getClass();

        //2.获取方法 名称和阐述参数列表
        try {
//            Method m = c.getMethod("print", new Class[]{int.class, int.class})
            Method m = c.getMethod("print", int.class, int.class);
            //方法如果没有返回值就返回null，有返回值就返货具体的返回值
            //方法的反射操作
            Object o = m.invoke(a1, 1,2);
            Method m1 = c.getMethod("print", String.class, String.class);
            m1.invoke(a1,"Hello", "HHJJ");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class A {
    public void print (int a, int b){
        System.out.println(a+b);
    }
    public void print(String a ,String b){
        System.out.println(a.toUpperCase()+" "+b.toLowerCase());
    }

}

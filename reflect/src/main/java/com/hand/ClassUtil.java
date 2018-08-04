package com.hand;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
    /**
     * 打印类的信息，包括类的成员函数
     * @param obj 该对象所属类的信息
     * ClassDemo4  调用
     */

    public static void printClassMessage(Object obj){
        // 要获取类的信息，首先要获取类的类类型
        Class c = obj.getClass();
        //获取类的名称
        System.out.println("类的名称是： "+c.getName());
        /*
        Method类，方法对象
        一个成员方法就是一个Method对象
        getMethods()方法获取的是所有的public的函数，包括继承而来的方法
        getDeclaredMethosd()获取的是所有该类自己声明的方法，不问访问权限
         */
        Method [] methods = c.getMethods();
        for(int i = 0; i<methods.length;i++){
            //得到方法的返回值类型的类类型
            Class returnType = methods[i].getReturnType();
            System.out.print(returnType.getName()+" ");
            //得到方法的名称
            System.out.print(methods[i].getName()+"(");
            // 获取参数类型--->得到的是参数列表的类型的类类型
            Class [] paramTypes = methods[i].getParameterTypes();
            for (Class class1:paramTypes) {
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");
        }

        System.out.println("<================================================>");
        // 获取的是所有的public的成员变量的信息
        // Field [] fs = c.getFields();
        // 获取该类自己声明的成员变量的信息
        printFieldMessage(c);
        printFieldMessage(c);


    }

    /**
     * 获取成员变量的信息
     * @param obj
     */
    static void printFieldMessage(Object obj) {
        Class c = obj.getClass();
        /*
        成员变量也是对象
        java.lang.reflect.field
        field类封装了关于成员变量的操作
        getFields()方法获取的是所有的public的成员变量
        getDeclareedField获取的是该类自己声明的成员变量
        */
        //Field [] f = c.getFields();
        Field[] fs2 = c.getDeclaredFields();
        for (Field field:fs2){
            //得到成员变量的类型的类类型
            Class fieldYype = field.getType();
            String typeName = fieldYype.getName();
            //得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName+" "+fieldName);
        }
    }

    /**
     * 打印对象构造函数的信息
     * @param obj
     */
    public static void printConMessage(Object obj){
        Class c = obj.getClass();
        /*
        构造函数也是对象
        java.lang.constructor 中封装了构造函数的信息
        getConstructor 获取所有的构造函数
        getDeclaredConstructors 得到左右的构造函数
         */
//        Constructor [] cs = c.getConstructors();
        Constructor [] cs = c.getDeclaredConstructors();
        for (Constructor constructor:cs){
            System.out.print(constructor.getName()+"(");
            //获取构造函数的参数列表-->得到的是参数列表的类类型
            Class [] paramTypes = constructor.getParameterTypes();

            for (Class class1 : paramTypes) {
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");
        }
    }
}

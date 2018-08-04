package com.hand;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 通过反射了解集合泛型的本质
 */
public class MethodDemo {
    public static void main(String [] args){

        ArrayList list = new ArrayList();

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("hello");
//        list1.add(20);  error
        Class c1 = list.getClass();
        Class c2 = list1.getClass();
        System.out.println(c1 == c2);   // T
        // 反射的操作都是编译之后的操作
        /*
        c1 == c2 结果返回true说明编译之后集合的泛型是去泛型化的
        java 中集合的泛型，是防止错误输入发，只在编译阶段有效，绕过编译就无效了
        验证：可以通过方法的反射操作，绕过编译
         */

        try {
            Method m = c2.getMethod("add",Object.class);
            m.invoke(list1,20); // 绕过编译操作就绕过了泛型
            System.out.println(list1.size());   //2
            /*for (String string: list1
                 ) {
                System.out.println(string);
            }*/ // 现在不能这样遍历
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

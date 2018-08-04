package com.hand;

import java.lang.reflect.Field;

class Foo {
    void print() {
        System.out.println("Foo");
    }
}
//System.getenv()
public class ClassDemo01 {

    public static void main(String[] args) {
        Foo foo1 = new Foo();
        //任何一个类都是Class的实例对象，且有3种表达方式
        //1,任何一个类都有一个隐含的静态成员变量Class
        Class c1 = Foo.class;

        //2,已经知道该类的对象通过getClass方法
        Class c2 = foo1.getClass();

        /*c1,c2表示了Foo类的类类型（class type）
         * 完事万物皆对象
         * 类也是对象，是Class类的实例对象
         * 这个对象称为该类的类类型
         */
        // 不管c1 或 c2 都代表了Foo类的类类型，一个类只可能是class的一个实例对象
        System.out.println(c1 == c2);   // true

        //3
        try {
            Class c3 = Class.forName("com.hand.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 完全可以通过类的类类型创建该类的实例对象
        try {
            Foo foo = (Foo) c1.newInstance();
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }











    }

}

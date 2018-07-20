package com.hand;

/**
 * 单例模式Singleton
 * 应用场合：有些对象只需要一个就足够了，如古代皇帝
 * 作用：保证整个应用程序中某个实例有且只有一个
 * 类型：饿汉模式、懒汉模式
 */

//饿汉模式
class Singleton{
    // 1、将构造方法私有化，不允许外部直接创建对象
    private Singleton(){

    }
    // 2、创建类的唯一实例，使用private static修饰
    private static Singleton instence = new Singleton();

    // 3、提供一个用于获取实例的方法，使用public static
    public static Singleton getInstence(){
        return instence;
    }
}

// 懒汉模式
class Singleton2{
    // 1、将构造方法私有化，不允许外部直接创建对象
    private Singleton2(){
    }

    // 2、创建类的唯一实例，使用private static修饰
    private static Singleton2 instance;

    // 3、提供一个用于获取实例的方法，使用public static
    public static Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}


public class SingletonDemo {
    public static void main(String [] args){
        Singleton s1 = Singleton.getInstence();
        Singleton s2 = Singleton.getInstence();
        if (s1 == s2){
            System.out.println("s1和s2是同一个实例");
        }
        Singleton2 s3 = Singleton2.getInstance();
        Singleton2 s4 = Singleton2.getInstance();
        if (s3 == s4){
            System.out.println("s3和s4是同一个实例");
        }
    }
}

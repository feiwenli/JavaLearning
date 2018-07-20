package com.hand;

class People{
    private String name;
    private int age;

    public People(String name,int age){
        this();     //调用构造方法
        this.name = name;
        this.age = age;
    }

    public People(){
        System.out.println("无参数的构造方法");
    }

    public void tell(){
        System.out.println(this);   // 表示当前对象，People@1b6d3586
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class TestThis {
    public static void main(String [] args){
        People p = new People("zhangsan", 90);
        p.setAge(45);
        p.setName("张三");
        System.out.println(p.getAge()+" "+p.getName());
        p.tell();
        System.out.println(p);  //People@1b6d3586
    }
}

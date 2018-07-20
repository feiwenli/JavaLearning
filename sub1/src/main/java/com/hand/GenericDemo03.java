package com.hand;

interface Gin<T>{
    void say();
}

class Stt<T> implements Gin<T>{
    private T t;

    public Stt(T t){
        this.t = t;
    }

    @Override
    public void say() {
        System.out.println("nice!");
    }

    public T getT() {
        return t;
    }
}

public class GenericDemo03 {
    public static void main(String [] args){
        Stt<String> s = new Stt<>("youxi");
        System.out.println(s.getT());
        s.say();
    }
}

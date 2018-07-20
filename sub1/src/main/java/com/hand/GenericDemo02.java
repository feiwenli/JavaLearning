package com.hand;

class Conn<T>{
    private T value;

    public Conn(T v){
        this.value = v;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue().toString();
    }
}

public class GenericDemo02 {
    public static void main(String args[]){
        Conn<String> c = new Conn<>("hello");
        System.out.println(c.getValue());
        tell(c);
    }

    /**
     * 通配符： ？
     * @param c
     */
    public static void tell(Conn<?> c){
        System.out.println(c.toString());
    }
}

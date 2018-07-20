package com.hand;

class Point<K,T>{
    private K x;
    private T y;

    public K getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public void setX(K x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }
}

public class GenericDemo01 {
    public static void main(String args[]){
        Point<String,Integer> p = new Point<>();
        p.setX("精度为10");
        p.setY(10);
        System.out.println(p.getX()+" "+p.getY());

    }
}

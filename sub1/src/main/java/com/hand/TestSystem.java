package com.hand;

/**
 * 计算(11111111)2 = (_________)16
 */

public class TestSystem {
    public static void main(String[]args){
        System.out.println(Math.pow(2,7)+ Math.pow(2,6)+Math.pow(2,5)+Math.pow(2,4)+Math.pow(2,3)
                +Math.pow(2,2)+Math.pow(2,1)+Math.pow(2,0));
        System.out.println(Math.pow(2,8)-1);
        System.out.println(Math.round(1.5)+" "+Math.round(-1.5));

        int maxByte = Byte.MAX_VALUE;
        int minByte = Byte.MIN_VALUE;
        System.out.println(maxByte+" "+minByte);
        String s = "99";
        byte b = Byte.parseByte(s);
        System.out.println(b);

        for(int i=0;i<=127;i++){
            System.out.println((char)i+":"+i);
        }

    }
}

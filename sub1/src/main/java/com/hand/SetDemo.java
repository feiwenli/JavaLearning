package com.hand;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String [] args){
        Set<String> s = null;
        s = new HashSet<>();
        s.add("A");
        s.add("b");
        s.add("C");
        System.out.println(s);

        // 有序排放
        Set<String> set = new TreeSet<>();
        set.add("g");
        set.add("K");
        set.add("s");
        set.add("e");
        System.out.println(set);

    }

}

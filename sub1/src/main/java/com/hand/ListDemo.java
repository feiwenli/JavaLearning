package com.hand;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListDemo {

    public static void main(String [] args){
        List<String> lists = null;
        lists = new ArrayList<>();
        lists.add("A");
        lists.add("B");
        for(int i=0; i<lists.size();i++){
            System.out.println(lists.get(i));
        }
        lists.remove(0);
        // 查询是否存在
        System.out.println("indexOf "+lists.indexOf("K"));
        // 是否为空
        System.out.println("isEmpty "+lists.isEmpty());

        List<String> v = null;
        v = new Vector<>();
        v.add("A");
        v.add("B");
        v.remove("B");
        for(int i =0;i<v.size();i++){
            System.out.println(v.get(i));
        }
    }
}

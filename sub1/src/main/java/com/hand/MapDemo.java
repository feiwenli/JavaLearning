package com.hand;

import java.util.*;

public class MapDemo {
    public static void main(String [] args){
        Map<String,String> map = new HashMap<>();
        map.put("k1","jikexy");
        map.put("k2","www");
        map.put("k3","com");
        map.put("k4","java");
        if (map.containsKey("k3")){
            System.out.println("key存在");
        }else {
            System.out.println("key不存在");
        }
        if (map.containsValue("firefox")){
            System.out.println("value存在");
        }else {
            System.out.println("value不存在");
        }

        Set<String> s = map.keySet();
        Iterator<String> i = ((Set) s).iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        Collection<String> c = map.values();
        Iterator<String> i2 = c.iterator();
        while (i2.hasNext()){
            System.out.println(i2.next());
        }
    }
}

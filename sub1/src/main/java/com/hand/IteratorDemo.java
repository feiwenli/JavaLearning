package com.hand;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 只能单向移动
public class IteratorDemo {
    public static void main(String [] args){
        List<String> list = new ArrayList<>();
        list.add("D");
        list.add("K");
        list.add("O");
        // iterator方法返回一个实现了Iterator接口的对象，可以使用这个迭代器对象依次访问集合中的元素
        Iterator<String> iter = list.iterator();

        //删除第一个元素
        iter.next();
        iter.remove();

        for(String i:list){
            System.out.println(i);
        }

//        iter.forEachRemaining(element -> System.out.println("!"+element));
        System.out.println("ooo");
        System.out.println(iter.hasNext());
        while(iter.hasNext()){
            System.out.println("hi");
            String str = iter.next();
            if ("K".equals(str)){
                iter.remove();
            }else {
                System.out.println(iter);   //输出引用
            }
        }
    }
}

package com.hand;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String [] args) {
        /**
         * 当前的相对目录都是基于项目文件下的
         * "../../Hello.txt"  创建在上上一层文件夹中
         * "../Hello.txt"  创建在上一层文件夹中
         * "Hello.txt"  创建在相对目录处
         * "newFiles/Hello.txt" 创建在相对目录下的newFils文件内
         */

        File file = new File("Hello.txt");

        /**
         * 文件的重命名实现文件目录的转换
         * 文件结构必须处于同一个分区
         * 文件处于不同的分区，需要使用文件的拷贝
         */

        if(file.exists()){
            /**
             * 此文件可以是空的，不指向任何实质性的文件,并且文件的路径发生了变化
             * 如果文件已经存在，则文件不会被重命名和转移路径
             */
            File nameto = new File("newHello.txt");
            file.renameTo(nameto);
//            System.out.println(file.isFile());
//            System.out.println(file.isDirectory());
//            file.delete();
//            System.out.println("文件删除成功");
        }else{
            System.out.println("文件不存在");
            try{
                file.createNewFile();
                System.out.println("文件创建成功");
            }catch (IOException e){
                System.out.println("文件无法创建");
            }
        }

    }
}

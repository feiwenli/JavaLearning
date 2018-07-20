package com.hand;

import java.io.File;

/**
 * 遍历文件目录
 */

public class WalkingDirectory {
    public static void main(String [] args){
        printFiles(new File("D:\\code\\javacode"),1);
    }

    public static void printFiles(File dir, int tab){
        if (dir.isDirectory()){
            File next [] = dir.listFiles();
            for (int i =0; i<next.length ; i++){
                for (int j=0; j< tab; j++){
                    System.out.print("|--");
                }
                System.out.println(next[i].getName());
                if (next[i].isDirectory()){
                    printFiles(next[i],tab++);
                }
            }
        }
    }
}

package com.hand;

import java.io.File;

public class FolderDemo {
    public static void main(String [] args){
        /**/
        File folder = new File("my new folder");
        if (folder.mkdir()){
            System.out.println("文件夹创建完成");
        }else{
            if(folder.exists()){
                System.out.println("文件夹已经存在");
            }else{
                System.out.println("文件夹创建失败");
            }
        }
        // 空文件夹才能被删除
        if (folder.delete()){
            System.out.println("done");
        }else {
            System.out.println("fail");
        }

        //改名
        File f1 = new File("my new folder");    // 此文件必须存在才能改名
        f1.mkdirs();    //创建多级目录

        File f2 = new File("rename folder");
        if (f1.renameTo(f2)){
            System.out.println("done");
        }else{
            System.out.println("fail");
        }
    }
}

package com.hand;

import java.io.*;

class WriteFile extends Thread{

    int block;
    File file;
    int L = 100;

    WriteFile(File file, int block){
        this.file = file;
        this.block = block;
    }

    @Override
    public void run() {
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.seek((block-1)*L);
            raf.writeBytes("This is block"+block);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class RandomAccessFileDemo {

    static File file = new File("test.txt");

    public static void main(String [] args){

        // 写入
//        if (file.exists()){
//            file.delete();
//        }
//
//        // 严格按照指定的block顺序写的，与线程创建的顺序无关
//        new WriteFile(file,1).start();
//        new WriteFile(file,2).start();
//        new WriteFile(file,3).start();
//        new WriteFile(file,4).start();
//        new WriteFile(file,5).start();
//        new WriteFile(file,6).start();

        //读取
        try {
            RandomAccessFile read = new RandomAccessFile(file,"r");
            read.seek(500);
            byte [] str = new byte[20];
            read.read(str);
            String in = new String(str);
            System.out.println(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

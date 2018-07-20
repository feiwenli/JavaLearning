package com.hand;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ApacheIODemo {
    public static void main(String [] args){
        File file = new File("test.txt");
        File file2 = new File("text_new.txt");
        try {
//            String input = FileUtils.readFileToString(file, "UTF-8");
//            System.out.println(input);
            FileUtils.copyFile(file,file2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

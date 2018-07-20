package com.hand;

import java.io.*;

public class ReadFileDemo {
    public static void main(String [] args){
        File file = new File("TestJavaOnly.txt");
        if (file.exists()){
            System.out.println("exits");
            try {
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis, "utf-8");
                BufferedReader br = new BufferedReader(isr);

                String line;
                while ((line = br.readLine())!=null){
                    System.out.println(line);
                }

                br.close();
                isr.close();
                fis.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File newfile = new File("TestJavaOnlyCopy.txt");
        try {
            FileOutputStream fos = new FileOutputStream(newfile);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("NPC2\n");

            bw.close();
            osw.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

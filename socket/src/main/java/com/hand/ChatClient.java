package com.hand;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[]args){
        try{
            Socket s = new Socket("127.0.0.1",12345);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            dos.writeUTF("success");
            dos.flush();
//            Scanner reader = new Scanner(System.in);

//            String line;

//            while (reader.hasNext()){
//                line = reader.next();
//                System.out.println("client: "+line);
//                writer.write(line);
//                writer.write("101010");
//                writer.flush();
//
//            }
//
//            reader.close();

            dos.close();


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

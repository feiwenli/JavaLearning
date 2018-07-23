package com.hand;

import java.io.*;
import java.net.*;

public class ChatServerSimple {
    public static void main(String [] args){
        try{
            ServerSocket server = new ServerSocket(12345);
            Socket s = server.accept();
            System.out.println("OK!");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            System.out.println(br.readLine());
            String line;
            while ((line = br.readLine())!="null") {
                System.out.println("Client:" + line);
            }
            br.close();


        }catch(IOException e){
            e.printStackTrace();
            return;
        }

    }
}

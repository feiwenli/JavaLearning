package com.hand;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[]args){
        try{
            Socket s = new Socket("127.0.0.1",12345);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(s.getOutputStream());
//            BufferedReader bbrr = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            System.out.println("Server:"+br.readLine());
            while(br.readLine()!="exit"){
                pw.print(br.readLine());
//                pw.flush();
//                System.out.println("Server:"+bbrr.readLine());
                System.out.println("Client:"+br.readLine());
            }
            br.close();
            pw.close();
//            bbrr.close();
            s.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

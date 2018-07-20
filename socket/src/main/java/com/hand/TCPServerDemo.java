package com.hand;

import java.io.* ;
import java.net.*;

public class TCPServerDemo {
    public static void main(String [] args){
        try{
            ServerSocket ss = new ServerSocket(12345);
            while(true){
                Socket s = ss.accept();
                System.out.println("connected!");
                DataInputStream dis = new DataInputStream(s.getInputStream());
                System.out.println(dis.readUTF());
                OutputStream os = s.getOutputStream();
                DataOutputStream dos = new DataOutputStream	(os);
                dos.writeUTF("Hello , "+s.getInetAddress()+" ports "+s.getPort());
                dis.close();
                dos.close();
                s.close();
                System.out.println("closed!");
            }
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("程序运行错误："+e);
        }
    }
}
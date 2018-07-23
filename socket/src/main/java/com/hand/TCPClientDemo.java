package com.hand;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClientDemo {
    public static void main (String[] args){
        try {
            Socket s = new Socket("127.0.0.1",12345);
            Scanner in = new Scanner(System.in);
            String str = in.next();

            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(str);

            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream (is);
            System.out.println(dis.readUTF());

            dos.flush();
            dos.close();

            dis.close();
            s.close();
        }catch(ConnectException connExc){
            System.out.println("连接失败！");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

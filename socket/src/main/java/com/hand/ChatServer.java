package com.hand;

import javax.swing.*;
import java.io.* ;
import java.net.*;
import java.util.Vector;

class ServerListener extends Thread{
    public void run(){
        try{
            // 1-65535
            int port = 12345;
            ServerSocket ss = new ServerSocket(port);
            while(true){
                System.out.println("accept 之前");
                Socket socket = ss.accept();
                JOptionPane.showMessageDialog(null,"有客户端连接到了本地的"+port+"端口");
                //将socket传递给新的线程
                ChatSocket cs = new ChatSocket(socket);
                cs.start();
                ChatManage.getChatManage().add(cs);
            }
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("程序运行错误："+e);
        }
    }
}

class ChatSocket extends Thread{

    Socket socket;

    ChatSocket(Socket socket){
        this.socket = socket;
    }

    public void out(String out) {
        try {
            socket.getOutputStream().write(out.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
       int count = 0;
        while (true){
            count++;
            out("loop+"+count);
        }
//        try {
//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader(
//                            socket.getInputStream(),"UTF-8"
//                    )
//            );
//            String line = null;
//            while((line = br.readLine())!=null){
//                ChatManage.getChatManage().publish(this,line);
//            }
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

class ChatManage{
    private ChatManage(){}
    private static final ChatManage cm = new ChatManage();
    public static ChatManage getChatManage(){
        return cm;
    }

    Vector<ChatSocket> vector = new Vector<ChatSocket>();

    public void add (ChatSocket cs){
        vector.add(cs);
    }

    public void publish(ChatSocket cs, String out){
        for (int i = 0; i<vector.size();i++){
            ChatSocket csChatSocket = vector.get(i);
            if (!cs.equals(csChatSocket)){
                csChatSocket.out(out);
            }
        }
    }
}



public class ChatServer {
    public static void main(String[] args) {
        new ServerListener().start();
    }
}
package com.hand;

import java.io.*;
import java.net.*;

public class ChatServerSimple {
    public static void main(String [] args){
        try{
            ServerSocket server = new ServerSocket(12345);
            Socket s = server.accept();
            System.out.println("OK!");
            String line;
            BufferedReader is = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter os = new PrintWriter(s.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client:"+is.readLine());
            line = sin.readLine();
            while(!line.equals("bye")){
                line = sin.readLine();
                os.println(line);
                os.flush();
                System.out.println("Server:"+line);
                System.out.println("Client:"+is.readLine());
            }
            is.close();
            os.close();
            sin.close();
            s.close();
            server.close();

        }catch(IOException e){
            e.printStackTrace();
            return;
        }

    }
}

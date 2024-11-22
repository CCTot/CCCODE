package com.zcc.myNetTCP;

import java.io.*;
import java.net.*;


public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(10086);

        Socket socket = ss.accept();


        BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        socket.getInputStream();
        int b;
        while((b = bf.read()) != -1){
            System.out.print((char)b);
        }
    }
}

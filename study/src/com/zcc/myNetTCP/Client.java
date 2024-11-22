package com.zcc.myNetTCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        //创建Socket对象，在创建对象的同时就会链接服务端
        //所以需要先运行服务端
        Socket socket = new Socket("127.0.0.1",10086);

        //从链接通道获取输出流
        OutputStream os = socket.getOutputStream();

        os.write("你好\r\n你好你好".getBytes());

        os.close();
        socket.close();

    }

}

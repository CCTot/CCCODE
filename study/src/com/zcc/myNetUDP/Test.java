package com.zcc.myNetUDP;

import java.io.IOException;
import java.net.*;

public class Test {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket();

        String str = "你好";
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10086;

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

        ds.send(dp);

        ds.close();

    }
}

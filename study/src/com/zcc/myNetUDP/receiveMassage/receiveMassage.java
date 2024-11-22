package com.zcc.myNetUDP.receiveMassage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class receiveMassage {

    public static void main(String[] args) throws IOException {

        //接收数据

        DatagramSocket ds = new DatagramSocket(10086);


        //接受数据包
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);


        while (true) {
            ds.receive(dp);

            //解析数据
            byte[] data = dp.getData();
            int len = dp.getLength();
            InetAddress address = dp.getAddress();
            int port =dp.getPort();

            System.out.println(new String(data,0,len));
        }

    }
}

package com.zcc.threadDemo;

import com.zcc.Examine.myThread1;
import com.zcc.Examine.myThread2;

public class Test  {
    public static void main(String[] args) {
        myThread t1 = new myThread();
        myThread t2 = new myThread();

        t1.setName("zcc");
        t2.setName("cyd");



        t1.start();
        t2.start();
    }
}

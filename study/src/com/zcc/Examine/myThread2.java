package com.zcc.Examine;

public class myThread2 extends Thread{
    public void run (){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"@"+i);
            //Thread.yield();
        }
    }
}

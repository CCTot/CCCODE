package com.zcc.Examine;

public class myThread1 extends Thread{
    public void run (){
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+"@"+i);
        }
    }
}

package com.zcc.waitAndNotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class foodie extends Thread{

    ArrayBlockingQueue<String> queue;
    public foodie (ArrayBlockingQueue<String> queue) {this.queue = queue;}

    public void run(){

        while(true){
            try {
                queue.put("面条");
                System.out.println("厨师做了一碗面条");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

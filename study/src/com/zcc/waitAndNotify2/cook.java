package com.zcc.waitAndNotify2;
import java.util.concurrent.ArrayBlockingQueue;
public class cook extends Thread{

    ArrayBlockingQueue<String> queue;
    public cook (ArrayBlockingQueue<String> queue) {this.queue = queue;}

    public void run(){
        while(true){
            String food = null;
            try {
                food = queue.take();
                System.out.println(food);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

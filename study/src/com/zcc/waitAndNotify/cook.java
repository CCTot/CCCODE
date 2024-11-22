package com.zcc.waitAndNotify;

//生产者线程
public class cook extends Thread{

    public void run(){

        while(true){
            synchronized(desk.lock){
                if(desk.count == 0){
                    break;
                }else{
                    if(desk.foodFlag == 1){
                        try {
                            desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        System.out.println("厨师正在做面条");
                        desk.foodFlag = 1;
                        desk.lock.notifyAll();
                    }
                }
            }
        }
    }

}

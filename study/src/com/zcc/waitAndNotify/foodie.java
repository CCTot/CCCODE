package com.zcc.waitAndNotify;

import static com.zcc.waitAndNotify.desk.count;
import static com.zcc.waitAndNotify.desk.foodFlag;

//消费者线程
public class foodie extends Thread {

    public void run() {

        while (true) {
            synchronized (desk.lock) {
                if (count == 0) {
                    break;
                } else {
                    if (foodFlag == 0) {
                        try {
                            desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        count--;
                        System.out.println("吃货还能吃" + count + "碗");
                        desk.lock.notifyAll();
                        foodFlag = 0;
                    }
                }
            }
        }
    }

}

package com.Test.threadTest;

import java.util.ArrayList;
import java.util.Collections;

public class myThread extends Thread {

    ArrayList<Integer> list;

    public myThread(ArrayList<Integer> list) {
        this.list = list;
    }


    public void run() {
        ArrayList boxList = new ArrayList<>();
        while (true) {
            synchronized (myThread.class) {
                if (list.size() == 0) {
                    System.out.println(getName()+boxList);
                    break;
                } else {
                    Collections.shuffle(list);
                    int price = list.remove(0);
                    boxList.add(price);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

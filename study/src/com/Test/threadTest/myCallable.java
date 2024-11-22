package com.Test.threadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class myCallable implements Callable<Integer> {
    ArrayList<Integer> list;

    public myCallable(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        ArrayList<Integer> boxList = new ArrayList<>();
        while (true) {
            synchronized (myThread.class) {
                if (list.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + boxList);
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

        if (boxList.isEmpty()) {
            return null;
        } else {
            return Collections.max(boxList);
        }

    }
}

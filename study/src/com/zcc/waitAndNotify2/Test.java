package com.zcc.waitAndNotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        cook c = new cook(queue);
        foodie f  =new foodie(queue);

        c.start();
        f.start();
    }


}

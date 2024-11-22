package com.zcc.waitAndNotify;

public class waitAndNotifyTest {

    public static void main(String[] args) {
        cook c =new cook();
        foodie f = new foodie();

        c.setName("厨师");
        f.setName("吃货");

        c.start();
        f.start();
    }

}

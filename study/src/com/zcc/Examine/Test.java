package com.zcc.Examine;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.stream.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        myThread1 t1 = new myThread1();
        myThread2 t2 = new myThread2();

        t1.setName("zcc");
        t2.setName("cyd");

        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}

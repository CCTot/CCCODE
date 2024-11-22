package com.zcc.threadPool;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,                            //核心线程数量，可以小于0
                6,                                        //最大线程数量，不能小于0，最大线程数量>=核心线程数量
                60,                                       //空闲线程最长存活时间
                TimeUnit.SECONDS,                         //时间单位
                new ArrayBlockingQueue<>(3),      //任务队列
                Executors.defaultThreadFactory(),         //创建线程工厂
                new ThreadPoolExecutor.AbortPolicy()      //线程的拒绝策略
        );

    }
}

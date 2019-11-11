package com.glp.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zmm
 * @date 2019/11/2
 */


public class ActivityUtils {


   static Lock lock=  new ReentrantLock();

    private static Integer count = 0;

    private static Object jt = new Object();

    public   static void incrementCount() {

    }

    public static void main(String[] args) throws InterruptedException {

        for (int a = 1; a < 10; a++
                ) {
            new Thread(() -> {
                incrementCount();
            }).start();
        }

        Thread th = new Thread(() -> {

            incrementCount();
        });
        th.start();

        Thread.sleep(3L);
        System.out.println(count);
    }
}





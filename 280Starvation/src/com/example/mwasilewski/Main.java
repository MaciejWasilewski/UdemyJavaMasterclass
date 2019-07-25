package com.example.mwasilewski;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Worker("\t2", lock));
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.execute(new Worker("1", lock));
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.execute(new Worker("\t\t3", lock));
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.execute(new Worker("\t\t\t4", lock));

        executorService.shutdown();
    }
}


class Worker implements Runnable {
    private int runCount = 1;
    private final String id;
    private final Lock lock;

    public Worker(String id, Lock lock) {
        this.id = id;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.format(id + " %s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
            } finally {
                lock.unlock();
            }
        }
    }
}
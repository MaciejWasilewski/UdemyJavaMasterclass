package com.example.mwasilewski;


public class Main {
    public static String lock1 = "lock1";
    public static String lock2 = "lock2";

    public static void main(String[] args) {

        Thread1 thread1 = new Thread1(lock1, lock2,1);
        Thread1 thread2 = new Thread1(lock1, lock2,2);
        thread1.start();
        thread2.start();
    }

}


class Thread1 extends Thread {
    private final String lock1;
    private final String lock2;
    int num;

    Thread1(String lock1, String lock2, int num) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.num=num;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("Thread"+num+": has " + lock1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread"+num+": waiting for " + lock2);
            synchronized (lock2) {
                System.out.println("Thread"+num+": has lock1 and " + lock2);
            }
            System.out.println("Thread"+num+": released " + lock2);
        }
        System.out.println("Thread"+num+": released " + lock1 + ". Exiting.");
    }
}
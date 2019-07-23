package com.example.mwasilewski;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from another thread "+currentThread().getName());
        try{
            Thread.sleep(3000);
            System.out.println("Three seconds have passed");

        } catch (InterruptedException e) {
            System.out.println("Another thread woke me up!");
            e.printStackTrace();
            return;
        }
        System.out.println("Outside sleep block");

    }
}

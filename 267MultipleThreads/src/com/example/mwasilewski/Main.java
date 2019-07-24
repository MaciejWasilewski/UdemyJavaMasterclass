package com.example.mwasilewski;

public class Main {

    public static void main(String[] args) {
        Countdown c1 = new Countdown();
        Countdown c2 = new Countdown();
        CountdownThread t1 = new CountdownThread(c1);
        CountdownThread t2 = new CountdownThread(c1);
        t1.setName("T 1");
        t2.setName("T 2");
        t1.start();
        t2.start();
    }
}

class Countdown {
    private Integer i = 10;

    synchronized void doCountdown() {

        String st = "\t" + Thread.currentThread().getName() + "\t";
//        for(int i=10;i>0;i--)
//        {
//            System.out.println(st+"i="+i);
////            try {
////                Thread.sleep(10);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//        }

        while (i > 0) {
            synchronized (this){System.out.println(st + (i--));}
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown threadCountdown) {
        this.threadCountdown = threadCountdown;

    }

    @Override
    public void run() {
        threadCountdown.doCountdown();
    }
}
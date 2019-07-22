package com.example.mwasilewski;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from the main thread");
        Thread anotherThread=new AnotherThread();
        anotherThread.start();
        Thread thread=new Thread(){
            @Override
            public void run() {
                System.out.println("Hello from the second thread");
            }
        };
        thread.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("Hello from second anonymous thread");
            }
        }.start();
        new Thread(() -> System.out.println("Hello from third anonymous thread")).start();
        System.out.println("Hello again from the main thread");
    }
}

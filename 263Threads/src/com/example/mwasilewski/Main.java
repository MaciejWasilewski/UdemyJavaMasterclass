package com.example.mwasilewski;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from the main thread");
        Thread anotherThread=new AnotherThread();
        anotherThread.start();
//        anotherThread.interrupt();
//        anotherThread=new AnotherThread();
//        anotherThread.run();
        Thread thread= new Thread(() -> System.out.println("Hello from the second thread"));
        try {
            anotherThread.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();
        new Thread(() -> System.out.println("Hello from second anonymous thread")).start();
        new Thread(() -> System.out.println("Hello from third anonymous thread")).start();
        System.out.println("Hello again from the main thread");
        new Thread(new MyRunnable()).start();

        new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println("Hello from anonymous extension to MyRunnable!");
            }
        }).start();
    }
}

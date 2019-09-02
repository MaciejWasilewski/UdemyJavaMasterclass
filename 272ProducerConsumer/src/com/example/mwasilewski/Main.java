package com.example.mwasilewski;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.example.mwasilewski.Main.EOF;

public class Main {
    static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer producer = new MyProducer(buffer, "* producer1 *");
        MyConsumer consumer1 = new MyConsumer(buffer, "*** consumer1 ***");
        MyConsumer consumer2 = new MyConsumer(buffer, "**** consumer2 ****");

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(() -> {
            System.out.println("I'm being printed by the Callable lambda function");
            return "This is callable result";
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.out.println("Thread running the task was interrupted.");
        }

        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private final ArrayBlockingQueue<String> buffer;
    private String id;
    private ReentrantLock bufferLock;

    public MyProducer(ArrayBlockingQueue<String> buffer, String id) {
        this.buffer = buffer;
        this.id = id;
    }


    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String s : nums) {
            System.out.println(id + " adding... " + s);
            try {
                buffer.put(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted.");
                e.printStackTrace();
            }
        }
        System.out.println(id + " exit");
        try {
            buffer.put(EOF);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyConsumer implements Runnable {
    private final ArrayBlockingQueue<String> buffer;
    private String id;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (buffer) {
                    if (buffer.isEmpty()) {
                        //System.out.println(id + " buffer is empty");
//                    bufferLock.unlock();
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(id + " exiting");
//                    bufferLock.unlock();
                        break;
                    } else {
                        System.out.println(id + " removed " + buffer.take());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
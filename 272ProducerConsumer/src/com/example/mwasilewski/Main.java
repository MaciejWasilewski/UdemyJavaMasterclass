package com.example.mwasilewski;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

import static com.example.mwasilewski.Main.EOF;

public class Main {
    static final String EOF = "EOF";

    public static void main(String[] args) {
        final List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService= Executors.newFixedThreadPool(4);

        MyProducer producer = new MyProducer(buffer, "* producer1 *", bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, "*** consumer1 ***", bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, "**** consumer2 ****", bufferLock);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future=executorService.submit(()->{
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
    private final List<String> buffer;
    private String id;
    private final ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String id, ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.id = id;
        this.bufferLock = reentrantLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String s : nums) {
            System.out.println(id + " adding... " + s);
            bufferLock.lock();
            try {
                buffer.add(s);
            } finally {
                bufferLock.unlock();
            }

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted.");
                e.printStackTrace();
            }
        }
        System.out.println(id + " exit");
        bufferLock.lock();
        try {
            buffer.add(EOF);
        } finally {
            bufferLock.unlock();
        }
    }
}

class MyConsumer implements Runnable {
    private final List<String> buffer;
    private String id;
    private final ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String id, ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.id = id;
        this.bufferLock = reentrantLock;
    }

    @Override
    public void run() {
        while (true) {
            bufferLock.lock();
            try {
                if (buffer.isEmpty()) {
                    //System.out.println(id + " buffer is empty");
//                    bufferLock.unlock();
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(id + " exiting");
//                    bufferLock.unlock();
                    break;
                } else {
                    System.out.println(id + " removed " + buffer.remove(0));
                }
            } finally {
                bufferLock.unlock();
            }

        }
    }
}
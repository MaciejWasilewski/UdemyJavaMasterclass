package com.example.mwasilewski;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);
        SharedResource sharedResource=new SharedResource(worker1);
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(()->worker1.work(sharedResource, worker2));
        executorService.submit(()->worker2.work(sharedResource, worker1));
    }
}

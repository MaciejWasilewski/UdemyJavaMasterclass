package com.example.mwasilewski;

import java.nio.channels.Pipe;

public class Worker {
    private String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }
    public synchronized void work(SharedResource sharedResource, Worker worker)
    {
        while(active)
        {
            if(sharedResource.getOwner()!=this)
            {
                try{
                    wait(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            if(worker.isActive())
            {
                System.out.println(getName()+": give the resource to the "+worker.getName());
                sharedResource.setOwner(worker);
                continue;
            }
            System.out.println(getName()+": working on a shared resource");
            active=false;
        }
    }
}

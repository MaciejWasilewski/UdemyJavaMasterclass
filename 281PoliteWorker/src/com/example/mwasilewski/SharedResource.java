package com.example.mwasilewski;



public class SharedResource {
    private Worker owner;

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker worker) {
        owner=worker;
    }

    public SharedResource(Worker owner) {
        this.owner = owner;
    }
}

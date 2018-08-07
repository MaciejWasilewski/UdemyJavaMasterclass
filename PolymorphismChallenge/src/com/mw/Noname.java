package com.mw;

public class Noname extends Car {
    public Noname() {
        super(4, 1, 1, "Unknown");
    }

    @Override
    public void startengine() {
        System.out.println("Unknown started");
    }
}

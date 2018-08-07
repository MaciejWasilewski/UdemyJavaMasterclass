package com.mw;

public class Ford extends Car {
    public Ford() {
        super(4, 16, 1, "Ford");
    }

    @Override
    public void startengine() {
        System.out.println("Ford started.");
    }
}

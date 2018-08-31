package com.mw;

public class Dog extends Animal{
    public Dog(String name) {
        super("Dog of a name "+name);
    }

    @Override
    public void eat() {
        System.out.println("Dog "+getName()+" eats.");
    }

    @Override
    public void breathe() {
        System.out.println("Dog "+getName()+" breathes.");
    }
}

package com.mw;

public class Dog extends Animal {
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

//    public Dog(int size, int weight, String name, int eyes, int legs, int tail, int teeth, String coat) {
//        super(1, 1, size, weight, name);
//        th
//    }

    public Dog(int size, int weight, String name, int eyes, int legs, int tail, int teeth, String coat) {
        super(1, 1, size, weight, name);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    @Override
    public void eat() {
        System.out.println(super.getName() + " is chewing");
    }

    public void walk() {
        System.out.println("Dog is walking.");
        move(5);
    }

    @Override
    public void move(int speed) {
        System.out.println("Overriden move() method from Dog class called.");
        super.move(speed);
    }

    public void run() {
        System.out.println("Dog is running.");
        super.move(10); //TODO: delete "super."
    }
}

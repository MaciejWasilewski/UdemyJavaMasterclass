package com.mw;

public class Car extends Vehicle {
    private int wheels;
    private int gear;

    public Car(String name, int wheels, int gear, double speed, double direction) {
        super(name,speed, direction);
        this.wheels = wheels;
        this.gear = gear;
    }

    public int getWheels() {
        return wheels;
    }

    public int getGear() {
        return gear;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public void steer(double direction)
    {
        super.setDirection(direction);
        super.move();
    }
    public void changeGear(int gear)
    {
        this.gear=gear;
        System.out.println("The car is now on "+this.gear+" gear");
    }
    public void accelerate(double newVelocity)
    {
        setSpeed(newVelocity);
        move();
    }
}

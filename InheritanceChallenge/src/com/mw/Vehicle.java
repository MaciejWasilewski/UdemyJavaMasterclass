package com.mw;

public class Vehicle {
    private String name;
    private double speed;
    private double direction;

    public Vehicle(String name, double speed, double direction) {
        this.name = name;
        this.speed = speed;
        this.direction = direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getDirection() {
        return direction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public void move() {
        System.out.println("Vehicle "+name+" moves with the speed " + speed + " in the direction: " + direction + ".");
    }
}

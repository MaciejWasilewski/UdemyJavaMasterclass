package com.mw;

public class Car {
    private int noWheels;
    private int noCylinders;
    private int noEngines;
    private String name;

    public Car(int noWheels, int noCylinders, int noEngines, String name) {
        this.noWheels = noWheels;
        this.noCylinders = noCylinders;
        this.noEngines = noEngines;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void startengine()
    {
        System.out.println("Engine of generic car started");
    }
    public int getNoWheels() {
        return noWheels;
    }

    public void setNoWheels(int noWheels) {
        this.noWheels = noWheels;
    }

    public int getNoCylinders() {
        return noCylinders;
    }

    public void setNoCylinders(int noCylinders) {
        this.noCylinders = noCylinders;
    }

    public int getNoEngines() {
        return noEngines;
    }

    public void setNoEngines(int noEngines) {
        this.noEngines = noEngines;
    }
}

package com.mw;

import java.util.ArrayList;

public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int gearNumber = 0;
    boolean clutchIsIn=false;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);
    }
    public void operateClutch(boolean in)
    {
        this.clutchIsIn=in;
    }
    public void addGear(int number, double ratio)
    {
        if(number>0&&number<=maxGears)
        {
            this.gears.add(new Gear(number, ratio));
        }
    }
    public void changeGear(int newGear)
    {
        if(newGear>-1 && newGear<this.gears.size() && this.clutchIsIn)
        {
            this.gearNumber=newGear;
            System.out.println("Gear " +newGear+" selected.");
        }else {
            System.out.println("Grind!");
            this.gearNumber=0;
        }
    }
    public double wheelSpeed(int revolutions)
    {
        if(clutchIsIn)
        {
            System.out.println("Scream!");
            return 0.0;
        }else
        {
            return (double) revolutions*gears.get(gearNumber).ratio;
        }
    }
    private class Gear {
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
            System.out.println("This gearNumber is from outer class: "+Gearbox.this.gearNumber);
            System.out.println("And this gearNumber is from inner class: "+this.gearNumber);
        }

        public double driveSpeed(int revs) {
            return (double) revs * this.ratio;

        }
    }
}

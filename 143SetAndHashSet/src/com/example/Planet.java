package com.example;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod);
    }

    @Override
    public boolean addMoon(HeavenlyBody moon) {
        if (moon.getClass() == Moon.class) {
            return super.addMoon(moon);
        }
        return false;
    }
}

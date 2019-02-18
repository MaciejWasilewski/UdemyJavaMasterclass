package com.example;

import java.util.*;

public class Main {
    private static Map<Integer, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.hashCode(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.hashCode(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.hashCode(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.hashCode(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.hashCode(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 4.5);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.hashCode(), temp);
        planets.add(temp);
        temp = new Planet("Europa", 10759);
        solarSystem.put(temp.hashCode(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.hashCode(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.hashCode(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.hashCode(), temp);
        planets.add(temp);
        planets.forEach(s -> {
            System.out.println(s.getName());
            s.getSatellites().forEach(x -> System.out.println("\t" + x.getName()));
        });
        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }
        moons.forEach(s -> System.out.println(s.getName()));
        HeavenlyBody pluto = new Planet("Pluto", 248);
        planets.add(pluto);
        planets.forEach(s -> {
            System.out.println(s.getName() + " " + s.getOrbitalPeriod());
            s.getSatellites().forEach(x -> System.out.println("\t" + x.getName() + ": " + x.getOrbitalPeriod()));
        });
        System.out.println("\n");
        System.out.println(planets.size());
        System.out.println(moons.size());
        solarSystem.keySet().forEach(s -> {
            if (solarSystem.get(s).getName().equals("Europa")) {
                System.out.println(solarSystem.get(s).getName() + " " + solarSystem.get(s).getOrbitalPeriod());
            }
        });
        for (HeavenlyBody m : moons) {
            for (HeavenlyBody p : planets) {
                if (!(m.equals(p) == p.equals(m))) {
                    System.out.println(m.getName());
                    System.out.println(p.getName());
                }
            }
        }
        System.out.println(solarSystem.get(HeavenlyBody.staticHashCode("Europa",Planet.class.toString())));
        System.out.println(solarSystem.get(HeavenlyBody.staticHashCode("Europa",Moon.class.toString())));
    }
}

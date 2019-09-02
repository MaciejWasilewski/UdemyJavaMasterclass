package com.example;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

enum BodyType {
    PLANET,
    MOON,
}

public abstract class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
//    private final BodyType type;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
//        this.type = type;
        satellites = new HashSet<>();

    }

    public String getName() {
        return name;
    }

//    public BodyType getType() {
//        return type;
//    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {

        return new HashSet<>(this.satellites);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeavenlyBody)) return false;
        HeavenlyBody that = (HeavenlyBody) o;
        return Objects.equals(getName(), that.getName()) && (this.getClass() == o.getClass());
    }

    @Override
    public int hashCode() {
        return staticHashCode(this.name, this.getClass().toString());
    }
    public static int staticHashCode(String name, String classString)
    {
        return Objects.hash(name, classString);
    }

    @Override
    public String toString() {
        return "HeavenlyBody{" +
                "name='" + name + '\'' +
                ", orbitalPeriod=" + orbitalPeriod +
                ", class="+getClass().toString()+
        '}';
    }
}

package com.example;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class HeavenlyBody{
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        satellites=new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }
    public boolean addMoon(HeavenlyBody moon)
    {
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
        return Double.compare(that.getOrbitalPeriod(), getOrbitalPeriod()) == 0 &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getOrbitalPeriod());
    }
}

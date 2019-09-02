package com.mw;

public class Team implements Comparable<Team> {
    private int won=0;
    private int lost=0;
    private int draw=0;
    private String name;

    public Team(String name, int won) {
        this.name = name;
        this.won=won;
    }
    public int ranking()
    {
        return 2*won-lost;
    }

    @Override
    public int compareTo(Team o) {
        return ranking()-o.ranking();
    }

    @Override
    public String toString() {
        return name+": "+ranking();
    }
}

package com.mw;

public class Main {

    public static void main(String[] args) {
        Team x = new Team("maciek", 1);
        Team y = new Team("Aneta", 2);
        Team z = new Team("Wroti", 0);
        League<Team> l = new League<Team>();
        l.addTeam(x);
        l.addTeam(y);
        l.addTeam(z);
        l.printInOrder();
    }
}

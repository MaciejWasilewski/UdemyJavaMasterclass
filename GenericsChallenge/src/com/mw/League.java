package com.mw;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private ArrayList<T> teams = new ArrayList<T>();

    public void printInOrder() {
        Collections.sort(teams, Collections.<T>reverseOrder());
        StringBuilder builder = new StringBuilder("Teams in order:\n");
        for (T team : teams) {
            builder.append("\t").append(team).append("\n");
        }
        System.out.println(builder.toString());
    }

    public void addTeam(T team) {
        teams.add(team);
    }
}

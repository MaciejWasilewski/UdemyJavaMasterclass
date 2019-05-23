package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        locations.put(0, new Location(0, "In front of the computer"));
        locations.put(1, new Location(1, "Before small brick building"));
        locations.put(2, new Location(2, "Top of the hill"));
        locations.put(3, new Location(3, "Inside building"));
        locations.put(4, new Location(4, "In a valley"));
        locations.put(5, new Location(5, "In the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
        locations.get(1).addExit("Q", 0);

        locations.get(2).addExit("N", 5);
        locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
        locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        locations.get(4).addExit("Q", 0);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
        locations.get(5).addExit("Q", 0);

        int loc = 1;
        String locCandidate;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            System.out.println(locations.get(loc).getExits());
            if (loc == 0) {
                break;
            }
            while (true) {
                if (scanner.hasNext()) {
                    locCandidate = scanner.nextLine();
                    if (locCandidate.equals("W") || locCandidate.equals("E") || locCandidate.equals("S") || locCandidate.equals("N") || locCandidate.equals("Q")) {
                        break;
                    } else {
                        System.out.println("You should enter a direction (WESN)!");
                    }
                } else {
                    System.out.println("You should enter a direction (WESN)!");
                }
            }

            if (!locations.get(loc).getExits().containsKey(locCandidate)) {
                System.out.println("You cannot go in that direction");

            } else {
                loc = locations.get(loc).getExits().get(locCandidate);
            }
        }

    }
}

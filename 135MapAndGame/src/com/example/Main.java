package com.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> exits = new HashMap<>();
        locations.put(0, new Location(0, "In front of the computer", null));
        exits.put("W", 2);
        exits.put("E", 3);
        exits.put("S", 4);
        exits.put("N", 5);
        locations.put(1, new Location(1, "Before small brick building", exits));
        exits = new HashMap<>();
        exits.put("N", 5);
        locations.put(2, new Location(2, "Top of the hill", exits));
        exits = new HashMap<>();
        exits.put("W", 1);
        locations.put(3, new Location(3, "Inside building", exits));
        exits = new HashMap<>();
        exits.put("N", 1);
        locations.put(4, new Location(4, "In a valley", exits));
        exits = new HashMap<>();
        exits.put("S", 1);
        exits.put("W", 2);
        locations.put(5, new Location(5, "In the forest", exits));

        Map<String, String> abbrev = new HashMap<>();
        abbrev.put("east", "E");
        abbrev.put("e", "E");
        abbrev.put("west", "W");
        abbrev.put("w", "W");
        abbrev.put("north", "N");
        abbrev.put("n", "N");
        abbrev.put("south", "S");
        abbrev.put("s", "S");
        abbrev.put("quit", "Q");
        abbrev.put("q", "Q");
        int loc = 1;
        String locCandidate;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            System.out.println(locations.get(loc).getExits());
            if (loc == 0) {
                break;
            }
            while (true) {
                if (scanner.hasNextLine()) {
                    locCandidate = scanner.nextLine();
                    List<String> str = Arrays.stream(locCandidate.toLowerCase()
                            .split("[,.; ]+"))
                            .map(abbrev::get)
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList());
                    if (!str.isEmpty()) {
                        locCandidate = str.get(0);
                        break;
                    }
//                    if (Arrays.stream(locCandidate.toLowerCase().split("[,.; ]+")).anyMatch(Predicate.isEqual("east"))) {
//                        locCandidate = "E";
//                        break;
//                    }
//                    if (Arrays.stream(locCandidate.toLowerCase().split("[,.; ]+")).anyMatch(Predicate.isEqual("west"))) {
//                        locCandidate = "W";
//                        break;
//                    }
//                    if (Arrays.stream(locCandidate.toLowerCase().split("[,.; ]+")).anyMatch(Predicate.isEqual("north"))) {
//                        locCandidate = "N";
//                        break;
//                    }
//                    if (Arrays.stream(locCandidate.toLowerCase().split("[,.; ]+")).anyMatch(Predicate.isEqual("south"))) {
//
//                        locCandidate = "S";
//                        break;
//                    }
//                    if (Arrays.stream(locCandidate.toLowerCase().split("[,.; ]+")).anyMatch(Predicate.isEqual("q"))) {
//
//                        locCandidate = "Q";
//                        break;
//                    }
                    System.out.println("You should enter a direction (WESN)!");
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

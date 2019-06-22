package com.example.mwasilewski;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("locations.dat")))) {
            for (Location l : locations.values()) {
                locFile.writeInt(l.getLocationID());
                locFile.writeUTF(l.getDescription());
                System.out.println(String.join("  ", "Writing:",
                        l.getDescription(), Integer.toString(l.getLocationID())));
                locFile.writeInt(l.getExits().size() - 1);
                for (String dir : l.getExits().keySet()) {
                    if (!dir.equals("Q")) {
                        locFile.writeUTF(dir);
                        locFile.writeInt(l.getExits().get(dir));
                    }
                }
            }
        }
    }

    static {
        //Scanner scanner = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("locations_big.txt"))) {
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String desc = data[1];
                System.out.println("Imported loc: " + loc + ", description: " + desc);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, desc, tempExit));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + " " + direction + " " + destination);
                locations.get(loc).addExit(direction, destination);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}

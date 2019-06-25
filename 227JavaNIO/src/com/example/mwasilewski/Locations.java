package com.example.mwasilewski;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
        try (BufferedWriter locFile = Files.newBufferedWriter(locPath);
             BufferedWriter dirFile = Files.newBufferedWriter(dirPath)) {
            for (Location l : locations.values()) {
                locFile.write(l.getLocationID() + "," + l.getDescription() + "\n");
                for (String dir : l.getExits().keySet()) {
                    if (!dir.equalsIgnoreCase("Q")) {
                        dirFile.write(l.getLocationID() + "," + dir + l.getExits().get(dir) + "\n");

                    }
                }
            }
        }
    }
    static {
        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
        try(Scanner scanner=new Scanner(Files.newBufferedReader(locPath)))
        {
            scanner.useDelimiter(",");
            while(scanner.hasNextLine())
            {
                int loc=scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description=scanner.nextLine();
                System.out.println("loc: "+loc+" desc "+description);
                locations.put(loc, new Location(loc, description,null));

            }
        }catch (IOException e)
        {
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

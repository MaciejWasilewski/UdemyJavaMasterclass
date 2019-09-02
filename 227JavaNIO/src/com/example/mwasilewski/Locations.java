package com.example.mwasilewski;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    private static void writetoTxt() throws IOException {
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

    private static void writeToDat() throws IOException {
        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try (ObjectOutputStream locfile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))) {
            for(Location l: locations.values())
            {
                locfile.writeObject(l);

            }
        }
    }
    private static void readFromDat() throws IOException
    {
        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try(ObjectInputStream locFile=new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath))))
        {
            boolean hasLine=true;
            while(hasLine)
            {
                try {
                    Location l = (Location) locFile.readObject();
                    locations.put(l.getLocationID(),l);
                    System.out.println(l.getDescription());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }catch (EOFException e)
                {
                    System.out.println("End of dat file.");
                    hasLine=false;
                }
            }
        }
    }
    private static void readFromTxt() throws IOException
    {
        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
        try (Scanner scanner = new Scanner(Files.newBufferedReader(locPath))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("loc: " + loc + " desc " + description);
                locations.put(loc, new Location(loc, description, null));

            }
        }
        try (BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
            String input;
            while ((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String dir = data[1];
                int dest = Integer.parseInt(data[2]);
                Location l = locations.get(loc);
                l.addExit(dir, dest);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //writetoTxt();
        writeToDat();
    }

    static {
        try{
        readFromDat();} catch (IOException e) {
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
    public void putAll(@NotNull Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @NotNull
    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @NotNull
    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @NotNull
    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}

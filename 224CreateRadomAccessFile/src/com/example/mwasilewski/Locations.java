package com.example.mwasilewski;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile raf;
    private static int numLocations;

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile("locations_rand.dat", "rwd")) {
            raf.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationStart = (int) (indexSize + Integer.BYTES + raf.getFilePointer());
            raf.writeInt(locationStart);
            long indexStart = raf.getFilePointer();

            int startPointer = locationStart;
            raf.seek(startPointer);

            for (Location l : locations.values()) {
                raf.writeInt(l.getLocationID());
                raf.writeUTF(l.getDescription());
                StringBuilder stringBuilder = new StringBuilder();
                for (String d : l.getExits().keySet()) {
                    if (!d.equalsIgnoreCase("Q")) {
                        stringBuilder.append(d);
                        stringBuilder.append(",");
                        stringBuilder.append(l.getExits().get(d));
                        stringBuilder.append(",");
                    }
                }
//              ID//desc//N,3,U,4...
                raf.writeUTF(stringBuilder.toString());
                IndexRecord record = new IndexRecord(startPointer, (int) (raf.getFilePointer() - startPointer));
                index.put(l.getLocationID(), record);
                startPointer = (int) raf.getFilePointer();
            }
            raf.seek(indexStart);
            for (Integer i : index.keySet()) {
                raf.writeInt(i);
                raf.writeInt(index.get(i).getStartByte());
                raf.writeInt(index.get(i).getLength());
            }

        }
    }

    // Bytes 0-3: number of locations
//    Bytes 4-7: start offset of locations section
//    Bytes 8-1699: index
//    Bytes 1700- : actual data
    static {
//        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
//            boolean eof = false;
//            while (!eof) {
//                try {
//                    Location l = (Location) locFile.readObject();
//                    locations.put(l.getLocationID(), l);
//                } catch (EOFException e) {
//                    eof = true;
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("IOException");
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        try {
            raf = new RandomAccessFile("locations_rand.dat", "rwd");
            numLocations = raf.readInt();
            long locationStartPoint = raf.readInt();
            index.clear();
            while (raf.getFilePointer() < locationStartPoint) {
                int locationID = raf.readInt();
                int locationStartByte = raf.readInt();
                int locationLength = raf.readInt();
                index.put(locationID, new IndexRecord(locationStartByte, locationLength));
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
        if (!key.equals(0)) {
            try {
                return readRandomLocation(index.get(key));
            } catch (IOException e) {
                System.out.println("Could not find location of key " + key.toString());
                e.printStackTrace();

            }
        }
        return null;
//        return locations.get(key);
    }

    private Location readRandomLocation(IndexRecord indexRecord) throws IOException {

        raf.seek(indexRecord.getStartByte());
        int id = raf.readInt();
        String desc = raf.readUTF();
        String[] exits = raf.readUTF().split(",");
        Map<String, Integer> e = new HashMap<>();
        for (int i = 0; i < exits.length; i = i + 2) {
            e.put(exits[i], Integer.parseInt(exits[i + 1]));
        }
        return new Location(id, desc, e);
//        StringBuilder stringBuilder = new StringBuilder();
//        for (String d : l.getExits().keySet()) {
//            if (!d.equalsIgnoreCase("Q")) {
//                stringBuilder.append(d);
//                stringBuilder.append(",");
//                stringBuilder.append(l.getExits().get(d));
//                stringBuilder.append(",");
//            }
//        }

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

    public void close() throws IOException {
        raf.close();
    }
}

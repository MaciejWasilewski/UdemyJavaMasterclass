package com.example;

import java.util.HashMap;
import java.util.Map;

public final class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>();
        if(exits!=null)
        {
            for (String key: exits.keySet())
            {
                this.exits.put(key,exits.get(key));
            }
        }
        this.exits.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        Map<String, Integer> h=new HashMap<>();
        for(String s: exits.keySet())
        {
            h.put(s, exits.get(s));
        }
        return h;
    }

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }
}

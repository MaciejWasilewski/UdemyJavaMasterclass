package com.mw;

import java.util.ArrayList;

public class Album {
    private ArrayList<Song> songs=new ArrayList<Song>();
    private String name;

    public int getSize()
    {
        return songs.size();
    }

    public Album(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song returnSong(int position) {
        return songs.get(position - 1);

    }

    public void addSong(Song song, int pos) {
        songs.add(pos, song);
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder(name + ":\n");
        for(int i=0;i<songs.size();i++)
        {
            temp.append("\t").append(i+1).append(". ").append(songs.get(i)).append("\n");
        }
        if (songs.size() >= 1) {
            for (Song song : songs) {

            }
        }
        return temp.toString();
    }
}

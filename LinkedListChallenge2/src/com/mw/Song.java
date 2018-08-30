package com.mw;

public class Song {
    private String title;
    private int secDuration;

    public Song(String title, int secDuration) {
        this.title = title;
        this.secDuration = secDuration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSecDuration() {
        return secDuration;
    }

    public void setSecDuration(int secDuration) {
        this.secDuration = secDuration;
    }

    @Override
    public String toString() {
        return title+" - "+secDuration;
    }
}

package com.mw;

public class Main {

    public static void main(String[] args) {
        System.out.println(getDurationString(3601));
    }

    public static String getDurationString(int min, int sec) {
        if (min < 0 || sec < 0 || sec > 59) {
            return "Invalid value";
        } else {
            int h = min / 60;
            min = min % 60;
            return ((h < 10) ? "0" : "") + h + "h " + ((min < 10) ? "0" : "") + min + "m " + ((sec < 10) ? "0" : "") + sec + "s";
        }
    }

    public static String getDurationString(int sec) {
        if (sec < 0) {
            return "Invalid value";
        } else {
            int min = (sec) / 60;
            sec = (sec) % 60;
            return getDurationString(min, sec);
        }
    }
}

package com.example.mwasilewski;

public class Main {

    public static void main(String[] args) {
	String string="I am a astring. Yes, I am.";
        System.out.println(string);
        String yourString=string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric="abcDeeF12Ghhuuuhjl99z";
        System.out.println(alphanumeric.replaceAll("","Y"));
        System.out.println(alphanumeric.replaceAll("[aei][Fj]","Y"));
        System.out.println("Harry or harry".replaceAll("[Hh]arry","Barry"));
        System.out.println(" Harry likes me".replaceAll("(?!\\b)\\w+?\\b", "X"));
        System.out.println("123\\".replaceAll("\\\\","\\\\"));
    }
}

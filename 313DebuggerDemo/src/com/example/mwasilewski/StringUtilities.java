package com.example.mwasilewski;

public class StringUtilities {
    private StringBuilder stringBuilder = new StringBuilder();
    private int charsAdded = 0;

    void addChar(final StringBuilder stringBuilder,final char c) {
        stringBuilder.append(c);
        charsAdded++;
    }
    String upperAndPrefix(String str)
    {
        String upper=str.toUpperCase();
        return "Prefix_"+upper;
    }
    String addSuffix(String str)
    {
        return str+"_Suffix";
    }
}

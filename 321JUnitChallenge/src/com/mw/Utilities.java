package com.mw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

    static char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }
        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;
        for (int i = n - 1; i < sourceArray.length; i =i+n) {
            result[index] = sourceArray[i];
            index++;
        }
        return result;
    }

    static String removePairs(String source) {


        String out = source;
        Matcher matcher = Pattern.compile("(.)\\1").matcher(source);

        return matcher.replaceAll("$1");

    }

    static int converter(int a, int b) {
        return (a / b) + (a * 30) - 2;
    }

    static String nullIfOddLength(String source) {
        if (source.length() % 2 == 0) {
            return source;
        }
        return null;
    }
}

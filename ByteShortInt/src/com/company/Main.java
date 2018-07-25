package com.company;

public class Main {

    public static void main(String[] args) {
//        Integer has a width of 32
        int myMinValue = -2147483648;
        int myMaxValue = 2147483647;
        int myTotal = (myMinValue / 2);
//Byte has a width of 8
        byte myByteValue = -128;
        byte myNewByteValue = (byte) (myByteValue / 2);
//      short has a width of 16
        short myShortValue = -32768;
//long has a width of 64
        long myLongValue = 100L;
    }
}

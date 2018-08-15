package com.mw;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];
        ArrayList<String> strArrayList = new ArrayList<>();
        strArrayList.add("Tim");

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(2);
        System.out.println(integerArrayList);
        ArrayList<Double> myDobuleValues= new ArrayList<>();
        for(double dbl=0.0;dbl<10.0;dbl+=0.1)
        {
            myDobuleValues.add(dbl);
        }
        System.out.println(myDobuleValues);
    }
}

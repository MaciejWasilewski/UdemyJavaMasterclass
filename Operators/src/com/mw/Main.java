package com.mw;

public class Main {

    public static void main(String[] args) {
        int result = 1 + 2;
        System.out.println(result);
        System.out.println("result+1 " + (result + 1));
        System.out.println("result-1 " + (result - 1));
        System.out.println("result*3 " + (result * 3));
        System.out.println("result/2 " + (result / 2));
        System.out.println("result%2 " + (result % 2));

        boolean isAlien = false;
        if (isAlien == false)
            System.out.println("It is not an alien!");
        int newValue = 50;
        if (newValue == 50)
            System.out.println("newValue=50.");
        boolean isCar = false;
        if (isCar)
            System.out.println("This is not supposed to happen.");

        String wasCar = isCar ? "Was a car" : "Was not a car";
        System.out.println(wasCar);
        double d1=20d;
        double d2=20d;
        double result2=((d1+d2)*25d)%40;
        if (result2<=20)
            System.out.println("Total was over the limit");
    }
}

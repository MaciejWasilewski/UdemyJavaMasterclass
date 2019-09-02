package com.example.mwasilewski;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        System.out.println(divideLBYL(1, 0));
//        System.out.println(divideEAFP(1, 0));
//        System.out.println(divide(1, 0));
        System.out.println(getIntEAFP());
    }

    private static int getInt() {
        Scanner s=new Scanner(System.in);
        return s.nextInt();
    }
    private static int getIntEAFP()
    {
        Scanner s=new Scanner(System.in);
//        boolean isValid = true;
        System.out.println("Please enter an integer:");
//        String input=s.next();
        try
        {
            return s.nextInt();
        }catch (InputMismatchException e)
        {
            return 0;
        }
    }
    private static int getIntLBYL(){
        Scanner s=new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer:");
        String input=s.next();
        for(char c: input.toCharArray())
        {

            if(!Character.isDigit(c))
            {
                isValid=false;
                break;
            }
        }
        if(isValid){
        return Integer.parseInt(input);}
        return 0;

    }

    private static int divideLBYL(int x, int y) {
        if (y != 0) {
            return x / y;
        }
        return 0;
    }

    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    private static int divide(int x, int y) {
        return x / y;
    }
}

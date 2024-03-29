package com.example.mwasilewski;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try
        {
            int result = divide();
            System.out.println(result);
        }catch (ArithmeticException e)
        {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, shut down.");
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e.toString());
        }

    }

    private static int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x / y;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("no suitable input");
        } catch (ArithmeticException e)
        {
            throw new ArithmeticException("Attempt to divide by zero");
        }

    }

    private static int getInt() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("please enter a number using only the digits");
            }
        }
    }
}

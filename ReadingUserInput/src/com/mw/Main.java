package com.mw;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Your name is " + name);

        System.out.println("Year you were born is (YYYY): ");
        if(scanner.hasNextInt()) {
            int year = scanner.nextInt();
            scanner.nextLine(); //handle next line character
            if (2018 - year >= 0 && 2018 - year <= 100) {
                System.out.println(2018 - year);
            } else {
                System.out.println("Invalid date of birth.");
            }
        }
        else
        {
            System.out.println("Invalid number as a year.");
        }
        scanner.close();
    }
}

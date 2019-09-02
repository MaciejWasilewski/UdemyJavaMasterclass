package com.mw;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        boolean flag = false;
        double min = 0;
        double max = 0;

        if (scanner.hasNextDouble()) {
            min = scanner.nextDouble();
            max = min;
            flag = true;
        }
        scanner.nextLine();

        if (!flag) {
            System.out.println("No number entered.");
        } else {
            while (true) {
                System.out.println("Enter number:");
                if (!scanner.hasNextDouble()) {
                    scanner.nextLine();
                    break;
                }
                double temp = scanner.nextDouble();
                scanner.nextLine();
                min = (temp < min) ? temp : min;
                max = (temp > max) ? temp : max;
            }
            System.out.println("min=" + min + " max=" + max);
        }

        scanner.close();
    }
}

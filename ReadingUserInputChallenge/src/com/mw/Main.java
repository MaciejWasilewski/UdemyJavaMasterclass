package com.mw;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        for (int i = 1; i <= 10; i++) {
            boolean flag = false;
            while (true) {
                System.out.println("Please write " + i + ". number:");
                if (scanner.hasNextDouble())
                    break;
                scanner.nextLine();
                System.out.println("Wrong input");
            }
            sum += scanner.nextDouble();
            scanner.nextLine();
        }
        System.out.println(sum);
        scanner.close();
    }
}

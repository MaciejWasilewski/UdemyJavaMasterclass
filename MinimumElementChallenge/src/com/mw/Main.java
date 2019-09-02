package com.mw;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count;
        System.out.println("How many numbers?");
        while (true) {
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                scanner.nextLine();
                break;
            }
            scanner.nextLine();
            System.out.println("Wrong number. Enter again.");
        }
        int[] x = readIntegers(count);
        System.out.println("Minimum of provided numbers is " + findMin(x));
        System.out.println("Original array: " + Arrays.toString(x));
        reverse(x);
        System.out.println("After reverse: " + Arrays.toString(x));
    }

    private static int[] readIntegers(int count) {
        int[] x = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.println(count - i + " to go.");
            System.out.println("Enter a number");
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Wrong number.");
                i--;
            } else {
                x[i] = scanner.nextInt();
                scanner.nextLine();

            }
        }
        return x;
    }

    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];

        }
        return min;
    }

    public static void reverse(int[] x) {
        int temp;
        for (int i = 0; i <= x.length / 2; i++) {
            temp = x[i];
            x[i] = x[x.length - 1 - i];
            x[x.length - 1 - i] = temp;
        }

    }
}

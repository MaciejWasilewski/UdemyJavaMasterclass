package com.mw;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
////        int[] myVariable = new int[10];
////        myVariable[5]=50;
////        int[] myVariable = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] myIntArray = new int[10];
//        for (int i = 0; i < myIntArray.length / 2; i++) {
//            myIntArray[i] = 10 * i;
////            System.out.println(myIntArray[i]);
//        }
//        printArray(myIntArray);

        int[] x = getIntegers(5);
        printArray(x);
        System.out.println(average(x));
    }

    public static int[] getIntegers(int i) {
        int[] temp = new int[i];
        for (int j = 0; j < i; j++) {
            System.out.println("Enter the number: ");
            boolean flag = scanner.hasNextInt();
            if (!flag) {
                System.out.println("This is not a number. You have to repeat.");
                scanner.nextLine();//to handle enter
                j--;
                continue;
            }
            temp[j] = scanner.nextInt();
            scanner.nextLine();  //to handle enter

        }
        return temp;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
//            myIntArray[i] = 10 * i;
            System.out.println(array[i]);
        }
    }

    public static double average(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (sum) / (double) (array.length);
    }
}

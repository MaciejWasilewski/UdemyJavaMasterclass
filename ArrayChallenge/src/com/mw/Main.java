package com.mw;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printArray(sortArray(getIntegers(5)));
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

    public static int[] sortArray(int[] array) {
        int max;
        int index;
        for (int i = 0; i < array.length; i++) {
            max = Integer.MIN_VALUE;
            index = -1;
            for (int j = i; j < array.length; j++) {
                if (max < array[j]) {
                    max = array[j];
                    index = j;
                }
            }

//            System.out.println(index);
            array[index] = array[i];
            array[i]=max;
        }
        return array;
    }
}

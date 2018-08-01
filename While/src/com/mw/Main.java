package com.mw;

public class Main {

    public static void main(String[] args) {
//        int count = 0;
//        while (count != 5) {
//            System.out.println(count);
//            count++;
//        }
//
//        int number=4;
//        int finishNumber=20;
//
//        while(number<=finishNumber)
//        {
//            number++;
//            if(!isEvenNumber(number))
//            {
//                continue;
//            }
//            System.out.println("Even number: "+number);
//        }
        System.out.println(sumDigits(125));
        System.out.println(sumDigits(9));
    }

    public static boolean isEvenNumber(int number) {
        return (number % 2 == 0);
    }

    public static int sumDigits(int number) {
        if (number < 10)
            return -1;

        int sum = 0;
        while (number >= 1) {
            sum += number % 10;
            number /= 10;
//            System.out.println(number);
        }
        return sum;
    }
}

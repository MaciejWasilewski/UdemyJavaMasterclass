package com.mw;

public class Main {

    public static void main(String[] args) {
        System.out.println("10,000 at 2% interest = " + calculateInterest(10000d, 2d));
        for (double i = 8d; i > 1; i--) {
            System.out.println("10,000 at " + i + "% interest = " + calculateInterest(10000d, i));
        }
        int maxCount = 10;
        int count = 0;
        for (int i = 1; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                count++;
                if (count >= maxCount)
                    break;
            }
        }

//        challenge sum 3 and 5
        int sum = 0;
        count = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 15 == 0) {
                System.out.println(i);
                sum += i;
                count++;
            }
            if (count >= 5)
                break;
        }
        System.out.println(sum);
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

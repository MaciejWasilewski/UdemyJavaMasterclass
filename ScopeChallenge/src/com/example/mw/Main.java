package com.example.mw;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer");
        //        int x;
        while (true) {
            if (scanner.hasNextInt()) {
                break;
            } else {
                scanner.nextLine();
                System.out.println("This is not an integer. Enter integer");
            }
        }
        X x = new X(scanner.nextInt());
        scanner.nextLine();
        x.x();

    }

}

class X {
    private int x;

    public X(int x) {
        this.x = x;
    }

    public void x() {
        for (int x = 0; x < 12; x++) {
            System.out.println(x + " times " + this.x + " = " + x * this.x);
        }
    }
}
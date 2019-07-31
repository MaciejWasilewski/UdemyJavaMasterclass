package com.example.mwasilewski;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000, "1");
        new Thread(() -> {
            bankAccount.deposit(300);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bankAccount.withdraw(50);
        }).start();
        new Thread(() -> {
            bankAccount.deposit(203.75);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bankAccount.withdraw(100);
        }).start();
    }

}

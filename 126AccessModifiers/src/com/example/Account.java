package com.example;

import java.util.ArrayList;

public class Account {
    private String accountName;
    private int balance = 0;
    private ArrayList<Integer> trasactions;

    public Account(String accountName) {
        this.accountName = accountName;
        trasactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            trasactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " deposited. Balance now: " + this.balance);

        } else {
            System.out.println("Cannot deposit negative sums.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0) {
            trasactions.add(-amount);
            this.balance += -amount;
            System.out.println(amount + " withdrawn. Balance now: " + this.balance);

        } else {
            System.out.println("Cannot withdraw negative sums.");
        }
    }

    public void calculateBalance() {
        this.balance = 0;
        for (Integer el : this.trasactions)
            this.balance += el;
        System.out.println("Calculated balance is: "+this.balance);

    }
}

package com.example.mw;


import java.util.ArrayList;

public class Account {
    private String acountName;
    public int balance = 0;
    public ArrayList<Integer> transactions = new ArrayList<Integer>();

    public Account(String acountName) {
        this.acountName = acountName;
    }

    public int getBalance() {
        return balance;
    }

    private void addTransaction(int amount) {
        transactions.add(amount);
        balance += amount;
        System.out.println(amount * (amount > 0 ? 1 : -1) + " " + (amount > 0 ? "deposited" : "Withdrawn") + ". Balance is now " + balance);
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("You can't deposit negative number");
        }
        addTransaction(amount);
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("You can't withdraw negative number");
        }
        addTransaction(-amount);
    }

    public void calculateBalance() {
        this.balance = 0;
        for (int i : this.transactions) {
            this.balance += i;
        }
        System.out.println("Balance is " + this.balance);
    }
}

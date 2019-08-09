package com.example.mwasilewski;

public class BankAccount {
    private String fName;
    private String lName;
    private double balance;
    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;
    private int accType;

    public BankAccount(String fName, String lName, double balance, int accType) {
        this.fName = fName;
        this.lName = lName;
        this.balance = balance;
        this.accType = accType;

    }

    //    The branch argument is true if the customer is performing transaction at a branch, with a teller. It's false if
//    the customer is performing the transaction at an ATM
    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;
    }

    //    The branch argument is true if the customer is performing transaction at a branch, with a teller. It's false if
//    the customer is performing the transaction at an ATM
    public double withdraw(double amount, boolean branch) {
        if (amount > 500 && !branch) throw new IllegalArgumentException();
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking() {
        return accType == CHECKING;
    }
}

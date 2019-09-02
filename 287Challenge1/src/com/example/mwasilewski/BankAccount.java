package com.example.mwasilewski;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock = new ReentrantLock(true);

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        boolean status=false;
        lock.lock();
        try {
            balance += amount;
            status=true;
            System.out.println(Thread.currentThread().getName() + ":\t" + this.balance);
            System.out.println("Transaction status = "+status);
        } finally {
            lock.unlock();
        }

    }

    public void withdraw(double amount) {
        boolean status=false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status=true;
                    System.out.println(Thread.currentThread().getName() + ":\t" + this.balance);
                    System.out.println("Transaction status = "+status);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not lock get the lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {

        System.out.println(this.accountNumber);

    }
}

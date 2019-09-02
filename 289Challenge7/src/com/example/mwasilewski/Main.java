package com.example.mwasilewski;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("12345-678", 500.00);
        BankAccount account2 = new BankAccount("98765-432", 1000.00);

        Thread th1=new Thread(new Transfer(account1, account2, 10.00), "Transfer1");
        th1.start();
        Thread th2=new Thread(new Transfer(account2, account1, 55.88), "Transfer2");
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account1.getBalance()+account2.getBalance());
    }
}

class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock = new ReentrantLock();

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (lock.tryLock()) {
            try {
                // Simulate database access
                Thread.sleep(100);
                balance -= amount;
                System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
            } catch (InterruptedException e) {
            }finally {
                lock.unlock();
            }

            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (lock.tryLock()) {
            try {
                // Simulate database access
                Thread.sleep(100);
                balance += amount;
                System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
            } catch (InterruptedException e) {
            } finally {
                lock.unlock();
            }
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount destinationAccount, double amount) {
        if (withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                return true;
            } else {
                // The deposit failed. Refund the money back into the account.
                System.out.printf("%s: Destination account %s busy. Refunding money\n",
                        Thread.currentThread().getName(),destinationAccount.getName());
                while(!deposit(amount))
                {
                    //System.out.println("Trying to return the money");
                }
            }
        }

        return false;
    }

    private String getName() {
        return accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }
}

class Transfer implements Runnable {
    private BankAccount sourceAccount, destinationAccount;
    private double amount;

    Transfer(BankAccount sourceAccount, BankAccount destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public void run() {
        while (!sourceAccount.transfer(destinationAccount, amount))
            continue;
        System.out.printf("%s completed\n", Thread.currentThread().getName());
    }
}
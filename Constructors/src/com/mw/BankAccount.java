package com.mw;

public class BankAccount {
    private int number;
    private int balance; //in cents, not dollars
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount()
    {
//        default vals
        this(234,2344,"asas","fds","dsfw4");
        System.out.println("Empty constructor");
    }
    public BankAccount(int number, int balance, String customerName, String email, String phoneNumber)
    {
        this.number=number;
        this.balance=balance;
        this.customerName=customerName;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public void setNumber(int n) {
        if (n >= 0) {
            this.number = n;
        } else {
            this.number = -1;
        }
    }

    public void setBalance(int n) {
        this.balance = n;
    }

    public void setCustomerName(String n) {
        this.customerName = n;

    }

    public void setEmail(String n) {
        this.email = n;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getNumber() {
        return this.number;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void deposit(int deposit) {
        if (deposit > 0) {
            balance += deposit;
        } else {
            System.out.println("Wrong value for deposit.");
        }
    }

    public void withdraw(int withdraw) {
        if (withdraw > 0) {
            if (balance - withdraw > 0) {
                balance -= withdraw;
            } else {
                System.out.println("Cannot withdraw more money than the balance.");
            }
        } else {
            System.out.println("Wrong value for the withdrawal. Should be positive");
        }
    }

}

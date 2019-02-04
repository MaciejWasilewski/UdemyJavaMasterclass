package com.example;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Account acc=new Account("Maciek");
        acc.deposit(100);
        acc.withdraw(19);
        acc.withdraw(100);
        acc.calculateBalance();
    }
}

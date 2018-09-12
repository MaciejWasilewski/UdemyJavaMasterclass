package com.example.mw;

public class Main {

    public static void main(String[] args) {
        Account account = new Account("Tim");
        account.deposit(1000);
        account.withdraw(500);
//        account.withdraw(-500);
//        account.deposit(-20);
        account.calculateBalance();
    }
}

package com.example.mwasilewski;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;


    @org.junit.jupiter.api.BeforeEach
    public void setup() {
        account = new BankAccount("a", "b", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }


    @org.junit.jupiter.api.Test
    void deposit() {
        assertEquals(1200, account.deposit(200, true), 0);
        assertEquals(1200, account.getBalance(), 0);

    }

    @org.junit.jupiter.api.Test
    void withdraw_notBranch() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(600, false));
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        assertEquals(400, account.withdraw(600, true));
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {

        account.deposit(200, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {

        account.withdraw(200, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void isChecking_true() {

        assertTrue(account.isChecking(), "The account is not, but should be, checking account");
    }


}
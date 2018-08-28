package com.mw;

import java.util.Scanner;

public class Main {
    private static Bank bank = new Bank("PKO BP");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            int choice = waitForInt("Pick a command:\n" + "0 - quit\n" +
                    "1 - add new branch\n" +
                    "2 - add a customer to branch\n" +
                    "3 - add a transaction to customer\n" +
                    "4 - list customers of a branch\n" +
                    "5 - list transactions for customer.");
            if (choice == 0) {
                break;
            }
            doWork(choice);

        }
        scanner.close();
    }

    private static int waitForInt(String command) {
        int value;
        while (true) {
            System.out.println(command);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                scanner.nextLine();
            }
        }
        return value;
    }

    private static void doWork(int choice) {
        switch (choice) {
            case 1: {
                System.out.println("Enter new branch name:");
                String temp = scanner.nextLine();
                bank.addBranch(temp);
                break;
            }
            case 2: {
                System.out.println("Enter existing branch name:");
                String branchName = scanner.nextLine();
                System.out.println("Enter new customer name:");
                String customerName = scanner.nextLine();
                bank.addCustomer(branchName, customerName, 0d);
                break;
            }
            case 3: {
                System.out.println("Enter existing branch name:");
                String branchName = scanner.nextLine();
                System.out.println("Enter existing customer name:");
                String customerName = scanner.nextLine();
                int transaction = waitForInt("Enter transaction value:");
                bank.addTransaction(branchName, customerName, transaction);
                break;
            }
            case 4: {
                System.out.println("Enter existing branch name:");
                String branchName = scanner.nextLine();
                bank.showListOfCustomers(branchName);
                break;
            }
            case 5: {
                System.out.println("Enter existing branch name:");
                String branchName = scanner.nextLine();
                System.out.println("Enter existing customer name:");
                String customerName = scanner.nextLine();
                bank.showCustomerTransactions(branchName, customerName);
            }
        }
    }
}

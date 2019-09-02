package com.mw;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBranch(String name) {
        branches.add(new Branch(name));
    }

    public void addCustomer(String branchName, String customerName, double init_val) {
        int index = returnBranchIndex(branchName);
        if (index != -1) {
            branches.get(index).addCustomer(customerName, init_val);
        }
    }

    public void addCustomer(String branchName, String customerName) {
        int index = returnBranchIndex(branchName);
        if (index != -1) {
            branches.get(index).addCustomer(customerName);
        }
    }

    public void addTransaction(String branchName, String customerName, double transaction) {
        int index = returnBranchIndex(branchName);
        if (index != -1) {
            branches.get(index).addTransaction(customerName, transaction);
        }
    }

    private int returnBranchIndex(String branchName) {
        int index = branches.indexOf(new Branch(branchName));
        if (index == -1) {

            System.out.println("There is no branch named " + branchName);
        }
        return index;
    }

    public void showListOfCustomers(String branchName) {
        int index = returnBranchIndex(branchName);
        if (index != -1) {
            System.out.println(branches.get(index).customersToString());
        }
    }

    public void showCustomerTransactions(String branchName, String customerName) {
        int index = returnBranchIndex(branchName);
        if (index != -1) {
            System.out.println(branches.get(index).customersTransToString(customerName));
        }
    }
}

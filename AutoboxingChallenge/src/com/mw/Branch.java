package com.mw;

import java.util.ArrayList;
import java.util.Objects;

public class Branch {
    private ArrayList<Customer> customers;
    private String name;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCustomer(String name, double init) {
        customers.add(new Customer(name, init));
    }

    public void addCustomer(String name) {
        customers.add(new Customer(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(name, branch.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void addTransaction(String customerName, double value) {
        int index = returnCustomerIndex(customerName);

        if (index != -1) {
            customers.get(index).addTransaction(value);
        }
    }

    @Override
    public String toString() {
        return "Branch Name:\t" + name;
    }

    public String customersToString() {
        String temp = "";
        for (int i = 0; i < customers.size(); i++) {
            temp += "\t" + customers.get(i) + "\n";
        }
        return temp;
    }

    public String customersTransToString(String customerName) {
        int i=returnCustomerIndex(customerName);
        return customers.get(i).transactionsToString();
    }

    private int returnCustomerIndex(String customerName) {
        int index = customers.indexOf(new Customer(customerName));
        if (index == -1) {

            System.out.println("There is no customer named " + customerName);
        }
        return index;
    }
}

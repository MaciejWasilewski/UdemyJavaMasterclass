package com.mw;

import java.util.ArrayList;
import java.util.Objects;

public class Customer {
    private ArrayList<Double> transactions;
    private String name;

    public Customer(String name, double init) {
        this(name);

        this.transactions.add(init);
    }

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addTransaction(double value)
    {
        this.transactions.add(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
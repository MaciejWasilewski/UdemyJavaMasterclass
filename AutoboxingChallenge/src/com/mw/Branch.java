package com.mw;

import java.util.ArrayList;
import java.util.Objects;

public class Branch {
    private ArrayList<Customer> customers;
    private String name;

    public Branch(String name) {
        this.name = name;
        this.customers=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addCustomer(String name, double init)
    {
        customers.add(new Customer(name, init));
    }
    public void addCustomer(String name)
    {
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
    public void addTransaction(String customerName, double value)
    {
        Customer temp=new Customer(customerName);
        if(customers.contains(temp))
        {

        }
    }
}

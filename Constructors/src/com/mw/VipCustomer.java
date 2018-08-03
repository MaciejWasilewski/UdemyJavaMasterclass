package com.mw;

public class VipCustomer {
    private String name;
    private int creditLimit;
    private String email;

    public VipCustomer(String name, int creditLimit, String email) {
        this.name = name;
        this.creditLimit = (creditLimit > 0) ? creditLimit : 0;
        this.email = email;
    }

    public VipCustomer(String name, int creditLimit) {
        this(name,creditLimit, "asdsd@ggm");
    }

    public VipCustomer() {
        this("Maciek",100, "asdsd@ggm");
    }

    public String getName() {
        return name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}

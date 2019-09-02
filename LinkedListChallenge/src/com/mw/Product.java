package com.mw;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        System.out.println(name+": "+((price/100d)));
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

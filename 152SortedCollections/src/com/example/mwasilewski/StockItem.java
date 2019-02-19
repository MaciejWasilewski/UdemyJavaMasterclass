package com.example.mwasilewski;

import java.util.Objects;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public void adjustStock(int quantity) {
        this.quantityStock = ((this.quantityStock + quantity) >= 0) ? (this.quantityStock + quantity) : this.quantityStock;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Entering equals() method of the StockItem.");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItem stockItem = (StockItem) o;
        return Objects.equals(getName(), stockItem.getName());
    }

    @Override
    public int hashCode() {
        System.out.println("Entering hashCode() method of the StockItem.");
        return this.getName().hashCode();
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering compareTo() method of the StockItem.");
        if (o == null) throw new NullPointerException();
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "StockItem of name " +
                name +
                " and price " + price;
    }
}

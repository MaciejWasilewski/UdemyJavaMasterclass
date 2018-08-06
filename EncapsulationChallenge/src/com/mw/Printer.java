package com.mw;

public class Printer {
    private double tonerLevel;
    private int noOfPages;
    private boolean isDuplex;
    private String model;
    private String manufacturer;

    public Printer(boolean isDuplex, String model, String manufacturer) {
        this.isDuplex = isDuplex;
        this.model = model;
        this.manufacturer = manufacturer;
        this.tonerLevel = 1d;
        this.noOfPages = 0;
    }

    public double getTonerLevel() {
        return tonerLevel;
    }

    public void setTonerLevel(double tonerLevel) {
        if (tonerLevel <= 1 && tonerLevel >= 0) {
            this.tonerLevel = tonerLevel;
        } else {
            System.out.println("New toner level has to be between 0.0 and 1.0. You tried to put " + tonerLevel + " of toner.");
        }
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        if (noOfPages >= 0) {
            this.noOfPages = noOfPages;
        } else {
            System.out.println("New page count has to be at least 0.");
        }
    }

    public boolean isDuplex() {
        return isDuplex;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void fillToner(double amount) {
        setTonerLevel(getTonerLevel() + amount);
    }

    public void print(int pages) {
        if (pages > 0) {
            noOfPages = (isDuplex) ? noOfPages + pages : noOfPages + 2 * pages;
            System.out.println("Printing " + pages + " pages. Page counter: " + getNoOfPages());
        } else {
            System.out.println("You cannot print number of pages less than one.");
        }
    }

}

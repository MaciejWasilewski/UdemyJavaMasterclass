package com.mw;

public class Main {

    public static void main(String[] args) {
        BasicHamburger bh = new BasicHamburger("Cheeseburger", 0, new BreadRoll("White Bread", 100), new Meat("Beef", 15 * 100));
        bh.addAddition(new Addition("Lettuce", 100));
        bh.getPrice();
        bh.addAddition(new Addition("Tomato Slice", 150));
        bh.addAddition(new Addition("Cheese", 110));
        bh.addAddition(new Addition("Onion", 120));
        bh.addAddition(new Addition("Mustard", 130));
        bh.addAddition(new Addition("Ketchup", 140));
        bh.getPrice();
        
        HealthyBurger hh=new HealthyBurger(new Meat("Beef", 15 * 100));
        hh.addAddition(new Addition("Lettuce", 100));
        hh.addAddition(new Addition("Tomato Slice", 150));
        hh.addAddition(new Addition("Cheese", 110));
        hh.addAddition(new Addition("Onion", 120));
        hh.addAddition(new Addition("Mustard", 130));
        hh.addAddition(new Addition("Ketchup", 140));
        hh.getPrice();

        DeluxeHamburger dh=new DeluxeHamburger(new BreadRoll("Deluxe Bread",20*100),new Meat("Deluxe Meat", 30*100));
        dh.addAddition(new Addition("Lettuce", 100));
        dh.getPrice();
        dh.addAddition(new Addition("Tomato Slice", 150));
        dh.addAddition(new Addition("Cheese", 110));
        dh.addAddition(new Addition("Onion", 120));
        dh.addAddition(new Addition("Mustard", 130));
        dh.addAddition(new Addition("Ketchup", 140));
        dh.getPrice();
    }
}

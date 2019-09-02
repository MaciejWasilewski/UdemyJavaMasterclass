package com.mw;

public class DeluxeHamburger extends BasicHamburger {
    public DeluxeHamburger(BreadRoll bread, Meat meat) {
        super("Deluxe Hamburger", 0, bread, meat, 2);
        addAddition(new Addition("Chips", 5 * 100));
        addAddition(new Addition("Drinks", 4 * 100));
    }
}

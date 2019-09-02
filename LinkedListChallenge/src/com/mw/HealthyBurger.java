package com.mw;

public class HealthyBurger extends BasicHamburger{
    public HealthyBurger(Meat meat) {
        super("Healthy Burger", 0, new BreadRoll("Brown Rye bread Roll", 10*100), meat,2);
    }
}

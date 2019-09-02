package com.mw;

public class BasicHamburger extends Product {
    private BreadRoll bread;
    private Meat meat;
    private Addition addition1;
    private Addition addition2;
    private Addition addition3;
    private Addition addition4;
    private int remainingAdditions;

    public BasicHamburger(String name, int price, BreadRoll bread, Meat meat) {
        super(name, price);
        this.bread = bread;
        this.meat = meat;
        remainingAdditions = 4;
    }

    public BasicHamburger(String name, int price, BreadRoll bread, Meat meat, int adds) {
        super(name, price);
        this.bread = bread;
        this.meat = meat;
        this.addition1 = null;
        this.addition2 = null;
        this.addition3 = null;
        this.addition4 = null;
        this.remainingAdditions = adds;
    }

    public void addAddition(Addition a) {
        remainingAdditions--;
//        System.out.println(remainingAdditions);
        if (remainingAdditions >= 0) {
            switch (remainingAdditions) {
                case 0:
                    addition1 = a;
                    break;
                case 1:
                    addition2 = a;
                    break;
                case 2:
                    addition3 = a;
                    break;
                case 3:
                    addition4 = a;
                    break;
                default:
                    break;
            }
            System.out.println("Added " + a.getName());
        } else {
            System.out.println("You cannot add more additions");
        }
    }

    @Override
    public int getPrice() {
        System.out.println("Summary for " + super.getName() + ":");
        super.setPrice(bread.getPrice() + meat.getPrice() + ((addition1 == null) ? 0 : addition1.getPrice()) +
                ((addition2 == null) ? 0 : addition2.getPrice()) + ((addition3 == null) ? 0 : addition3.getPrice()) +
                ((addition4 == null) ? 0 : addition4.getPrice()));
        return super.getPrice();
    }
}

package com.mw;

public class Player {

    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage)
    {
        health-=damage;
        if (health<=0)
        {
            System.out.println("The player knocked out.");
        }
    }

    public int getHealth() {
        return health;
    }
}

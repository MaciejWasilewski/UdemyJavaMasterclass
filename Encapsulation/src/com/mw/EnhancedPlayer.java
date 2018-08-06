package com.mw;

public class EnhancedPlayer {
    private String name;
    private int health;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        if(health<0 || health>200)
        {
            System.out.println("Health should be between 0 and 200");
        }
        else
        {
            this.health = health;
        }
        this.weapon = weapon;
    }
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

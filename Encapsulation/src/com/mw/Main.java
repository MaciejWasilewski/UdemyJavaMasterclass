package com.mw;

public class Main {

    public static void main(String[] args) {
//        Player player = new Player();
//        player.name = "tim";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        player.loseHealth(10);
//        System.out.println("Remaining health="+player.getHealth());
//        player.health=200;
//        player.loseHealth(10);
//        System.out.println("Remaining health="+player.getHealth());
        EnhancedPlayer player=new EnhancedPlayer("Tim", 50, "sword");
        System.out.println("Initial health is "+player.getHealth());
        player.loseHealth(4);
        System.out.println(player.getHealth());
    }
}

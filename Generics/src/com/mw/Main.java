package com.mw;


public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseBallPlayer pat = new BaseBallPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> aC = new Team<>("Adekaide Crows");
        aC.addPlayer(joe);
//        aC.addPlayer(pat);
//        aC.addPlayer(beckham);
        System.out.println(aC.numPlayers());

        Team<BaseBallPlayer> bT = new Team<>("Chicago Cubs");
        bT.addPlayer(pat);
    }


}

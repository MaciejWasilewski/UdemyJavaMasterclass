package com.mw;

public class Main {

    public static void main(String[] args) {
        int newScore=calculateScore("Tim", 500);
        newScore=calculateScore(75);
        calculateScore();
        System.out.println(calcFeetAndInchesToCentimeters(10d, 3d));
        System.out.println(calcFeetAndInchesToCentimeters(10d*12d+3d));
    }

    public static int calculateScore(String playerName, int score)
    {
        System.out.println("Player "+playerName+" scored "+score+" points.");
        return score*1000;
    }
    public static int calculateScore(int score)
    {
        System.out.println("Unnamed player scored "+score+" points.");
        return score*1000;
    }
    public static int calculateScore()
    {
        System.out.println("No player, no score.");
        return 0;
    }
    public static double calcFeetAndInchesToCentimeters(double feet, double inches)
    {
        if (feet<0 || inches<0 || inches>12)
        {
            return -1d;
        }
        else
        {
            return (feet*12d+inches)*2.54;
        }
    }
    public static double calcFeetAndInchesToCentimeters(double inches)
    {
        if (inches<0)
        {
            return -1d;
        }
        else
        {
            return (inches)*2.54;
        }
    }
}

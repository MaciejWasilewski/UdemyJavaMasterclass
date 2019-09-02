package com.mw;

public class Main {

    public static void main(String[] args) {
        int finalScore = calculateScore(800, 5, 100, true);
        System.out.println("Your final score is: " + finalScore);
        finalScore = calculateScore(10000, 8, 200, true);
        System.out.println("Your final score is: " + finalScore);
        displayHighScorePosition("Maciek", calculateHighScorePosition(1500));
        displayHighScorePosition("Maciek", calculateHighScorePosition(900));
        displayHighScorePosition("Maciek", calculateHighScorePosition(400));
        displayHighScorePosition("Maciek", calculateHighScorePosition(50));
    }

    public static int calculateScore(int score, int level, int bonus, boolean gameOver) {

        if (gameOver) {
            int finalScore = score + level * bonus;
            return finalScore;
        }
        return -1;

    }

    public static void displayHighScorePosition(String name, int position) {
        System.out.println(name + " managed to get into position " + position);
    }

    public static int calculateHighScorePosition(int score) {
        if (score > 1000) {
            return 1;
        } else if (score > 500) {
            return 2;
        } else if (score > 100) {
            return 3;
        }
        return 4;


    }
}

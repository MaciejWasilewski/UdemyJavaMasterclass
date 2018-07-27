package com.mw;

public class Main {

    public static void main(String[] args) {
        calculateScore(800, 5, 100, true);
        calculateScore(10000, 8, 200, true);

    }

    public static int calculateScore(int score, int level, int bonus, boolean gameOver) {

        if (gameOver) {
            int finalScore = score + level * bonus;
            System.out.println("Your final score is: " + finalScore);
            return finalScore;
        }
        return -1;

    }
}

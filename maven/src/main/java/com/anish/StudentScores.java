package com.anish;

/**
 * Demonstrates arrays, loops, and calculating a value from a collection.
 */
public class StudentScores {

    public static double average(int[] scores) {
        if (scores.length == 0) {
            throw new IllegalArgumentException("At least one score is required.");
        }

        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return (double) total / scores.length;
    }

    public static void main(String[] args) {
        int[] scores = {82, 91, 76, 88};

        System.out.println("Scores:");
        for (int score : scores) {
            System.out.println("- " + score);
        }
        System.out.printf("Average: %.2f%n", average(scores));
    }
}

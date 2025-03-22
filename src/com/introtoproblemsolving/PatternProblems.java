package com.introtoproblemsolving;

public class PatternProblems {

    public static void main(String[] args) {
        printPattern(5);
        printHollowSquare(5);
        printLeftTriangle(5);
    }

    private static void printPattern(final Integer N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printHollowSquare(final Integer N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || i == N-1) {
                    System.out.print("*");
                } else if (j == 0 || j == N-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void printLeftTriangle(final Integer N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j <= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

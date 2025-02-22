package com.util;

public class NumberUtils {

    public static void main(String[] args) {
        System.out.println("CHECK FOR PERFECT SQUARE "+checkPerfectSquare(36));
        System.out.println("CHECK FOR PERFECT SQUARE "+checkPerfectSquare(37));
        System.out.println("CHECK FOR PERFECT SQUARE "+checkPerfectSquare(16));
        System.out.println("CHECK FOR PERFECT SQUARE "+checkPerfectSquare(25));
    }
    public static boolean checkPerfectSquare(int N) {
        for (int i = 1; i <= N; i++) {
            if (i * i == N) {
                return true;
            } else if (i * i > N) {
                return false;
            }
        }
        return false;
    }

    // TODO: NEED TO IMPLEMENT THIS LOGIC FROM THE FIRST INTRO TO PROBLEM SOLVING CLASS VIDEO
    public static int numberOfFactors(int a) {
        return 0;
    }
}

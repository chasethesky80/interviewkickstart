package com.twodimensionalarrays;

public class PatternMatchingProblems {

    public static void main(String[] args) {
        printMatrix();
        System.out.println();
        printHollowSquare();
        System.out.println();
        printLeftTriangle();
        System.out.println();
        printRightTriangle(5);
        System.out.println();
        printRightTriangle(5);
        System.out.println();
        printPattern(5);
        System.out.println();
        printMirrorImage(5);
    }
    private static void printMatrix() {
        for (int j =0; j <5; j++) {
            for (int i = 0; i < 5; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printHollowSquare() {
        for (int i =0; i <5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0 || i == 4 || j == 0 || j == 4) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void printLeftTriangle() {
        for (int i =0; i <5; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printRightTriangle(int N) {
        for (int i =0; i <N; i++) {
            for (int j = N-1-i; j >=0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printPattern(int N) {
        for (int i =0; i <N; i++) {
            for (int j = N-1; j >=0; j--) {
               if (j >= N-i) {
                   System.out.print("*");
               } else {
                   System.out.print(" ");
               }
            }
            System.out.println();
        }
    }

    private static void printMirrorImage(int N) {
        for (int i =0; i <N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

}

package com.recursion;

public class PrintNumbersInIncreasingOrder {

    public static void main(String[] args) {
        printIncreasing(5);
        System.out.println();
        printIncreasingAlternativeSolution(5);
    }

    private static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }
        printIncreasing(n-1);
        System.out.print(n +" ");
    }

    private static void printIncreasingAlternativeSolution(int input) {
        printIncreasingAlternativeSolutionHelper(input, 1);
    }

    private static void printIncreasingAlternativeSolutionHelper(final Integer input, int current) {
        if (current == input + 1) {
            return;
        }
        System.out.print(current +" ");
        current = current + 1;
        printIncreasingAlternativeSolutionHelper(input, current);
    }
}

package com.recursion;

public class PrintNumbersInDecreasingIncreasingOrder {
    public static void main(String[] args) {
        System.out.println("Printing numbers in decreasing order ");
         printNumbersInDecreasingIncreasingOrder(5);
    }

    private static void printNumbersInDecreasingIncreasingOrder(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printNumbersInDecreasingIncreasingOrder(n-1);
        System.out.print(n + " ");
    }
}

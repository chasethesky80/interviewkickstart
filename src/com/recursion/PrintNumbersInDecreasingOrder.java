package com.recursion;

public class PrintNumbersInDecreasingOrder {

    public static void main(String[] args) {
        printDecreasing(5);
    }

    private static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n +" ");
        printDecreasing(n-1);
    }
}

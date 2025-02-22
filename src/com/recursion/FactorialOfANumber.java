package com.recursion;

public class FactorialOfANumber {

    public static void main(String[] args) {
        System.out.println("FIND FIRST NON ZERO DIGIT OF "+ factorial(5));
    }

    private static int factorial(int N) {
        if (N == 0 || N == 1) {
            return 1;
        }
        return N * factorial(N-1);
    }
}

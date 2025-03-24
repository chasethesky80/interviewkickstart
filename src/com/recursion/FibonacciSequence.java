package com.recursion;

public class FibonacciSequence {

    public static void main(String[] args) {
        // Given Number N
        int N = 10;
        // Print the first N numbers
        for (int i = 0; i < N; i++) {
            System.out.print(fibonacciSequence(i) + " ");
        }
    }

    private static Integer fibonacciSequence(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        return fibonacciSequence(N-1) + fibonacciSequence(N-2);
    }
}

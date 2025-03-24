package com.introtoproblemsolving;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPrimeFactorsOfANumber {

    public static void main(String[] args) {
        System.out.println("PRIME FACTORS OF A NUMBER "+ primeFactorsOfNumber(24));
        System.out.println("PRIME FACTORS OF A NUMBER "+ primeFactorsOfNumber(25434));
    }

    private static List<Integer> primeFactorsOfNumber(int N) {
        final List<Integer> primeFactors = new ArrayList<>();
        int i = 2;
        while (N % i == 0) {
            primeFactors.add(i);
            N = N / i;
        }
        for (int j = 3; j*j <= N; j = j + 2) {
            while (N % j == 0) {
                primeFactors.add(j);
                N = N / j;
            }
        }
        return primeFactors;
    }
}

package com.introtoproblemsolving;

public class CheckIfAGivenNumberIsPrimeOrNot {

    public static void main(String[] args) {
        System.out.println("IS GIVEN NUMBER A PRIME NUMBER "+isNumberAPrimeNumberBruteForce(17));
        System.out.println("IS GIVEN NUMBER A PRIME NUMBER "+isNumberAPrimeNumberBruteForce(18));
        System.out.println("IS GIVEN NUMBER A PRIME NUMBER "+isNumberAPrimeNumberOptimized(19));
        System.out.println("IS GIVEN NUMBER A PRIME NUMBER "+isNumberAPrimeNumberOptimized(15));
    }
    // TC = O(N), SC = O(1) since no extra space used
    private static boolean isNumberAPrimeNumberBruteForce(final Integer N) {
        int numberOfFactors = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                numberOfFactors++;
            }
        }
        return numberOfFactors == 2;
    }

    // TC = O(SQRT(N)), SC = O(1) since no extra space used
    private static boolean isNumberAPrimeNumberOptimized(final Integer N) {
        int numberOfFactors = 0;
        for (int i = 1; i*i <= N; i++) {
            if (N % i == 0) {
                numberOfFactors = i == N/i ? numberOfFactors + 1 : numberOfFactors + 2;
            }
        }
        return numberOfFactors == 2;
    }

    private int findLargestPrimeFactorOfANumber(final int N) {
        return 0;
    }
}

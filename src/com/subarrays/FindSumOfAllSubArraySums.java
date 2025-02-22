package com.subarrays;

public class FindSumOfAllSubArraySums {

    public static void main(String[] args) {
       System.out.println("SUM OF ALL SUBARRAY SUMS "+ sumOfAllSubArraySums(new int[]{ 4, 3, 1, 2, 5, 7}));
        System.out.println("SUM OF ALL SUBARRAY SUMS "+ sumOfAllSubArraySums(new int[]{ 3, 2, 5 }));
    }
    // TC = O(N), SC = O(1) - Optimized solution
    private static long sumOfAllSubArraySums(int[] A) {
        long total = 0;
        int N = A.length;
        for (int i =0; i < N; i++) {
            total = total + (long) A[i] *(i+1)*(N-i);
        }
        return total;
    }
}

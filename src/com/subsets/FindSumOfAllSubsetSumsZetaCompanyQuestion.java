package com.subsets;

/**
 * GIVEN AN ARRAY OF N NUMBERS, FIND THE SUM OF ALL SUBSET SUMS OF ARRAY / 2^N
 */
public class FindSumOfAllSubsetSumsZetaCompanyQuestion {

    public static void main(String[] args) {
        System.out.println("SUM OF ALL SUBSET SUMS OF THE ARRAY IS "+ subSetSumsZetaCompany(new int[]{ 3, -1, 0, 6, 2, -3, 5}));
        System.out.println("SUM OF ALL SUBSET SUMS OF THE ARRAY IS "+ subSetSumsZetaCompany(new int[]{ -2, 6, 4 }));
        System.out.println("SUM OF ALL SUBSET SUMS OF THE ARRAY IS "+ subSetSumsZetaCompany(new int[]{ -2, 6, 4 }));
    }

    private static Integer subSetSumsZetaCompany(int[] arr) {
        /**
         * SINCE NUMBER OF SUBSETS WHERE EACH ELEMENT OCCURS IS 2^(N-1) THE SUM OF ALL SUBSET SUMS / 2 ^N
         * IS EQUAL TO :- (2^N-1 * (SUM OF ALL ELEMENTS OF ARRAY)) / 2 ^ N
         */
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / 2;
    }
}

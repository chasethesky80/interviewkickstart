package com.binarysearch;

public class FindSquareRootInDecimalsWithBinarySearch {

    public static void main(String[] args) {
        System.out.println("Find Square Root In Decimal with Binary Search "+
                findSquareRootInDecimalsWithBinarySearch(17));
        System.out.println("Find Square Root In Decimal with Binary Search "+
                findSquareRootInDecimalsWithBinarySearch(53));
    }
    private static double findSquareRootInDecimalsWithBinarySearch(int N) {
        int low = 1, high = N;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid == N) {
                ans = mid;
                return mid;
            }
            else if (mid * mid < N) {
                ans = mid;
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        double intPart = ans;
        double step = 0.1;
        for (int i = 0; i < 2; i++) {
            while ((intPart + step) * (intPart + step) < N) {
                intPart += (int) step;
            }
            step = step / 10;
        }
        return intPart;
    }
}

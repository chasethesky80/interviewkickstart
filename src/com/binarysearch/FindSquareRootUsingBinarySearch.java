package com.binarysearch;

public class FindSquareRootUsingBinarySearch {

    public static void main(String[] args) {
        System.out.println("SQUARE ROOT OF NUMBER "+ findSquareRoot(36));
        System.out.println("SQUARE ROOT OF NUMBER "+ findSquareRoot(49));
        System.out.println("SQUARE ROOT OF NUMBER "+ findSquareRoot(20));
        System.out.println("SQUARE ROOT OF NUMBER "+ findSquareRoot(40));
    }

    private static int findSquareRoot(int N) {
        int low = 1, high = N;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid > N) {
                high = mid - 1;
            } else if (mid * mid < N) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}

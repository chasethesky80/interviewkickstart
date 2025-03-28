package com.introtoproblemsolving;

public class FindSquareRootOfNumber {

    public static void main(String[] args) {
        System.out.println("SQUARE ROOT OF NUMBER "+ squareRoot(49));
        System.out.println("SQUARE ROOT OF NUMBER "+ squareRoot(47));
    }

    private static Integer squareRoot(final Integer N) {
        int left = 1, right = N;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int product = mid * mid;
            if (product == N) {
                return mid;
            }
            if (product < N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

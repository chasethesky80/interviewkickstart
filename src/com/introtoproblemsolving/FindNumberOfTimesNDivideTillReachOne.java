package com.introtoproblemsolving;

// FIND NUMBER OF TIMES A NUMBER SHOULD BE DIVIDED BY 2 TILL IT REACHES 1
public class FindNumberOfTimesNDivideTillReachOne {

    public static void main(String[] args) {
        System.out.println("NO OF TIMES N DIVIDED BY 2 TILL IT REACHES ONE "+numberOfTimesDivideNTill1(33));
        System.out.println("NO OF TIMES N DIVIDED BY 2 TILL IT REACHES ONE "+numberOfTimesDivideNTill1(33));
    }
    // TC = O(1) and SC = O(1)
    private static int numberOfTimesDivideNTill1(final Integer N) {
        return (int) Math.log(N);
    }
}

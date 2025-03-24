package com.introtoproblemsolving;

public class FindLCMOfTwoNumbers {

    public static void main(String[] args) {
        System.out.println("LCM OF NUMBERS "+ findLCM(12, 18));
    }

    private static int findLCM(int a, int b) {
        int num = Math.max(a, b);
        for (int i = num; ; i++) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }
    }
}

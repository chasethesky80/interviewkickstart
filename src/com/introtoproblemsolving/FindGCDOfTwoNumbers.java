package com.introtoproblemsolving;

public class FindGCDOfTwoNumbers {

    public static void main(String[] args) {
        System.out.println("GCD OF "+ findGCD(36, 60));
    }

    private static int findGCD(int A, int B) {
        int num = Math.min(A, B);
        for (int i = num; i >=1; i--) {
            if (A % i == 0 && B % i == 0) {
                return i;
            }
        }
        return - 1;
    }
}

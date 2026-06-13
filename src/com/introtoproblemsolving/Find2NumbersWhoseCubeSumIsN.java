package com.introtoproblemsolving;

public class Find2NumbersWhoseCubeSumIsN {

    public static void main(String[] args) {
        System.out.println("SUM OF CUBE OF NUMBERS FOR \n");
        cubeSum(28);
        System.out.println();
        cubeSumOptimized(28);
    }

    private static void cubeSum(final Integer N) {
        for (int i = 1; i <= N; i++) {
            int a = i * i * i;
            int diff = N - a;
            int cbRt = (int) Math.cbrt(diff);
            if (cbRt * cbRt * cbRt == diff) {
                System.out.print("CUBE SUM "+ a +" "+ diff);
            }
        }
    }

    private static void cubeSumOptimized(final Integer N) {
        for (int i = 1; i*i*i <= N; i++) {
            int a = i * i * i;
            int diff = N - a;
            int cbRt = (int) Math.cbrt(diff);
            if (cbRt * cbRt * cbRt == diff) {
                System.out.print("CUBE SUM "+ a +" "+ diff);
            }
        }
    }
}

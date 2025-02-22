package com.recursion;

/**
 * Implement power function using recursion
 */
public class PowerFunction {

    public static void main(String[] args) {
        System.out.println("POWER FUNCTION "+ powerFunction(2, 3));
        System.out.println("POWER FUNCTION "+ powerFunction(3, 4));
        System.out.println("POWER FUNCTION "+ powerFunctionOptimized(2, 3));
        System.out.println("POWER FUNCTION "+ powerFunctionOptimized(3, 4));
    }

    /**
     * Time complexity is O(N)
     * @param a
     * @param N
     * @return
     */
    private static int powerFunction(int a, int N) {
        if (N == 0) {
            return 1;
        }
        return a * powerFunction(a, N-1);
    }

    private static int powerFunctionOptimized(int a, int N) {
        if (N == 0) {
            return 1;
        }
        int halfPower = powerFunctionOptimized(a, N/2);
        if (N % 2 == 0) {
            return halfPower * halfPower;
        }
        return halfPower * halfPower * a;
    }
}

package com.modulararithmetic;

// Given a number A in form of an array of size N and a number P, calculate A % P
// where 1 <= P <= 10^ 9 (integer), 0 <= arr[i] <= 9 (digits from 0 to 9) and 1 <= N <= 10^5 which is the number of elements or size of array
public class GivenANumberInFormOfArrayFindModulus {

    public static void main(String[] args) {
        System.out.println("FIND MODULUS OF NUMBER WITH INPUT "+ findModulus(new int[]{ 3, 8, 4, 3, 6, 8, 9 }, 7, 7));
    }
    // TC = O(N^2) since loop runs O(N) times and power function takes O(N) for each iteration and SC = O(1) since no space used
    private static int findModulus(int[] arr, int P, int N) {
        int answer = 0;
        // Assuming elements of array are a0, a1, a2, a3 etc.... till aN-1, then the value of modulus is
        // (a0 % P * 10^N-1 % P) % P + (a1 % P * 10^N-2 % P) % P +...........+ (aN-1 % P * 10^0 % P) % P
        for (int i =0; i < N; i++) {
            answer = answer + (arr[i] % P * ImplementPowerFunctionWithModulus.power(10, N-i-1, P)) % P;
        }
        return answer % P;
    }
}

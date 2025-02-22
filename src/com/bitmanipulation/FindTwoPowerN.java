package com.bitmanipulation;

public class FindTwoPowerN {

    public static void main(String[] args) {
        System.out.println("FIND 2^N EQUALS "+findTwoPowerNBruteForce(5));
        System.out.println("FIND 2^N EQUALS "+findTwoPowerNOptimized(5));
        System.out.println("FIND M^N EQUALS "+findMPowerNBruteForce(5, 3)); // HERE M is not a power of 2 since 5 is not a power of 2
        System.out.println("FIND M^N EQUALS "+findMPowerNBruteForce(4, 3)); // HERE M is a power of 2 since 4 is 2^2 using left shift operator
        System.out.println("FIND M/2^N EQUALS "+findMDividedByTwoPowerN(4, 1));
    }

    // TC = 0(N), SC = O(1) using regular multiplication
    private static int findTwoPowerNBruteForce(int N) {
        int answer = 1;
        for (int i = 0; i < N; i++) {
            answer = answer * 2;
        }
        return answer;
    }

    // TC = 0(1), SC = O(1) using bit wise left shift operator (NOTE: Left shift operator only works for 2^N or in other words powers of 2)
    private static int findTwoPowerNOptimized(int N) {
        return 1 << N;
    }

    // TC = 0(N), SC = O(1) using regular multiplication: NOTE: Here we cannot use left shift operator since left shift operator only
    // works for powers of 2
    private static int findMPowerNBruteForce(int M, int N) {
        double v = Math.log(M) / Math.log(2);
        if ((int)(Math.ceil(v)) == (int)(Math.floor(v))) { // Check if M is a power of 2
             return 1 << (int)v * N; // Use left shift bit operator
        }
        //This is the case where M is not a power of 2 then just use plain multiplication
        int answer = 1;
        for (int i = 0; i < N; i++) {
            answer = answer * M;
        }
        return answer;
    }


    // TC = 0(1), SC = O(1) using bit wise right shift operator (NOTE: right shift operator only works for 2^N or in other words powers of 2)
    private static int findMDividedByTwoPowerN(int M, int N) {
        return M>>N;
    }

}

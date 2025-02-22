package com.recursion;

import com.util.ArrayUtils;

import java.util.List;

/**
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.).
 * NOTE: I PULLED THE SOLUTION FROM THE YOUTUBE LINK USING RECURSION AND IS A GREAT SOLUTION: https://www.youtube.com/watch?v=QRa9ZVGMWlY
 */
public class KthSymbol {

    // NOTE: I PULLED THE SOLUTION FROM THE FOLLOWING YOUTUBE LINK: https://www.youtube.com/watch?v=QRa9ZVGMWlY

    /**
     * TC = O (MIN(N, LOGK) AND SINCE K CAN BE MAXIMUM 2^N - 1 SINCE K CAN THE LAST ELEMENT IN NTH ROW, LOGK IS N
     * AND SO O(MIN(N, N) WHICH O(N) AND SC = O(N) WHICH IS THE SIZE OF THE CALL STACK SINCE THE RECURSIVE CALLS
     * GO ALL THE WAY UP AND STOP WHEN K = 0 OR N = 1 WHICH IS N CALLS
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("FIND THE SYMBOL AT THE NTH ROW AND KTH INDEX FOR THE ABOVE PROBLEM USING BRUTE FORCE "+ kthGrammarBruteForce(2, 1));
        System.out.println("FIND THE SYMBOL AT THE NTH ROW AND KTH INDEX FOR THE ABOVE PROBLEM USING RECURSION "+ kthGrammarUsingRecursion(2, 1));

        System.out.println("FIND THE SYMBOL AT THE NTH ROW AND KTH INDEX FOR THE ABOVE PROBLEM USING BRUTE FORCE "+ kthGrammarBruteForce(3, 3));
        System.out.println("FIND THE SYMBOL AT THE NTH ROW AND KTH INDEX FOR THE ABOVE PROBLEM USING RECURSION "+ kthGrammarUsingRecursion(3, 3));
    }

    private static int kthGrammarBruteForce(int N, int K) {
        final List<List<Integer>> result = ArrayUtils.generateKthSymbolSequence(N);
        return result.get(N-1).get(K);
    }
    // NOTE: BOTH K AND N ARE O-BASED VALUES
    private static int kthGrammarUsingRecursion(int N, int K) {
        if (N == 1) {
            return 0;
        }
        int parent = kthGrammarUsingRecursion(N-1, K / 2 + K % 2);
        // IF K IS AN EVEN INDEX THEN VALUE AT NTH ROW / KTH INDEX IS SAME AS VALUE OF PARENT AND K IS EVEN INDEX
        // THEN VALUE AT NTH ROW / KTH INDEX IS THE FLIPPED VALUE OF ITS PARENT
        if (K % 2 == 0) {
            return parent;
        }
        return parent == 0 ? 1 : 0;
    }

}


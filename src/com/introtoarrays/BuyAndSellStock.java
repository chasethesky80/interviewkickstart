package com.introtoarrays;

import java.util.Arrays;
import java.util.List;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BuyAndSellStock {

    public static void main(String[] args) {
        System.out.println("MAX PROFIT FOR ALL DAYS BRUTE FORCE "+ maxProfitBruteForce(new int[]{ 7,1,5,3,6,4 }));
        System.out.println("MAX PROFIT FOR ALL DAYS OPTIMIZED "+ maxProfitOptimized(new int[]{ 7,1,5,3,6,4 }));
        System.out.println("MAX PROFIT FOR ALL DAYS OPTIMIZED USING CARRY FORWARD TECHNIQUE "+ maxProfitOptimizedWithCarryForwardTechnique(Arrays.asList( 7,1,5,3,6,4 )));
        System.out.println("MAX PROFIT FOR ALL DAYS OPTIMIZED USING CARRY FORWARD TECHNIQUE "+ maxProfitOptimizedWithCarryForwardTechnique(Arrays.asList( 1,3,7,4,5 )));
        System.out.println("MAX PROFIT FOR ALL DAYS OPTIMIZED USING CARRY FORWARD TECHNIQUE "+ maxProfitOptimizedWithCarryForwardTechnique(Arrays.asList( 7,6,4,3,1 )));
    }

    // TC = O(N^2) DUE TO 2 NESTED FOR LOOPS AND SC = O(1) DUE TO NO EXTRA SPACE USED
    private static int maxProfitBruteForce(int[] prices) {
        int answer=Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                answer = Math.max(answer, prices[j] - prices[i]);
            }
        }
        return answer;
    }
    // TC = O(N) DUE TO SINGLE FOR LOOP AND SC = O(1) SINCE NO EXTRA SPACE USED
    private static int maxProfitOptimized(int[] prices) {
        int min=Integer.MAX_VALUE,pro=0;
        for(int i:prices)
        {
            if(i<min) {
                min = i;
            }
            pro = Math.max(pro,i-min);
        }
        return pro;
    }

    private static int maxProfitOptimizedWithCarryForwardTechnique(final List<Integer> input) {
        int maxElement = input.get(input.size() - 1);
        int maxProfit = Integer.MIN_VALUE;
        for (int i = input.size() - 2; i>= 0; i--) {
            if (input.get(i).compareTo(maxElement) > 0) {
                maxElement = input.get(i);
            }
            maxProfit = Math.max(maxProfit, maxElement - input.get(i));
        }
        return maxProfit;
    }
}

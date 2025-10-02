package com.introtoarrays;

/**
 * Find maximum number of consecutive ones in a given binary array
 */
public class FindMaxConsecutiveOnesInBinaryArray {

    public static void main(String[] args) {
        System.out.println("MAX CONSECUTIVE ONES IN BINARY ARRAY "+ findMaxConsecutiveOnes(new int[] {
                1, 1, 1, 0, 0, 1, 1, 1, 1, 1 }));
        System.out.println("MAX CONSECUTIVE ONES IN BINARY ARRAY "+ findMaxConsecutiveOnes(new int[] {
                1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }));
        System.out.println("MAX CONSECUTIVE ONES IN BINARY ARRAY "+ findMaxConsecutiveOnes(new int[] {
                0, 0, 1, 1, 0, 1, 1, 1, 1 }));
    }
    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = Integer.MIN_VALUE, countOfOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                countOfOnes++;
            } else {
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, countOfOnes);
                countOfOnes = 0;
            }
        }
        maxConsecutiveOnes = Math.max(maxConsecutiveOnes, countOfOnes);
        return maxConsecutiveOnes;
    }
}

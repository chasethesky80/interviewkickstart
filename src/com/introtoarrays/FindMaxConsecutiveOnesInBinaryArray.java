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
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int count = 0;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == 1) {
                        count++;
                    } else {
                        i = j;
                        break;
                    }
                }
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }
}

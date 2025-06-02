package com.bitmanipulation;

// Given an array of N elements, every element repeats itself twice except a unique element, find that unique element
// NOTE: This XOR solution works only when numbers repeat even number of times (like 2 times or 4 times or 6 times and so on)
// and solution does not work when they repeat odd number of times
public class FindUniqueElementInArrayFirstScenario {

    public static void main(String[] args) {
        System.out.println("FIND UNIQUE ELEMENT FOR ARRAY "+findUniqueElement(new int[]{ 2, 3, 2, 4, 3, 4, 5 })); // Each number repeats twice except one number
        System.out.println("FIND UNIQUE ELEMENT FOR ARRAY "+findUniqueElementAlternativeSolution(new int[]{ 2, 3, 2, 4, 3, 4, 5 })); // Each number repeats twice except one number
        System.out.println("FIND UNIQUE ELEMENT FOR ARRAY "+findUniqueElement(new int[]{ 2, 2, 7, 9, 7, 2, 7, 2, 7 })); // Each number repeats four times except one number
        System.out.println("FIND UNIQUE ELEMENT FOR ARRAY "+findUniqueElement(new int[]{ 2, 2, 7, 9, 7, 2 })); // XOR SOLUTION DOES NOT WORK HERE
        // Each number repeats three times except one number (IN THIS CASE XOR DOES NOT WORK) - HERE 2 REPEATS THREE TIMES SO XOR SOLUTION NOT WORKS
    }

    // TC = O(N) due to iterating the for loop N times and SC = O(1) due to no extra space
    private static int findUniqueElement(int[] input) {
        int answer = input[0];
        for (int i = 1; i < input.length; i++) {
            answer = answer  ^ input[i];
        }
        return answer;
    }

    private static int findUniqueElementAlternativeSolution(int[] input) {
        int answer = input[0];
        for (int i = 1; i < input.length; i++) {
            answer = answer  ^ input[i];
        }
        return answer;
    }
}

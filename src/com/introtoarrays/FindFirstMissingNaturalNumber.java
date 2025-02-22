package com.introtoarrays;

import java.util.Arrays;
import java.util.List;

public class FindFirstMissingNaturalNumber {

    public static void main(String[] args) {
        System.out.println("FIND FIRST MISSING NATURAL NUMBER "+ findFirstNaturalNumberOptimized(Arrays.asList(1, 6, 3, 2, 4)));
        System.out.println("FIND FIRST MISSING NATURAL NUMBER "+ findFirstNaturalNumberOptimized(Arrays.asList(1, 0, -5, -6, 4, 2)));
        System.out.println("FIND FIRST MISSING NATURAL NUMBER "+ findFirstNaturalNumberOptimized(Arrays.asList(4, 1, 3, 3, 2, 3)));
        System.out.println("FIND FIRST MISSING NATURAL NUMBER "+ findFirstNaturalNumberOptimized(Arrays.asList(4, 2, 7, 6, 9, 1, 8, 3)));
    }

    /**
     * Time complexity of O(N) and space complexity of O(1) since no extra space used
     * @param input
     * @return
     */
    private static int findFirstNaturalNumberOptimized(final List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            Integer current = input.get(i);
            while (current!= i+1 && current.compareTo(0) > 0 && current.compareTo(input.size()) <= 0) {
                Integer next = input.get(current - 1);
                /**
                 * HANDLE THE CASE WITH DUPLICATES SINCE IF THE CURRENT ELEMENT AND THE ELEMENT IT IS GETTING
                 * SWAPPED WITH ARE EQUAL THEN DO NOT SWAP AND BREAK FROM THE LOOP AND MOVE ON TO THE NEXT ELEMENT
                 */
                if (current.compareTo(next) == 0) {
                    break;
                }
                input.set(i, next);
                input.set(current-1, current);
                current = input.get(i);
            }
        }
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) != i+1) {
                return i+1;
            }
        }
        return input.size() + 1;
    }
}

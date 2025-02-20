package com.sorting;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("SORTED ELEMENTS USING BUBBLE SORT "+ performBubbleSort(Arrays.asList(2, 5, 3, 7, 1, 6)));
        System.out.println("SSORT ELEMENTS WITH BUBBLE SORT ALTERNATIVE "+ performBubbleSort(Arrays.asList(3, 8, 8, 2, -1, 5, 5, -3)));
    }

    /**
     * TIME COMPLEXITY IS O((N-1)*N/2) WHICH IS O(N^2) AND SC = O(1)
     * @param input
     * @return
     */
    private static List<Integer> performBubbleSort(final List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = input.size() - 1; j > i; j--) {
                if (input.get(j-1).compareTo(input.get(j)) > 0) {
                    int temp = input.get(j-1);
                    input.set(j-1, input.get(j));
                    input.set(j, temp);
                }
            }
        }
        return input;
    }
}

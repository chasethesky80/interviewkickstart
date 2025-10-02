package com.introtoarrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 */
public class FindIntersectionOfTwoArrays {

    public static void main(String[] args) {
        System.out.println("FIND INTERSECTION OF TWO ARRAYS " + Arrays.toString(intersection(new int[]{ 4, 5, 9 },
                new int[]{ 4, 4, 8, 9, 9 })));
    }

    private static int[] intersection(final int[] a, final int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        final Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                set.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}

package com.subarrays;

public class FindSubArrayWithMaximumProduct {

    public static void main(String[] args) {
        System.out.println("FIND SUBARRAY WITH MAX PRODUCT "+ findSubArrayWithMaximumProduct(new int[]{ 2, 3, -2, 4 }));
        System.out.println("FIND SUBARRAY WITH MAX PRODUCT "+ findSubArrayWithMaximumProduct(new int[]{ 2, 3, -2, -5 }));
        System.out.println("FIND SUBARRAY WITH MAX PRODUCT "+ findSubArrayWithMaximumProduct(new int[]{ 2, 3, -2, 4, -5 }));
        System.out.println("FIND SUBARRAY WITH MAX PRODUCT "+ findSubArrayWithMaximumProduct(new int[]{ -2, 0, -1 }));
        System.out.println("FIND SUBARRAY WITH MAX PRODUCT "+ findSubArrayWithMaximumProduct(new int[]{ -3, -1, -1 }));
    }

    private static Integer findSubArrayWithMaximumProduct(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0, prod = arr[left], maxProduct = 0;
        for (int right = 1; right < arr.length; right++) {
            prod *= arr[right];
            if (prod >= maxProduct) {
                maxProduct = prod;
            } else {
                left = right;
                prod = arr[left];
            }
        }
        return maxProduct;
    }
}

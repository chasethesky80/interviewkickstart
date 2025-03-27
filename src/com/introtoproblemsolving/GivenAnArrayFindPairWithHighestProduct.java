package com.introtoproblemsolving;

import com.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class GivenAnArrayFindPairWithHighestProduct {

     public static void main(String[] args) {
          final List<Integer> input = Arrays.asList(-1, -3, -4, 2, 0, -5);
          System.out.println("PAIR WITH HIGHEST PRODUCT "+ findPairWithHighestProductBruteForce(input));
          System.out.println("PAIR WITH HIGHEST PRODUCT OPTIMIZED "+ findPairWithHighestProductOptimized(input));
     }


     private static Pair findPairWithHighestProductBruteForce(final List<Integer> input) {
          Integer maxProduct = Integer.MIN_VALUE, left = -1, right = -1;
          for (int i = 0; i < input.size(); i++) {
               for (int j = i + 1; j < input.size(); j++) {
                    Integer current = Math.multiplyExact(input.get(i), input.get(j));
                    if (current > maxProduct) {
                         maxProduct = current;
                         left = i;
                         right = j;
                    }
               }
          }
          return new Pair(input.get(left), input.get(right));
     }

     /**
      * Find the max and secondMax of array and the min and secondMin of array since the array can have positive and
      * negative integers and then find the bigger value of the product of {max, secondMax} and {min, secondMin}
      * In this case since the array contains positive and negative numbers, the max and secondMax will be the highest
      * and second highest positive numbers and the min and secondMin will be the highest and second highest of the
      * negative numbers
      * @param input
      * @return
      */
     private static Pair findPairWithHighestProductOptimized(final List<Integer> input) {
          final Pair maxAndSecondMax = ArrayUtils.findTheMaxAndSecondMaxOfAnArray(input);
          final Pair minAndSecondMin = ArrayUtils.findTheMinAndSecondMinOfAnArray(input);
          if (Math.multiplyExact(maxAndSecondMax.getLeft(), maxAndSecondMax.getRight()) > Math.multiplyExact(
                  minAndSecondMin.getLeft(), minAndSecondMin.getRight())) {
               return maxAndSecondMax;
          } else {
               return minAndSecondMin;
          }
     }
}

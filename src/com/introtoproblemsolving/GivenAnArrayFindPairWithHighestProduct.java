package com.introtoproblemsolving;

import java.util.Arrays;
import java.util.List;

public class GivenAnArrayFindPairWithHighestProduct {

     public static void main(String[] args) {
          System.out.println("PAIR WITH HIGHEST PRODUCT "+ findPairWithHighestProduct(Arrays.asList(-1, -3, -4, 2, 0, -5)));
     }


     private static Pair findPairWithHighestProduct(final List<Integer> input) {
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
}

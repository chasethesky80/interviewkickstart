package com.bitmanipulation;

/**
 * EVERY NUMBER APPEARS 3 TIMES IN AN ARRAY EXCEPT A NUMBER THAT APPEARS ONLY ONCE AND FIND THAT NUMBER
 * //Refer Bosscoder Academy video -> IL : Maths 1 & Maths 2 for solution
 */
public class FindUniqueElementInArraySecondScenario {

    public static void main(String[] args) {
        System.out.println("FIND UNIQUE NUMBER IN ARRAY "+ findUnique(new int[]{ 3, 3, 3, 4, 5, 5, 5 }));
        System.out.println("FIND UNIQUE NUMBER IN ARRAY "+ findUnique(new int[]{ 7, 7, 3, 5, 7, 5, 5 }));
    }

    private static int findUnique(int[] arr) {
      int ans = 0;
      for (int i = 0; i < 32; i++) {
          int sum = 0;
          for (int j = 0; j < arr.length; j++) {
              sum += ((arr[j] >> i) & 1);
          }
          if (sum % 3 == 1) {
              ans |= (1 << i);
          }
      }
      return ans;
    }
}

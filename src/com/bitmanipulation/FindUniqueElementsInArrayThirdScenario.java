package com.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GIVEN AN ARRAY OF INTEGERS, EVERY ELEMENT APPEARS TWICE EXCEPT 2 ELEMENTS THAT APPEAR ONLY ONCE, FIND THOSE 2 NUMBERS
 */
public class FindUniqueElementsInArrayThirdScenario {

    public static void main(String[] args) {
        System.out.println("UNIQUE NUMBERS IN ARRAY "+ Arrays.toString(findUniqueNumbers(new int[]{ 1, 3, 1, 4, 5, 3 })));
        System.out.println("UNIQUE NUMBERS IN ARRAY "+ Arrays.toString(findUniqueNumbers(new int[]{ 6, 3, 6, 4, 2, 4 })));
    }

    private static int[] findUniqueNumbers(int[] arr) {
        int xorResult = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xorResult ^= arr[i];
        }
        /**
         * FIND INDEX "I" OF FIRST SET BIT IN XOR RESULT AND DIVIDE ARRAY INTO 2 GROUPS, FIRST GROUP
         * WHOSE ITH BIT IS SET AND THE OTHER GROUP WHOSE ITH BIT IS NOT SET AND XOR THE INDIVIDUAL 2 GROUPS
         * TO RETURN THE 2 UNIQUE NUMBERS
         * NOTE: TO CHECK IF A BIT i IS SET IN A NUMBER N, THE CHECK IS :- ((N >> i) & 1) == 1 (REFER BIT MANIPULATION NOTES)
         */
        int bit = 0;
        for (int j = 0; j < 32; j++) {
            if (((xorResult >> j) & 1) == 1) {
                bit = j;
                break;
            }
        }
        final List<Integer> firstGroup = new ArrayList<>();
        final List<Integer> secondGroup = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (((arr[i] >> bit) & 1) == 1) {
                firstGroup.add(arr[i]);
            } else {
                secondGroup.add(arr[i]);
            }
        }
        int firstNum = firstGroup.get(0);
        for (int i = 1; i < firstGroup.size(); i++) {
            firstNum ^= firstGroup.get(i);
        }
        int secondNum = secondGroup.get(0);
        for (int i = 1; i < secondGroup.size(); i++) {
            secondNum ^= secondGroup.get(i);
        }
        return new int[] { firstNum, secondNum };
    }
}

package com.bitmanipulation;

public class GenerateNoWithAllXSetBits {

    public static void main(String[] args) {
        System.out.println("NUMBER GENERATED AFTER X SET BITS "+ generateNumberWithXSetBits(2));
        System.out.println("NUMBER GENERATED AFTER X SET BITS "+ generateNumberWithXSetBits(3));
        System.out.println("NUMBER GENERATED AFTER X SET BITS "+ generateNumberWithXSetBits(4));
        System.out.println();
        // CALLING OPTIMIZED METHOD WITH JUST ONE LINE OF CODE BUT SAME TIME COMPLEXITY AS O(1)
        System.out.println("NUMBER GENERATED AFTER X SET BITS "+ generateNumberXSetBitsLesserLinesOfCode(2));
        System.out.println("NUMBER GENERATED AFTER X SET BITS "+ generateNumberXSetBitsLesserLinesOfCode(3));
        System.out.println("NUMBER GENERATED AFTER X SET BITS "+ generateNumberXSetBitsLesserLinesOfCode(4));
    }
    // TC = O(x) where x is number of bits to set and SC = O(1) since no extra space used
    private static int generateNumberWithXSetBits(int x) {
        int n = 0;
        for (int i = 0; i < x; i++) {
            n = n | (1 << i);
        }
        return n;
    }

    // TC = O(x) where x is number of bits to set and SC = O(1) since no extra space used
    // Number with x set bits = 2^x - 1, for eg: number with 2 set bits is 3, 3 set bits is 7, 4 set bits is 15 and so on
    // and so forth, so with x set bits is :- 2^x - 1 which is 1 << x - 1
    private static int generateNumberXSetBitsLesserLinesOfCode(int x) {
        return (1 << x) - 1;
    }

    // TC = O(1), same solution as above method except now we need to add Y unset bits to right of X set bits
    // which basically will shift number Y times or by Y bits to the left after generating number by adding the X set bits
    // So the solution will be 2^x - 1, then shift left by Y unset bits
    private static int generateNumberXSetBitsAndAddYUnsetBitsToRight(int x, int y) {
        return ((1 << x) - 1) << y;
    }
}

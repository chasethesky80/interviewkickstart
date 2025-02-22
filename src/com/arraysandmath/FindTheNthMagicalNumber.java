package com.arraysandmath;

import com.util.ArrayUtils;
import com.util.BitManipulationHelper;

import java.util.Arrays;
import java.util.stream.IntStream;

// Given a number N, return the Nth magical number, NOTE: A magical number is a number that can be represented as sum
// of unique powers of 5 where the power > 0
public class FindTheNthMagicalNumber {

    public static void main(String[] args) {
        System.out.println("FIND THE 3RD MAGICAL NUMBER "+ findNthMagicalNumber(3));
        System.out.println("FIND THE 3RD MAGICAL NUMBER ALTERNATIVE "+ findNthMagicalNumberAlternative(3));
        System.out.println("FIND THE 6TH MAGICAL NUMBER "+ findNthMagicalNumber(6));
        System.out.println("FIND THE 6TH MAGICAL NUMBER ALTERNATIVE "+ findNthMagicalNumberAlternative(6));
        System.out.println("FIND THE 11TH MAGICAL NUMBER "+ findNthMagicalNumber(11));
        System.out.println("FIND THE 11TH MAGICAL NUMBER ALTERNATIVE "+ findNthMagicalNumberAlternative(11));
        System.out.println("FIND THE 22ND MAGICAL NUMBER "+ findNthMagicalNumber(22));
        System.out.println("FIND THE 22ND MAGICAL NUMBER "+ findNthMagicalNumberAlternative(22));
    }

    private static int findNthMagicalNumber(int N) {
        // PLEASE REFER LECTURE VIDEO FOR EXPLANATION OF APPROACH, FOLLOWING ARE THE 2 STEPS NEEDED TO COMPUTE THE NTH MAGICAL NUMBER
        // 1) FIRST CONVERT N TO BINARY FORM
        // 2) THEN SUM ALL THE VALUES THAT ARE PRESENT IN THE RESPECTIVE BITS OF THE BINARY FORM:
        // FOR EG: TO FIND THE 11th MAGICAL NUMBER, CONVERT 11 TO BINARY FORM WHICH IS :- 1011
        // THEN COMPUTE AND ADD FROM LEFT MOST BIT TO RIGHT MOST BIT :- 1 * 5^4 + 0 * 5^3 + 1 * 5^2 + 1 * 5^1 = 625 + 0 + 25 + 5 = 655,
        // HERE THE POWERS OF THE BITS WILL BE 1-BASED INDEX INSTEAD OF 0-BASED INDEX IN REGULAR BINARY TO DECIMAL CONVERSION
        int[] binary = BitManipulationHelper.convertToBinary(N, 32);
        return (int) IntStream.range(0, binary.length)
                .mapToDouble(idx -> binary[idx] * Math.pow(5, idx+1)).sum();
    }

    private static int findNthMagicalNumberAlternative(int N) {
        // PLEASE REFER LECTURE VIDEO FOR EXPLANATION OF APPROACH, FOLLOWING ARE THE 2 STEPS NEEDED TO COMPUTE THE NTH MAGICAL NUMBER
        // 1) FIRST CONVERT N TO BINARY FORM
        // 2) THEN SUM ALL THE VALUES THAT ARE PRESENT IN THE RESPECTIVE BITS OF THE BINARY FORM:
        // FOR EG: TO FIND THE 11th MAGICAL NUMBER, CONVERT 11 TO BINARY FORM WHICH IS :- 1011
        // THEN COMPUTE AND ADD FROM LEFT MOST BIT TO RIGHT MOST BIT :- 1 * 5^4 + 0 * 5^3 + 1 * 5^2 + 1 * 5^1 = 625 + 0 + 25 + 5 = 655,
        // HERE THE POWERS OF THE BITS WILL BE 1-BASED INDEX INSTEAD OF 0-BASED INDEX IN REGULAR BINARY TO DECIMAL CONVERSION
        int[] binary = BitManipulationHelper.convertToBinary(N, 32);
        int[] reversed = ArrayUtils.reversePartOfArray(binary, 0, binary.length-1);
        int sum = 0;
        for (int i = 0; i < reversed.length; i++) {
            sum += (reversed[i] * Math.pow(5, reversed.length - i));
        }
        return sum;
    }
}

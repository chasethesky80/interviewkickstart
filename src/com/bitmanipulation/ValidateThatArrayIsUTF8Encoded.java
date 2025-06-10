package com.bitmanipulation;

/**
 * Given an integer array data representing the data, return whether it is a valid UTF-8 encoding (i.e. it translates to a sequence of valid UTF-8 encoded characters).
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 * For a 1-byte character, the first bit is a 0, followed by its Unicode code.
 * For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0, followed by n - 1 bytes
 * with the most significant 2 bits being 10.
 */
public class ValidateThatArrayIsUTF8Encoded {

    private static boolean validUTF8(int[] chars) {
        int count = 0; // Determines if it is a 1 or 2 or 3 byte character by counting number of most significant 1s in number
        int mask1 = 1 << 7; // 10000000
        int mask2 = 1 << 6; // 01000000
        for (int i = 0; i < chars.length; i++) {
            int current = chars[i];
            int last8Bits = current & 255; // Get the last 8 bits of the current number
            if (count == 0) {
                int mask3 = 1 << 7; // 10000000
                while ((last8Bits & mask3) != 0) {
                    count++;
                    mask3 >>= 1;
                }
                if (count == 0) { // 0-byte character so nothing to process go to next element in array
                    continue;
                }
                if (count == 1 || count == 4) { // If number of most significant 1s is 1 or 4 then it does not follow pattern
                    return false;
                }
            } else { // PROCESS THE REMAINING ELEMENTS OF ARRAY TO CHECK IF IT CONTAINS PATTERN 10XXXXXX
                if (!(((current&mask1) == 0) && !((current&mask2) == 1))) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
}

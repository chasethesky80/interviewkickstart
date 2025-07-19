package com.recursion;

public class GenerateAllBinaryStringsOfLengthN {

    /**
     * TIME COMPLEXITY USING RECURSION - O(2^N) AND SC = O(N)
     * REFER BOSSCODER ACADEMY VIDEO: https://platform.bosscoderacademy.com/course/SjP8t8VfLx8zGa8wbGaU
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Generate All Binary Strings of Length N ");
        generate("", 3);
    }
    private static void generate(String str, int n) {
        if (str.length() == n) {
            System.out.println(str);
            return;
        }
        generate(str + "0", n);
        generate(str + "1", n);
    }
}

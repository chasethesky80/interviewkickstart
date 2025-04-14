package com.introtoproblemsolving;

import java.util.Arrays;
import java.util.List;

public class AddOneToAnArrayOfNumbers {

    public static void main(String[] args) {
        System.out.println("ADD ONE "+ addOne(Arrays.asList(1, 2, 3)));
        System.out.println("ADD ONE "+ addOne(Arrays.asList(9, 9, 9)));
    }

    private static Integer addOne(final List<Integer> input) {
        double sum = 0;
        int N = input.size();
        for (int i = 0; i < N; i++) {
            sum = sum + (input.get(i) * Math.pow(10, N - (i+1)));
        }
        return (int)(sum + 1);
    }
}

package com.introtoproblemsolving;

import java.util.ArrayList;
import java.util.List;

public class AddOneToAnArrayOfNumbers {

    public static void main(String[] args) {
        System.out.println("ADD ONE "+ addOne(new ArrayList<>(List.of(1, 2, 3))));
        System.out.println("ADD ONE "+ addOne(new ArrayList<>(List.of(9, 9, 9))));
    }

    private static List<Integer> addOne(final List<Integer> input) {
        for (int i = input.size() - 1; i >= 0; i--) {
            input.set(i, input.get(i) + 1);
            if (input.get(i).compareTo(10) < 0) {
                return input;
            }
            input.set(i, 0);
        }
        input.add(0, 1);
        return input;
    }
}

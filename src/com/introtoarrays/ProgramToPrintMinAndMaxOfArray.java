package com.introtoarrays;

import java.util.Arrays;
import java.util.List;

public class ProgramToPrintMinAndMaxOfArray {

    public static void main(String args[]) {
            System.out.println("MAX AND MIN OF ARRAY "+ Arrays.toString(findMaxAndMinOfArray(List.of(8, 5, 1, 2, 3, 4, 5))));
        System.out.println("MAX AND MIN OF ARRAY "+ Arrays.toString(findMaxAndMinOfArray(List.of(80, 10, 30 ))));
    }

    private static Integer[] findMaxAndMinOfArray(final List<Integer> input) {
        Integer max = input.get(0), min = input.get(0);
        for (int i =1; i < input.size(); i++) {
            Integer current = input.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            } else if (current.compareTo(min) < 0){
                min = current;
            }
        }
        return new Integer[]{ max, min };
    }
}

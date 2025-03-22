package com.introtoproblemsolving;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println("PASCAL TRIANGLE "+ printPascalTriangle(5));
    }

    private static List<List<Integer>> printPascalTriangle(final Integer N) {
        final List<List<Integer>> input = new ArrayList<>();
        for (int row = 0; row < N; row++) {
            final List<Integer> currentRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (col == 0 || row == col) {
                    currentRow.add(1);
                } else {
                    final List<Integer> previousRow = input.get(row-1);
                    if (previousRow != null) {
                        final Integer left = previousRow.get(col-1);
                        final Integer right = previousRow.get(col);
                        currentRow.add(Integer.sum(left, right));
                    }
                }
            }
            input.add(currentRow);
        }
        return input;
    }
}

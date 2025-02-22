package com.recursion;

import com.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
        System.out.println("GRAY CODE FOR "+ grayCode(2));
        System.out.println("GRAY CODE FOR "+ grayCode(3));
    }
    private static List<Integer> grayCode(int N) {
        if (N == 1) {
            return new ArrayList<>(Arrays.asList(0, 1));
        }
        final List<Integer> result = grayCode(N-1);
        final List<Integer> secondPart = new ArrayList<>(result);
        ArrayUtils.reversePartOfArray(secondPart, 0, secondPart.size() - 1);
        for (Integer element: secondPart) {
            result.add((int)(Math.pow(2, N-1)) + element);
        }
        return result;
    }
}

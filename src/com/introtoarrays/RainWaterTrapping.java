package com.introtoarrays;

import com.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class RainWaterTrapping {

    public static void main(String[] args) {
        System.out.println("COMPUTE RAIN WATER TRAPPED IN ARRAY "+ computeRainWaterTrapped(Arrays.asList(2, 1, 3, 2, 1, 2, 4, 3, 2, 1, 3, 1)));
    }
    private static int computeRainWaterTrapped(final List<Integer> input) {
        final List<Integer> leftMaxArray = ArrayUtils.constructLeftMaxArray(input);
        final List<Integer> rightMaxArray = ArrayUtils.constructRightMaxArray(input);
        int answer = 0;
        for (int i = 0; i < input.size(); i++) {
            int leftMax = leftMaxArray.get(i);
            int rightMax = rightMaxArray.get(i);
            int min = Math.min(leftMax, rightMax);
            int delta = Math.max(min - input.get(i), 0);
            answer = answer + delta;
        }
        return answer;
    }
}

package com.arrayinterviewproblems;

import com.util.ArrayUtils;

import java.util.*;

public class PracticeSection {

    private static List<Integer> computePrefixSum(List<Integer> arr) {
        final List<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            prefixSum.add(arr.get(i) + prefixSum.get(i - 1));
        }
        return prefixSum;
    }

    public static void main(String[] args) {
        System.out.println(computePrefixSum(Arrays.asList(2, 4, 1, 5, 7, 9)));
        System.out.println(lengthOfSmallestMinMax(Arrays.asList( 1, 2, 3, 1, 3, 4, 6, 4, 6, 3 )));
        System.out.println(lengthOfSmallestMinMaxBruteForce(Arrays.asList( 1, 2, 3, 1, 3, 4, 6, 4, 6, 3 )));
        System.out.println();
        System.out.println(lengthOfSmallestMinMax(Arrays.asList( 8, 8, 8, 8, 8, 8 )));
        System.out.println(lengthOfSmallestMinMaxBruteForce(Arrays.asList( 8, 8, 8, 8, 8, 8 )));
        System.out.println();
        System.out.println(lengthOfSmallestMinMax(Arrays.asList( 2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1 )));
        System.out.println(lengthOfSmallestMinMaxBruteForce(Arrays.asList( 2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1 )));
        System.out.println("FIND MAXSUM OF SUBARRAY OF LENGTH K "+ computeMaxSumOfSubArrayOfLength(List.of( -3, 4, -2, 5, 3, -2, 8, 2, -1, 4 ), 5));
        System.out.println("MISSING NUMBER IN AP SERIES "+ findMissingNumberInArithmeticProgression(Arrays.asList(2, 4, 8, 10, 12, 14)));
        System.out.println("FIND THE MISSING NUMBER IN THE ARRAY "+ findMissingNumberInArithmeticProgression(Arrays.asList(3, 6, 9, 15, 18)));
        System.out.println("FIND THE MISSING NUMBER IN THE ARRAY "+ findMissingNumberInArithmeticProgression(Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24)));
        System.out.println("IS NUMBER PERFECT NUMBER "+ isPerfectNumber(28));
        System.out.println("IS NUMBER PERFECT NUMBER "+ isPerfectNumber(100));
        System.out.println("MAX CONSECUTIVE ONES "+ maxNoOfConsecutiveOnes(Arrays.asList( 1, 1, 0, 1, 1, 1 )));
        System.out.println("MAX CONSECUTIVE ONES "+ maxNoOfConsecutiveOnes(Arrays.asList( 1, 1, 1, 1, 1, 0, 1, 1, 1 )));
        System.out.println("SUBARRAY EXISTS WITH SUM "+subArrayWithSumKExists(Arrays.asList(1, 10, 4, 0, 3, 5), 7));
        printSumOfAllSubArraysOfLength(Arrays.asList(1, 10, 4, 0, 3, 5), 3);
        System.out.println("MAX SUB-ARRAY SUM OF LENGTH K OPTIMIZED WITH SLIDING WINDOW TECHNIQUE " + maxSumOfSubArrayOfLength(List.of(3, -2, 4, -1, 2, 6), 3));
        System.out.println("MAX SUB-ARRAY SUM OF LENGTH K OPTIMIZED WITH SLIDING WINDOW TECHNIQUE " + maxSumOfSubArrayOfLengthAlternative(List.of(3, -2, 4, -1, 2, 6), 3));
        System.out.println("MAX SUB-ARRAY SUM OF LENGTH K OPTIMIZED WITH SLIDING WINDOW TECHNIQUE " + maximumSubarraySum(new int[]{ 3, -2, 4, -1, 2, 6 }, 3));
        System.out.println("NO OF SUBARRAYS WITH SIZE K AND SUM Q " + noOfSubarraysOfSizeKWithSum(List.of(1, 2, 3, 2, 3, 4), 2, 5));
        System.out.println("NO OF SUBARRAYS WITH SIZE K AND SUM Q " + noOfSubarraysOfSizeKWithSum(List.of(1, 2, 3, 2, 4, 5, 6), 2, 5));
        System.out.println("GET QUARTER FOR MONTH " + getQuarter("January"));
        System.out.println("GET QUARTER FOR MONTH " + getQuarter("April"));
        System.out.println("GET QUARTER FOR MONTH " + getQuarter("July"));
        System.out.println("INTERSECTION OF 2 ARRAYS "+ findIntersectionOfTwoArrays(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 6, 7, 8}));
        System.out.println("INTERSECTION OF 2 ARRAYS "+ findIntersectionOfTwoArrays(new int[]{ 4, 5, 9 }, new int[]{ 4, 4, 8, 9, 9 }));
        System.out.println("MAX OF STOCKS "+findMaxOfProfit(new int[]{ 7, 1, 5, 3, 6, 4, 0, 2, 6, 10, 9 }));
        System.out.println("ROTATED ARRAY "+ Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 1)));
        System.out.println("ROTATED ARRAY "+ Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2)));
        System.out.println("ARRAY INTERSECTION "+ Arrays.toString(intersection(new int[]{ 4, 9, 5 }, new int[]{ 9, 4, 9, 8, 4 })));
    }


    private static Integer lengthOfLastWord(String s) {
        final String[] words = s.trim().split("\\s+");
        return words[words.length-1].length();
    }

    private static Integer lengthOfSmallestMinMax(List<Integer> arr) {
       Integer[] minMax = ArrayUtils.findMinAndMaxOfGivenArray(arr);
       int min = minMax[0];
       int max = minMax[1];
        if (min == max) {
            return 1;
        }
       int answer = Integer.MAX_VALUE;
       int minIndex = -1, maxIndex = -1;
       for (int i = arr.size()-1; i >= 0; i--) {
           if (arr.get(i) == min) {
               minIndex = i;
           }
           else if (arr.get(i) == max) {
               maxIndex = i;
           }
           if (minIndex != -1 && maxIndex != -1) {
               answer = Math.min(answer, Math.abs(maxIndex - minIndex) + 1);
           }
       }
       return answer;
    }

    private static Integer lengthOfSmallestMinMaxBruteForce(List<Integer> arr) {
        Integer[] minMax = ArrayUtils.findMinAndMaxOfGivenArray(arr);
        int min = minMax[0];
        int max = minMax[1];
        if (min == max) {
            return 1;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == min) {
                for (int j = i+1; j < arr.size(); j++) {
                    if (arr.get(j) != max) {
                        continue;
                    }
                    answer = Math.min(answer, Math.abs(j - i) + 1);
                    break;
                }
            }
            else if (arr.get(i) == max) {
                for (int j = i+1; j < arr.size(); j++) {
                    if (arr.get(j) != min) {
                        continue;
                    }
                    answer = Math.min(answer, Math.abs(j - i) + 1);
                    break;
                }
            }
        }
        return answer;
    }

    private static Integer computeMaxSumOfSubArrayOfLength(final List<Integer> arr, final int K) {
        int maxSum = Integer.MIN_VALUE;
        final List<Integer> prefixSum = computePrefixSum(arr);
        int N = arr.size();
        for (int i = 0; i <= N - K; i++) {
            int j = K + i -1;
            int sum = i == 0 ? prefixSum.get(j) : prefixSum.get(j) - prefixSum.get(i - 1);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    private static Integer findMissingNumberInArithmeticProgression(List<Integer> arr) {
        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            minDifference = Math.min(minDifference, Math.abs(arr.get(i) - arr.get(i - 1)));
        }
        int first = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            int expected = first + (i*minDifference);
            if (expected != arr.get(i)) {
                return expected;
            }
        }
        return -1;
    }

    private static boolean isPerfectNumber(int N) {
        int sum = 1;
        for (int i = 2; i*i < N; i++) {
            if (N % i == 0) {
                sum += i;
                if (i != N / i) {
                    sum += N / i;
                }
            }
        }
        return sum == N;
    }

    private static Integer maxNoOfConsecutiveOnes(List<Integer> arr) {
        int maxNoOfConsecutiveOnes = Integer.MIN_VALUE, currentOneCount = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) {
                maxNoOfConsecutiveOnes = Math.max(maxNoOfConsecutiveOnes, currentOneCount);
                currentOneCount = 0;
            } else {
                currentOneCount++;
            }
        }
        maxNoOfConsecutiveOnes = Math.max(maxNoOfConsecutiveOnes, currentOneCount);
        return maxNoOfConsecutiveOnes;
    }

    private static boolean subArrayWithSumKExists(final List<Integer> arr, final int K) {
        int i = 0, j = 0, sum = arr.get(i);
        while (j < arr.size()) {
            if (sum < K) {
                j++;
                sum += arr.get(j);
            } else if (sum > K) {
                sum = sum - arr.get(i);
                i++;
            } else {
                System.out.println("i and j is " + i + " and sum is " + j);
                return true;
            }
        }
        return false;
    }

    private static void printSumOfAllSubArraysOfLength(final List<Integer> arr, int K) {
        final List<Integer> prefixSum = computePrefixSum(arr);
        int N = arr.size();
        for (int i =0; i <= N - K; i++) {
            int j = K + i - 1;
            int sum = i == 0 ? prefixSum.get(j) : prefixSum.get(j) - prefixSum.get(i - 1);
            System.out.println("SUM FOR SUBARRAY OF SIZE "+ K +" FOR START AND END INDICES i and j "+ i + "  "+ j +" and sum is " + sum);
        }
    }

    private static List<Integer> getPrefixSumArray(final List<Integer> arr) {
        final List<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            prefixSum.add(arr.get(i) + prefixSum.get(i - 1));
        }
        return prefixSum;
    }

    private static Integer maxSumOfSubArrayOfLength(final List<Integer> arr, int K) {
        int maxSum = Integer.MIN_VALUE, sum = 0, N = arr.size();
        for (int i = 0; i < K; i++) {
            sum += arr.get(i);
        }
        maxSum = sum;
        for (int i = 1; i <= N - K; i++) {
            int j = K + i - 1;
            sum = sum + arr.get(j) - arr.get(i-1);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    private static Integer maxSumOfSubArrayOfLengthAlternative(final List<Integer> arr, int K) {
        int maxSum = Integer.MIN_VALUE, sum = 0, N = arr.size();
        int end;
        int start = 0;
        for (end = 0; end < K; end++) {
            sum += arr.get(end);
        }
        while (end <  N) {
            sum = sum + arr.get(end) - arr.get(start);
            end++;
            start++;
            maxSum = Math.max(maxSum, sum);
        }
        maxSum = sum;
        return maxSum;
    }

    private static Integer noOfSubarraysOfSizeKWithSum(final List<Integer> arr, final int K, final int Q) {
        int count = 0, sum = 0, N = arr.size();
        for (int i = 0; i < K; i++) {
            sum += arr.get(i);
            if (sum == Q) {
                count++;
            }
        }
        for (int i = 1; i <=N-K; i++) {
            int j = K + i - 1;
            sum = sum + arr.get(j) - arr.get(i-1);
            if (sum == Q) {
                count++;
            }
        }
        return count;
    }

    private static long maximumSubarraySum(int[] nums, int k) {
        int st = 0, end = 0, N = nums.length, maxSum = Integer.MIN_VALUE, sum = 0;
        while (end < k) {
            sum = sum + nums[end];
            end++;
        }
        maxSum = sum;
        while (end < N) {
            sum = sum + nums[end];
            sum = sum - nums[st];
            maxSum = Math.max(maxSum, sum);
            st++;
            end++;
        }
        return maxSum;
    }

    private static String getQuarter(final String month) {
        return switch (month) {
            case "January", "February", "March" -> "Q1";
            case "April", "May", "June" -> "Q2";
            case "July", "August", "September" -> "Q3";
            case "October", "November", "December" -> "Q4";
            default -> {
                yield "Bad Response";
            }
        };
    }

    private static Set<Integer> findIntersectionOfTwoArrays(final int[] arr1, final int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Set<Integer> intersection = new HashSet<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                intersection.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return intersection;
    }

    private static  Integer findMaxOfProfit(final int[] arr) {
        int min = Integer.MAX_VALUE, ans = 0;
        for (int i: arr) {
            if (i < min) {
                min = i;
            }
            ans = Math.max(ans, i - min);
        }
        return ans;
    }

    private static int[] rotateArray(final int[] arr, int K) {
        int N = arr.length - 1;
        ArrayUtils.reversePartOfArray(arr, 0, N-1);
        ArrayUtils.reversePartOfArray(arr, 0, N-K-1);
        ArrayUtils.reversePartOfArray(arr, N-K, N-1);
        return arr;
    }

    private static int[] intersection(final int[] arr1, final int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Set<Integer> intersection = new HashSet<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                intersection.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();

    }

    private int maxSumOfSubArrayOfLength(final int[] arr, final int K) {
        int sum = 0, maxSum = Integer.MIN_VALUE, i = 0, end = 0;;
        for (end = 0; end < K; end++) {
            sum += arr[end];
        }
        maxSum = sum;
        while (end < arr.length) {
            sum = sum + arr[end] - arr[i];
            maxSum = Math.max(maxSum, sum);
            i++;
            end++;
        }
        return maxSum;
    }
}

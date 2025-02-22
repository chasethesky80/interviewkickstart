package com.arraysandmath;

import com.util.NumberUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Given N doors and a person standing in front of each door, initially all doors are closed and ith person will toggle
// all doors whose indices are multiples of i, then find all doors that remain open after the toggling is complete for
// all doors
public class FindAllDoorsOpenOutOfNDoorsAfterToggle {

    public static void main(String[] args) {
        System.out.println("ALL DOORS THAT REMAIN OPEN AFTER TOGGLING FOR VALUE OF N "+ findAllOpenDoors(16));
        System.out.println("ALL DOORS THAT REMAIN OPEN AFTER TOGGLING FOR VALUE OF N "+ findAllOpenDoors(37));
        System.out.println("NUMBER OF DOORS THAT REMAIN OPEN AFTER TOGGLING FOR VALUE OF N "+ findAllOpenDoors(100).size());
    }

    // TC = O(N*SQRT(N)) SINCE WE LOOP FROM 1 TO N AND FOR EACH NUMBER CHECK IF ITS PERFECT SQUARE IN SQRT(N) ITERATIONS
    // HENCE TOTAL TC IS N*SQRT(N) AND SC = O(NO OF PERFECT SQUARES TILL N) AS EXTRA LIST IS USED TO ADD ALL PERFECT
    // SQUARES TILL N
    private static List<Integer> findAllOpenDoors(int N) {
        // CONCLUSION: ALL DOORS THAT HAVE AN INDEX VALUE THAT HAS EVEN NO OF FACTORS WILL REMAIN CLOSED AND THE DOORS
        // WITH INDEX VALUE THAT HAS ODD NO OF FACTORS WILL REMAIN OPEN (REFER LECTURE VIDEO FOR EXPLANATION)
        // ALSO ONLY THOSE INDICES THAT ARE PERFECT SQUARES WILL HAVE ODD NO OF FACTORS AND HENCE WILL REMAIN OPEN AND
        // THE OTHER INDICES WILL HAVE EVEN NUMBER OF FACTORS WILL REMAIN CLOSED AFTER TOGGLE OPERATION
        // HENCE THE SOLUTION BOILS DOWN TO THE LIST OF PERFECT SQUARES FROM 1 TO N (BOTH 1 AND N INCLUSIVE)
        return IntStream.rangeClosed(1, N).boxed().filter(NumberUtils::checkPerfectSquare).collect(Collectors.toList());
    }
}

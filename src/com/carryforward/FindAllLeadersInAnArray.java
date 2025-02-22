package com.carryforward;

import java.util.List;

// GIVEN AN ARRAY OF N ELEMENTS, A LEADER IS AN ELEMENT OF THE ARRAY THAT IS GREATER THAN ALL ELEMENTS TO ITS RIGHT,
// FIND THE COUNT OF ALL THE LEADERS IN THE ARRAY.
// NOTE: THE ELEMENT AT INDEX - N-1 IS A LEADER SINCE IT IS NO ELEMENTS TO ITS RIGHT TO COMPARE AGAINST
public class FindAllLeadersInAnArray {

    public static void main(String[] args) {
        System.out.println("NO OF LEADERS IN ARRAY "+ getNumberOfLeadersInTheArray(List.of( 15, -1, 7, 2, 5, 4, 2, 3 )));
        System.out.println("NO OF LEADERS IN ARRAY "+ getNumberOfLeadersInTheArray(List.of( 10, 7, 9, 3, 2, 4, 5 )));
    }

    // TC = O(N) due to just a simple for loop and SC = O(1) since no extra space needed
    private static int getNumberOfLeadersInTheArray(final List<Integer> input) {
        int count = 1;
        int N = input.size();
        Integer currentLeader = input.get(N-1);
        for (int i = input.size() -2; i >=0; i--) {
            if (input.get(i).compareTo(currentLeader) > 0) {
                count++;
                currentLeader = input.get(i);
            }
        }
        return count;
    }
}

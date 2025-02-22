package com.arraysandmath;

// N people are standing in a circle and killing starts at position 1, find the position you have to stand at so that you are the survivor or last
// man standing
public class JosephusProblem {

    public static void main(String[] args) {
        System.out.println("GET LAST MAN STANDING POSITION FOR N PEOPLE AND STARTING POSITION AS (2, 1) EQUALS "+getLastManStandingPosition(2, 1));
        System.out.println("GET LAST MAN STANDING POSITION FOR N PEOPLE AND STARTING POSITION OF (4, 3) EQUALS "+getLastManStandingPosition(4, 3));
        System.out.println("GET LAST MAN STANDING POSITION FOR N PEOPLE AND STARTING POSITION OF (8, 2) EQUALS "+getLastManStandingPosition(8, 2));
        System.out.println("GET LAST MAN STANDING POSITION FOR N PEOPLE AND STARTING POSITION OF (11, 1) EQUALS "+getLastManStandingPosition(11, 1));
        System.out.println("GET LAST MAN STANDING POSITION FOR N PEOPLE AND STARTING POSITION OF (13, 1) EQUALS "+getLastManStandingPosition(13, 1));
    }

    private static int getLastManStandingPosition(int N, int startingPosition) {
        int i = 1;
        while (Math.pow(2, i) <= N) {
            i++;
        }
        int noOfKills = (int)(N - Math.pow(2, i-1));
        return 2 * noOfKills + startingPosition;
    }
}

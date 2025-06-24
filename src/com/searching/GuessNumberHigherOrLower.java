package com.searching;

/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 * You call a pre-defined API int guess(int num), which returns three possible results:
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 */
public class GuessNumberHigherOrLower {

    public static void main(String[] args) {
        System.out.println("GUESS NUMBER TO PICK "+ guessNumber(3));
    }

    /**
     * Here the guess API is not implemented so i am commenting out the method below and call to guess API
     * @param n
     * @return
     */
//    private static int guessNumber(int n) {
//        int low = 1, high = n;
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            if (guess(mid) == 0) {
//                return mid;
//            }
//            if (guess(mid) == -1) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        return -1;
//    }
}

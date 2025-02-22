package com.recursion;

/**
 * Tower of hanoi using recursion
 */
public class TowerOfHanoiSolution {

    public static void main(String[] args) {
        System.out.println("PERFORM TOWER OF HANOI AS FOLLOWS ");
        towerOfHanoi(3, 'A', 'C', 'B');
    }

    private static void towerOfHanoi(int N, char src, char dest, char helper) {
        if (N == 0) {
            return;
        }
        towerOfHanoi(N-1, src, helper, dest);
        System.out.println("MOVING DISC FROM SOURCE "+ src +" TO "+ dest);
        towerOfHanoi(N-1, helper, dest, src);
    }
}

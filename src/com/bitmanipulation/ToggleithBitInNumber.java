package com.bitmanipulation;

public class ToggleithBitInNumber {

    private Integer toggleIthBit(int N, int i) {
        return N ^ (1 << i);
    }
}

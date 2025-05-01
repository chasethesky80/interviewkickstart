package com.introtoproblemsolving;

import java.util.HashMap;
import java.util.Map;

public class FindAllPrimeNumbersTillN {

    public static void main(String[] args) {
        System.out.println("PRINT ALL PRIME NUMBERS FROM 1 TO N");
        findAllPrimeNumbersTillN(100);
    }
    private static void findAllPrimeNumbersTillN(final Integer N) {
        final Map<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 2; i <= N; i++) {
            hashMap.put(i,  true);
        }
        for (Map.Entry<Integer, Boolean> entry: hashMap.entrySet()) {
            Integer key = entry.getKey();
            if (hashMap.get(key)) {
                for (int mul = key * key; mul <= N; mul = mul + key) {
                    hashMap.put(mul, false);
                }
            }
        }
        for (Map.Entry<Integer, Boolean> entry: hashMap.entrySet()) {
            if (entry.getValue()) {
                System.out.print(entry.getKey() +" ");
            }
        }
    }
}

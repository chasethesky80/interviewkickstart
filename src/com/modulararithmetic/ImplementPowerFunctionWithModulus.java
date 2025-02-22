package com.modulararithmetic;

// Implement the power function with modulus:- a^n % p
public class ImplementPowerFunctionWithModulus {

    public static void main(String[] args) {
       System.out.println("CALCULATE POWER FUNCTION VALUE "+ power(10, 40, 7));
    }

    // HERE WE ARE TAKING MODULUS AT EVERY STEP INSIDE FOR LOOP SINCE IF a = 10 and n = 40 THEN 10^40 CAN BECOME
    // VERY BIG VALUE AND CAUSE OVERFLOW OUTSIDE THE INTEGER / LONG RANGE AND SO WE PERFORM MODULUS AT EACH ITERATION IN FOR LOOP WITH % p TO
    // PREVENT OVERFLOW SINCE WHEN WE DO : (answer % p * a % p) % p THIS VALUE WILL ALWAYS BE IN RANGE OF [0,p-1] AND HENCE WILL
    // NOT CAUSE OVERFLOW
    public static int power(int a, int n, int p) {
        int answer = 1;
        for (int i =0; i < n; i++) {
            answer = (answer % p * a % p) % p;
        }
        return answer;
    }
}

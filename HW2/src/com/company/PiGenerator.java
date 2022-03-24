package com.company;

import java.util.Arrays;

public class PiGenerator {
    public static void test() {
        System.out.println(powerMod(5, 7, 23));
        System.out.println(powerMod(1, 32, 17));
    }

    public static void base_test() {
        // 0.375 in decimal system is represented as 0.011 in binary.
        int[] test_array = {3, 7, 5};
        int[] converted = convertBase(
            test_array, 10, 2, 3
        );
        System.out.println(Arrays.toString(converted));
    }

    public static int powerMod(int a, int b, int m) {
        // If a < 0, b < 0, or m <= 0, return -1.
        if ((a<0) || (b<0) || (m<=0)) {
            return -1;
        }
        int result = 1;
        for (int k=0; k<b; k++) {
            result = (result * a) % m;
        }
        return result;
    }

    /**
     * Converts an array where the ith digit corresponds to (1 / baseA)^(i + 1)
     * digits[i], return an array output of size precisionB where the ith digit
     * corresponds to (1 / baseB)^(i + 1) * output[i].
     *
     * Stated in another way, digits is the fractional part of a number
     * expressed in baseA with the most significant digit first. The output is
     * the same number expressed in baseB with the most significant digit first.
     *
     * To implement, logically, you're repeatedly multiplying the number by
     * baseB and chopping off the most significant digit at each iteration:
     *
     * for (i < precisionB) {
     *   1. Keep a carry, initialize to 0.
     *   2. From RIGHT to LEFT
     *   	a. x = multiply the jth digit by baseB and add the carry
     *          b. the new jth digit is x % baseA
     *          c. carry = x / baseA
     *   3. output[i] = carry
     * }
     * If digits[j] < 0 or digits[j] >= baseA for any j, return null
     * If baseA < 2, baseB < 2, or precisionB < 1, return null
     *
     * @param digits The input array to translate. This array is not mutated.
     * @param baseA The base that the input array is expressed in.
     * @param baseB The base to translate into.
     * @param precisionB The number of digits of precision the output should
     *                   have.
     * @return An array of size precisionB expressing digits in baseB.
     * */
    public static int[] convertBase(
        int[] digits, int baseA, int baseB, int precisionB
    ) {
        if ((baseA<2) || (baseB<2) || (precisionB<1)) {
            return null;
        }
        int[] output = new int[precisionB];
        int[] input = digits.clone();

        // TODO: Implement (Problem c)
        for (int i=0; i<precisionB; i++) {
            int carry = 0;
            for (int j=0; j<digits.length; j++) {
                // get precisionB - jth index
                int index = digits.length - 1 - j;
                int new_digit = input[index] * baseB + carry;
                if ((input[index] < 0) || (input[index] >= baseA)) {
                    return null;
                }
                carry = Math.floorDiv(new_digit, baseA);
                input[index] = new_digit % baseA;
            }
            output[i] = carry;
        }

        return output;
    }
}

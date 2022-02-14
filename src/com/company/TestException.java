package com.company;

public class TestException {
    public static void test() {
        String[] in = {"hello", "good night", "good morning"};
        String ret = tstException(2, in);
        System.out.println(ret);
        ret = tstException(-1, in);
        System.out.println(ret);
    }

    public static String tstException(int idx, String[] y) {
        // to be implemented
        try {
            return y[idx];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Out of Bounds";
        }
    }
}
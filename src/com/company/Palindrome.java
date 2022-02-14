package com.company;

public class Palindrome {
    public static void test() {
        System.out.println("PALINDROME TEST");
        System.out.println(isPalindrome("abba".toCharArray()));
        System.out.println(isPalindrome("adbcba".toCharArray()));
        System.out.println(isPalindrome("ZZaZZ".toCharArray()));
        System.out.println(isPalindrome("123421".toCharArray()));

        String a = "testing testing 123";
        String b = a.substring(0, 0);
        String c = a.substring(1);
        System.out.println(b);
        System.out.println(c);
    }

    public static boolean isPalindrome (char[] S) {
        /*
        abba - true
        adbcba - false
        ZZaZZ - true
        123421 - false
         */
        if (S.length <= 1) {
            return true;
        } else if (S[0] != S[S.length-1]) {
            return false;
        }

        char[] subArray = new char[S.length - 2];
        //copy array into smaller version
        System.arraycopy(S, 1, subArray, 0, subArray.length);
        return isPalindrome(subArray);
    }
}

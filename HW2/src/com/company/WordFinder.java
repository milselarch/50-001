package com.company;

import java.util.HashMap;
import java.util.Map;

public class WordFinder {
    static void test() {
        String haystack = "BAndori";
        String[] needles = {"ri"};
        Map<String, Integer> mapping = getSubstrings(haystack, needles);
        System.out.println(mapping.toString());
    }
    /**
     * Given a String (the haystack) and an array of Strings (the needles),
     * return a Map<String, Integer>, where keys in the map correspond to
     * elements of needles that were found as substrings of haystack, and the
     * value for each key is the lowest index of haystack at which that needle
     * was found. A needle that was not found in the haystack should not be
     * returned in the output map.
     *
     * @param haystack The string to search into.
     * @param needles The array of strings to search for. This array is not
     *                mutated.
     * @return The list of needles that were found in the haystack.
     */
    public static Map<String, Integer> getSubstrings(
        String haystack, String[] needles
    ) {
        HashMap<String, Integer> mapping = new HashMap<String, Integer>();

        for (int k=0; k<haystack.length(); k++) {
            for (String needle: needles) {
                if (mapping.containsKey(needle)) {
                    continue;
                }
                boolean needle_matches = true;
                for (int i=0; i<needle.length(); i++) {
                    if (k+i >= haystack.length()) {
                        needle_matches = false;
                        break;
                    } else if (haystack.charAt(k+i) != needle.charAt(i)) {
                        needle_matches = false;
                        break;
                    }
                }
                if (needle_matches) {
                    mapping.put(needle, k);
                }
            }
        }
        return mapping;
    }
}

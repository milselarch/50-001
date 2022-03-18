package com.company;

import java.util.HashMap;

public class AlphabetGenerator {
    /**
     * Given a numeric base, return a char[] that maps every digit that is
     * representable in that base to a lower-case char.
     *
     * This method will try to weight each character of the alphabet
     * proportional to their occurrence in words in a training set.
     *
     * This method should do the following to generate an alphabet:
     *   1. Count the occurrence of each character a-z in trainingData.
     *   2. Compute the probability of each character a-z by taking
     *      (occurrence / total_num_characters).
     *   3. The output generated in step (2) is a PDF of the characters in the
     *      training set. Convert this PDF into a CDF for each character.
     *   4. Multiply the CDF value of each character by the base we are
     *      converting into.
     *   5. For each index 0 <= i < base,
     *      output[i] = (the first character whose CDF * base is > i)
     *
     * A concrete example:
     * 	 0. Input = {"aaaaa..." (302 "a"s), "bbbbb..." (500 "b"s),
     *               "ccccc..." (198 "c"s)}, base = 93
     *   1. Count(a) = 302, Count(b) = 500, Count(c) = 198
     *   2. Pr(a) = 302 / 1000 = .302, Pr(b) = 500 / 1000 = .5,
     *      Pr(c) = 198 / 1000 = .198
     *   3. CDF(a) = .302, CDF(b) = .802, CDF(c) = 1
     *   4. CDF(a) * base = 28.086, CDF(b) * base = 74.586, CDF(c) * base = 93
     *   5. Output = {"a", "a", ... (29 As, indexes 0-28),
     *                "b", "b", ... (46 Bs, indexes 29-74),
     *                "c", "c", ... (18 Cs, indexes 75-92)}
     *
     * The letters should occur in lexicographically ascending order in the
     * returned array.
     *   - {"a", "b", "c", "c", "d"} is a valid output.
     *   - {"b", "c", "c", "d", "a"} is not.
     *
     * If base >= 0, the returned array should have length equal to the size of
     * the base.
     *
     * If base < 0, return null.
     *
     * If a String of trainingData has any characters outside the range a-z,
     * ignore those characters and continue.
     *
     * @param base A numeric base to get an alphabet for.
     * @param trainingData The training data from which to generate frequency
     *                     counts. This array is not mutated.
     * @return A char[] that maps every digit of the base to a char that the
     *         digit should be translated into.
     */
    public static void test() {
        int base;
        char[] frequency;

        base = 13;
        String[] trainingData = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z"
        };
        frequency = generateFrequencyAlphabet(base, trainingData);
        System.out.println(frequency);

        base = 10;
        String[] trainingData2 = {"a", "a", "a", "b", "c", "d", "e", "ffffff"};
        frequency = generateFrequencyAlphabet(base, trainingData2);
        System.out.println(frequency);
    }

    public static char[] generateFrequencyAlphabet(
        int base, String[] trainingData
    ) {
        if (base < 0) { return null; }
        final char[] BASIC_ALPHABET = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
        };

        final String ALPHABET = new String(BASIC_ALPHABET);
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char character: BASIC_ALPHABET) {
            counts.put(character, 0);
        }

        int total = 0;
        for (String word : trainingData) {
            for (int k=0; k<word.length(); k++) {
                char character = word.charAt(k);
                if (ALPHABET.indexOf(character) == -1) {
                    continue;
                }
                int count = counts.get(character);
                counts.put(character, count + 1);
                total++;
            }
        }

        Integer cummulative_count = 0;
        HashMap<Character, Double> scaled_cdfs = new HashMap<>();
        for (char character : BASIC_ALPHABET) {
            cummulative_count += counts.get(character);
            double scaled_cdf = base * cummulative_count / (double) total;
            scaled_cdfs.put(character, scaled_cdf);
        }

        // System.out.println(scaled_cdfs.toString());
        char[] output = new char[base];
        for (int k=0; k<output.length; k++) {
            char character = BASIC_ALPHABET[0];
            for (char c : BASIC_ALPHABET) {
                character = c;
                double scaled_cdf = scaled_cdfs.get(character);
                if (scaled_cdf > k) {
                    break;
                }
            }

            output[k] = character;
        }

        return output;
    }
}

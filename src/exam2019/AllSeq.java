package exam2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllSeq {
    public static void main(String[] args) {
        String[] s = {"p", "q"};
        System.out.println(compAllSeq(s, 3));
        String[] s2 = {"1", "2", "3", "4"};
        System.out.println(compAllSeq(s2, 1));
    }
    public static ArrayList<String> compAllSeq(String[] s, int k){
        //TODO: implement a recursive method to return all possible sequences of length k
        ArrayList<String> sequences = new ArrayList<>();

        if (k == 1) {
            Collections.addAll(sequences, s);
            return sequences;
        }

        ArrayList<String> subsequences = compAllSeq(s, k-1);
        for (String subsequence: subsequences) {
            for (String item: s) {
                sequences.add( item + subsequence);
            }
        }

        return sequences;
    }
}
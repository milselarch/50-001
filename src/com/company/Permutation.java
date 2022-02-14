package com.company;

import java.util.ArrayList;

public class Permutation {
    private final String in;
    private ArrayList<String> a;
    // additional attribute if needed

    Permutation(final String str){
        this.in = str;
        this.a = new ArrayList<String>();
        // additional initialization if needed
    }

    public static void test() {
        ArrayList<String> v;
        Permutation p = new Permutation("john");
        p.permute();
        v = p.getA();
        System.out.println(v);

        Permutation p1 = new Permutation("ad");
        p1.permute();
        v = p1.getA();
        System.out.println(v);
    }

    public void permute () {
        // produce the permuted sequences of 'in' and store in 'a', recursively
        if (this.in.length() <= 1) {
            this.a.add(this.in);
            return;
        }

        for (int k=0; k<this.in.length(); k++) {
            // String sub_string = this.in;
            String sub_string1 = this.in.substring(0, k);
            String sub_string2 = this.in.substring(k + 1);
            String current_char = this.in.substring(k, k+1);
            String sub_string = sub_string1 + sub_string2;

            Permutation p = new Permutation(sub_string);
            p.permute();

            for (int i=0; i<p.a.size(); i++) {
                String subp = current_char + p.a.get(i);
                this.a.add(subp);
            }
        }
    }

    public ArrayList<String> getA(){
        return a;
    }
}
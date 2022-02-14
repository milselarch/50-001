package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OctagonComparator implements Comparator<Octagon> {
    @Override
    public int compare(Octagon octagon1, Octagon octagon2) {
        if (octagon1.getSide() > octagon2.getSide()) {
            return 1;
        } else if (octagon1.getSide() == octagon2.getSide()) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void test() {
        ArrayList<Octagon> l = new ArrayList<Octagon>();
        l.add(new Octagon(2));
        l.add(new Octagon(3));
        l.add(new Octagon(1));
        Collections.sort(l, new OctagonComparator());
        for (Octagon o:l) {
            System.out.println(o.getSide());
        }
    }
}

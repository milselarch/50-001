package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Octagon implements Comparable<Octagon> {
    private double side;
    public Octagon(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }

    @Override
    public int compareTo(Octagon octagon) {
        /*
        https://www.javatpoint.com/Comparable-interface-in-collection-framework
        public int compareTo(Object obj): It is used to compare the current object with the specified object. It returns
        positive integer, if the current object is greater than the specified object.
        negative integer, if the current object is less than the specified object.
        zero, if the current object is equal to the specified object.

        Alternatively:
        return Double.compare(this.getSide(), octagon.getSide());
         */
        if (this.getSide() > octagon.getSide()) {
            return 1;
        } else if (this.getSide() == octagon.getSide()) {
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
        Collections.sort(l);
        for (Octagon o:l)
            System.out.println(o.getSide());
    }
}
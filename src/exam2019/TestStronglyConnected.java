package exam2019;

import java.util.ArrayList;
import java.util.Arrays;

public class TestStronglyConnected	{
    public static void main	(String[]	args){
        int nodecount=4;
        int linkcount=3;
        ArrayList<Integer> listOfLink = new ArrayList<Integer> (Arrays.asList(0,1, 1,2,	2,3));
        System.out.println(StronglyConnected.isStronglyConnected(nodecount,	linkcount,	listOfLink));
    }
}
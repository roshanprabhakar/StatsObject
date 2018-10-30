package com.roshanp.compsci;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        StatsObject4 statsObject = new StatsObject4("", 5);
//        //System.out.println(statsObject.topMostFrequent());
//        System.out.println(statsObject.frequencyOf('t'));
//        System.out.println(statsObject.size());
//        System.out.println(statsObject.getUniqueCharCount());
//        System.out.println(statsObject.getMostFrequent());
//        System.out.println(Arrays.toString(statsObject.getTopMostFrequent()));
//        //System.out.println(statsObject.reconstruct());
    }
    //DEBUGGING
    public static void print(ArrayList<Entry> entries) {
        System.out.print("<");
        for (int i = 0; i < entries.size(); i++) {
            System.out.print(entries.get(i).getPrintStatement() + ", ");
        }
        System.out.println(">");
    }
}
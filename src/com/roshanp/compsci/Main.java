package com.roshanp.compsci;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HashMapStatsObject statsObject = new HashMapStatsObject("this is a testaaaaaa", 3);
        print(statsObject.getTopMostFrequent());
        print(statsObject.getMostFrequent());
        print(statsObject.getUniqueCount());
        print(statsObject.size());
        print(statsObject.reconstruct());
    }

    //HELPER
    public static void print(Object object) {
        System.out.println(object);
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
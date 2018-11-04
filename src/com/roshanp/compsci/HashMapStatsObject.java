package com.roshanp.compsci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapStatsObject {
    private Map<Character, ArrayList<Integer>> statsObject = new LinkedHashMap<>();
    private Character mostFrequent;
    private int size = 0;
    private int topN;

    public HashMapStatsObject(String str, int topN) {
        char[] strToChar = str.toCharArray();
        for (int i = 0; i < strToChar.length; i++) {
            this.add(strToChar[i]);
        }
        this.topN = topN;
    }

    public void add(Character chr) {
        size++;
        if (size == 1) {
            mostFrequent = chr;
        }
        if (!statsObject.containsKey(chr)) {
            statsObject.put(chr, new ArrayList<>());
        }
        statsObject.get(chr).add(size - 1);
    }

    //Get topN most frequent
    public ArrayList<Character> getTopMostFrequent() {
        Map<Character, ArrayList<Integer>> copy = new HashMap<>(statsObject);
        ArrayList<Character> topMostFrequent = new ArrayList<>();
        Character mostFrequent;

        //constant because topN is a constant;
        for (int i = 0; i < topN; i++) {
            mostFrequent = getMostFrequentForList(copy);
            copy.remove(mostFrequent);
            topMostFrequent.add(mostFrequent);
        }
        return topMostFrequent;
    }

    private Character getMostFrequentForList(Map<Character, ArrayList<Integer>> copy) {
        Character mostFrequentInList = (Character) copy.keySet().toArray()[0];
        //constant because loops size number of times; size is a constant
        for (Character key : copy.keySet()) {
            if (copy.get(key).size() > copy.get(mostFrequentInList).size()) {
                mostFrequentInList = key;
            }
        }
        return mostFrequentInList;
    }

    public Character getMostFrequent() {
        return this.mostFrequent;
    }

    public int size() {
        return this.size;
    }

    public int getCountOf(char chr) {
        return statsObject.get(chr).size();
    }

    public int getUniqueCount() {
        return statsObject.size();
    }

    public Character getRandom() {
        String object = this.reconstruct();
        int index = (int) (Math.random()*object.length());
        return object.charAt(index);
    }

    //HELPER
    public String reconstruct() {
        char[] reconstructed = new char[this.getSumOfHashMapValues()];
        for (char key : statsObject.keySet()) {
            for (int i = 0; i < statsObject.get(key).size(); i++) {
                reconstructed[statsObject.get(key).get(i)] = key;
            }
        }
        return new String(reconstructed);
    }

    private int getSumOfHashMapValues() {
        int length = 0;
        for (Character key : statsObject.keySet()) {
            length += statsObject.get(key).size();
        }
        return length;
    }

}
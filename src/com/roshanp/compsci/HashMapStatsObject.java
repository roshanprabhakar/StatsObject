package com.roshanp.compsci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapStatsObject {
    private Map<Character, ArrayList<Integer>> statsObject = new HashMap<>();
    private ArrayList<Character> mostFrequentAsList = new ArrayList<>();
    private Character mostFrequent;
    private int size = 0;
    private int topN;

    public HashMapStatsObject(String str, int topN) {
        this.topN = topN;
        char[] strToChar = str.toCharArray();
        for (int i = 0; i < strToChar.length; i++) {
            this.add(strToChar[i]);
        }
    }

    public void add(Character chr) {
        size++;
        if (size == 1) {
            mostFrequent = chr;
            mostFrequentAsList.add(chr);
        }
        if (!statsObject.containsKey(chr)) {
            statsObject.put(chr, new ArrayList<>());
        }
        statsObject.get(chr).add(size - 1);

        if (statsObject.get(chr).size() > statsObject.get(mostFrequent).size()) {
            mostFrequent = chr;
        }

        updateMostFrequentAsList(chr);
    }

    private void updateMostFrequentAsList(Character chr) {
        if (mostFrequentAsList.contains(chr)) {
            mostFrequentAsList.remove(chr);
        }

        int indexToInsert = getInsertionIndex(chr);
        mostFrequentAsList.add(indexToInsert, chr);

        if (mostFrequentAsList.size() > topN) {
            mostFrequentAsList.remove(mostFrequentAsList.size() - 1);
        }
    }

    private int getInsertionIndex(Character chr) {
        for (int i = 0; i < mostFrequentAsList.size() - 1; i++) {
            if (getCountOf(chr) > getCountOf(mostFrequentAsList.get(i))) {
                return i;
            }
        }
        return mostFrequentAsList.size();
    }

    public ArrayList<Character> getTopMostFrequent() {
        return this.mostFrequentAsList;
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
        int index = (int) (Math.random() * object.length());
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
package com.roshanp.compsci;

import java.util.*;

public class FinalStatsObject {

    public Map<Character, Integer> statsObject = new HashMap<>();
    public Map<Character, ArrayList<Integer>> indexes = new HashMap<>();
    private Character mostFrequent;
    private String inputString = "";
    private boolean initializedAsString;
    private int size = 0;
    int topN;

    public FinalStatsObject(String string, int topN) {
        this.inputString = string;
        this.initializedAsString = true;
        char[] asCharArray = string.toCharArray();
        for (int i = 0; i < asCharArray.length; i++) {
            this.add(asCharArray[i]);
        }
        this.topN = topN;
    }

    public FinalStatsObject(FinalStatsObject other) { //creates duplicate
        for (int i = 0; i < other.inputString.length(); i++) {
            this.add(other.inputString.charAt(i));
        }
    }

    public FinalStatsObject(int topN) {
        this.topN = topN;
        this.initializedAsString = false;
    }

    public void add(char chr) {
        size++;
        if (!this.initializedAsString) {
            inputString += Character.toString(chr);
        }
        if (size == 1) {
            this.mostFrequent = chr;
        }
        if (statsObject.containsKey(chr)) {
            statsObject.replace(chr, statsObject.get(chr) + 1);
        } else {
            statsObject.put(chr, 1);
            indexes.put(chr, new ArrayList<>());
        }
        indexes.get(chr).add(size - 1);
        if (statsObject.get(chr) > statsObject.get(mostFrequent)) {
            mostFrequent = chr;
        }
    }

    public ArrayList<Character> topMostFrequent() {
        FinalStatsObject copy = new FinalStatsObject(this);
        ArrayList<Character> output = new ArrayList<>();
        for (int i = 0; i < topN; i++) {
            output.add(copy.getMostFrequent());
            copy = copy.remove(copy.getMostFrequent());
        }
        return output;
    }

    public int frequencyOf(char chr) {
        return statsObject.get(chr);
    }

    public Character getMostFrequent() {
        return this.mostFrequent;
    }

    public int getUniqueCharCount() {
        return statsObject.size();
    }

    public int size() {
        return this.size;
    }

    public FinalStatsObject remove(char chr) {
        String newInputString = "";
        char[] inputStringToArray = inputString.toCharArray();
        for (int i = 0; i < inputStringToArray.length; i++) {
            if (inputStringToArray[i] != chr) {
                newInputString += inputStringToArray[i];
            }
        }
        FinalStatsObject newStatsObject = new FinalStatsObject(newInputString, topN);
        return newStatsObject;
    }

    public String getInputString() {
        return this.inputString;
    }

    public String reconstruct() {
        char[] reconstructed = new char[this.getSumOfHashMapValues()];
        for (char key : indexes.keySet()) {
            for (int i = 0; i < indexes.get(key).size(); i++) {
                reconstructed[indexes.get(key).get(i)] = key;
            }
        }
        return new String(reconstructed);
    }

    private int getSumOfHashMapValues() {
        int length = 0;
        for (Character key : indexes.keySet()) {
            length += indexes.get(key).size();
        }
        return length;
    }

    public void print(Object object) {
        System.out.println(object);
    }
}

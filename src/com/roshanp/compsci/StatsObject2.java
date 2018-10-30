package com.roshanp.compsci;

import java.util.HashMap;
import java.util.Map;

/**
 * This implementaion uses Hashmap,which does not preserve order
 * Therefore this will not be replaceable in place of the StatsObject used in my
 * submission of Ciphers.java
 *
 * This still needs get N most frequent
 */
public class StatsObject2 {
    private HashMap<Character, Integer> StatsObject = new HashMap<>();
    private char mostFrequent;
    private int topN;

    public StatsObject2(int n) {this.topN = n;}

    //O(1)
    public void add(char character, int n) {
        if (StatsObject.size() == 0) {
            StatsObject.put(character, n);
            mostFrequent = character;
            return;
        }
        if (StatsObject.get(character) == null) {
            StatsObject.put(character, n);
        } else {
            StatsObject.replace(character, StatsObject.get(character) + n);
        }
        if (StatsObject.get(character) > StatsObject.get(mostFrequent)) {
            mostFrequent = character;
        }
    }

    //O(n)
    public void addAllLetters(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            add(charArray[i], 1);
        }
    }

    //O(1)
    public char getMostFrequent() {
        return mostFrequent;
    }

    //O(1)
    public int getCountOf(char chr) {
        if (StatsObject.get(chr) == null) {
            return 0;
        }
        return StatsObject.get(chr);
    }

    //O(1)
    public int size() {
        return StatsObject.size();
    }

    //O(1)
    public int getNumUnique() {
        return StatsObject.size();
    }

    public Map<Character, Integer> getMap() {
        return this.StatsObject;
    }

    public void setMap(HashMap<Character, Integer> map) {
        StatsObject = map;
    }

    private Map<Character, Integer> setEqualTo(StatsObject2 other) {
        return other.getMap();
    }

    private void remove(char chr) {
        StatsObject.remove(chr);
    }

    public void print() {
        System.out.println(StatsObject);
    }
}

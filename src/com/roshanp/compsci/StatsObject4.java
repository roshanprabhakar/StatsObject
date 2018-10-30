package com.roshanp.compsci;

import java.util.ArrayList;

public class StatsObject4 {
    private int[] frequencies = new int[128];
    private ArrayList<Character> statsObject = new ArrayList<>();
    int topN;

    public StatsObject4(int topN) {
        this.topN = topN;
    }
    public StatsObject4(String str, int topN) {
        char[] toChar = str.toCharArray();
        for (int i = 0; i < toChar.length; i++) {
            add(toChar[i]);
        }
        this.topN = topN;
    }

    public void add(char chr) {
        frequencies[(int) (chr)]++;
        statsObject.add(chr);
    }

    public void addAllLetters(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            add(charArray[i]);
        }
    }

    public int frequencyOf(char chr) {
        return frequencies[(int) (chr)];
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] != 0) {
                size += frequencies[i];
            }
        }
        return size;
    }

    public int getUniqueCharCount() {
        int unique = 0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] != 0) {
                unique++;
            }
        }
        return unique;
    }

    public char getMostFrequent() {
        int mostFrequent = 1; //replaceable
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > frequencies[mostFrequent]) {
                mostFrequent = i;
            }
        }
        return (char) mostFrequent;
    }

    public char[] getTopMostFrequent() {
        char[] topNMostFrequnt = new char[topN];
        int[] frequenciesCopy = frequencies.clone();
        for (int i = 0; i < topN; i++) {
            int mostFrequent = 0;
            for (int j = 0; j < frequenciesCopy.length; j++) {
                if (frequenciesCopy[j] > frequenciesCopy[mostFrequent]) {
                    mostFrequent = j;
                }
            }
            topNMostFrequnt[i] = (char) mostFrequent;
            frequenciesCopy[mostFrequent] = 0;
        }
        return topNMostFrequnt;
    }

    private static void swapIndexes(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void remove(char chr) {
        frequencies[(int) (chr)] = 0;
    }
}

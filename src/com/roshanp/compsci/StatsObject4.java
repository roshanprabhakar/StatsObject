package com.roshanp.compsci;

import java.util.ArrayList;

public class StatsObject4 {
    private int[] frequencies = new int[128];
    int topN;

    public int[] getFrequencies() {
        return this.frequencies;
    }

    public StatsObject4(int topN) {
        this.topN = topN;
    }

    public void add(char chr) {
        frequencies[(int) (chr)]++;
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
                size++;
            }
        }
        return size;
    }

    public int getNumUnique() {
        int unique = 0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] != 0) {
                unique++;
            }
        }
        return unique;
    }

    public char getMostFrequent() {
        char mostFrequent = 'b'; //replaceable
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > frequencies[(int) (mostFrequent)]) {
                mostFrequent = (char) (i);
            }
        }
        return mostFrequent;
    }

    public ArrayList<Character> getTopMostFrequent() {
        StatsObject4 copy = new StatsObject4(0);
        copy.frequencies = this.frequencies;

        ArrayList<Character> output = new ArrayList<>();

        for (int i = 0; i < topN; i++) {
            output.add(copy.getMostFrequent());
            copy.remove(copy.getMostFrequent());
        }
        return output;
    }

    public static void sort(int[] arr) {
        int countSwitch = 1;
        while (countSwitch > 0) {
            countSwitch = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swapIndexes(arr, i, i + 1);
                    countSwitch++;
                }
            }
        }
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

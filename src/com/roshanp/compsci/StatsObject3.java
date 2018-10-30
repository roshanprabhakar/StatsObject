package com.roshanp.compsci;

import java.util.ArrayList;

public class StatsObject3 {
    private int topN;
    private ArrayList<Entry> entries = new ArrayList<>();

    public StatsObject3(int topN) {
        this.topN = topN;
    }

    public void add(Entry entry) {
        if (this.contains(entry.getIdentity())) {
            entries.get(this.findIndexOfIdentity(entry)).setFrequency(entries.get(this.findIndexOfIdentity(entry)).getFrequency() + entry.getFrequency());
        } else {
            entries.add(entry);
        }
        sort();
    }

    public void addAllLetters(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            this.add(new Entry(charArray[i], 1));
        }
    }

    public int getFrequencyOf(char chr) {
        return entries.get(findIndexOfIdentity(new Entry(chr, 0))).getFrequency();
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < entries.size(); i++) {
            size += entries.get(i).getFrequency();
        }
        return size;
    }

    public int getNumUnique() {
        return entries.size();
    }

    public Entry getMostFrequent() {
        return entries.get(entries.size() - 1);
    }

    public ArrayList<Entry> getTopMostFrequent() {
        if (entries.size() <= topN) {
            return entries;
        }
        ArrayList<Entry> mostFrequent = new ArrayList<>();
        for (int i = 0; i < topN; i++) {
            mostFrequent.add(entries.get(entries.size() - 1 - i));
        }
        return mostFrequent;
    }

    private int findIndexOfIdentity(Entry entry) {
        for (int i = 0; i < entries.size(); i++) {
            if (entry.getIdentity() == entries.get(i).getIdentity()) {
                return i;
            }
        }
        return -1;
    }

    private void sort() {

        int countSwitch = 1;
        while (countSwitch > 0) {
            countSwitch = 0;
            for (int i = 0; i < entries.size() - 1; i++) {
                if (entries.get(i).getFrequency() > entries.get(i + 1).getFrequency()) {
                    swap(entries, i, i + 1);
                    countSwitch++;
                }
            }
        }

    }

    private void swap(ArrayList<Entry> entries, int i, int j) {
        char tempChar = entries.get(i).getIdentity();
        int tempInt = entries.get(i).getFrequency();

        entries.get(i).setIdentity(entries.get(j).getIdentity());
        entries.get(i).setFrequency(entries.get(j).getFrequency());

        entries.get(j).setIdentity(tempChar);
        entries.get(j).setFrequency(tempInt);
    }

    private boolean contains(char identity) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getIdentity() == identity) {
                return true;
            }
        }
        return false;
    }
}

package com.dev.dsa.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    static class Pair {
        int key;
        String value;

        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static List<Pair> quickSort(List<Pair> pairs) {

        return sort(pairs, 0, pairs.size() - 1);
    }

    public static List<Pair> sort(List<Pair> pairs, int start, int end) {
        if (end - start + 1 <= 1) {
            return pairs;
        }

        int left = start;
        Pair pivot = pairs.get(end);

        for (int i = left; i < end; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair temp = pairs.get(i);
                pairs.remove(i);
                pairs.add(i, pairs.get(left));
                pairs.remove(left);
                pairs.add(left, temp);
                left += 1;
            }
        }

        sort(pairs, start, left - 1);
        sort(pairs, left + 1, end);
        pairs.remove(pivot);
        pairs.add(left, pivot);

        return pairs;
    }

    public static void main(String[] args) {
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(3, "apple"));
        pairs.add(new Pair(2, "banana"));
        pairs.add(new Pair(3, "Papaya"));
        printPairsList(pairs);
        System.out.println();
        printPairsList(quickSort(pairs));
    }

    public static void printPairsList(List<Pair> pairs) {
        pairs.forEach(pair -> {
            System.out.print(pair.key + " " + pair.value + ";");
        });
    }
}

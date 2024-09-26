// Complexity: O(n^2)

package com.dev.dsa.sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(5, "apple"));
        pairs.add(new Pair(2, "banana"));
        pairs.add(new Pair(9, "Papaya"));
//        printPairsList(pairs);
        List<List<Pair>> res = insertionSort(pairs);
        res.forEach(list -> {
            printPairsList(list);
            System.out.println();
        });
    }

    public static void printPairsList(List<Pair> pairs) {
        pairs.forEach(pair -> {
            System.out.print(pair.key + " " + pair.value + ";");
        });
    }

    public static class Pair {
        int key;
        String value;

        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> result = new ArrayList();
        for (int i = 1; i < pairs.size(); i++) {
            int j = i;
            result.add(new ArrayList<>(pairs));
            while (j > 0 && pairs.get(j).key < pairs.get(j - 1).key) {
                swap(pairs, j, j - 1);
                j -= 1;
            }
        }
        result.add(new ArrayList<>(pairs));
        return result;
    }

    public static void swap(List<Pair> pairs, int i, int j) {
        Pair temp = pairs.get(i);
        pairs.remove(i);
        pairs.add(i, pairs.get(j));
        pairs.remove(j);
        pairs.add(j, temp);
    }
}


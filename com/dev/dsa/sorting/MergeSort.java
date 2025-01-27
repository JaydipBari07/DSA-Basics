package com.dev.dsa.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {

        List<MergeSort.Pair> pairs = new ArrayList<>();
        pairs.add(new MergeSort.Pair(2, "Apple"));
        pairs.add(new MergeSort.Pair(4, "banana"));
        pairs.add(new MergeSort.Pair(2, "Grapes"));
        pairs.add(new MergeSort.Pair(1, "Orange"));
        pairs.add(new MergeSort.Pair(6, "Papaya"));
        List<Pair> res = mergeSort(pairs, 0, pairs.size()-1);
        printPairsList(res);
    }

    public static List<Pair> mergeSort(List<Pair> list, int start, int end) {
        if ((end - start + 1) <= 1) {
            return list;
        }
        int mid = start + (end - start) / 2;
        mergeSort(list, start, mid);
        mergeSort(list, mid + 1, end);

        // merge here
        merge(list, start, mid, end);

        return list;
    }

    public static void merge(List<Pair> list, int start, int mid, int end) {
        int i = start, j = mid + 1;
//        System.out.println(i + ":" + j);
        while (i <= mid && j < end) {
            if (list.get(i).key > list.get(j).key) {
                insertElement(list, i, j);
            }
            i += 1;
        }

//        printPairsList(list);
//        System.out.println();
    }

    public static void insertElement(List<Pair> list, int a, int b) {
        Pair temp = list.get(b);
        list.remove(b);
        list.add(a, temp);
    }

    public static class Pair {
        int key;
        String value;

        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void printPairsList(List<MergeSort.Pair> pairs) {
        pairs.forEach(pair -> {
            System.out.print(pair.key + " " + pair.value + ";");
        });
    }
}

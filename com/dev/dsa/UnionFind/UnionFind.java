package com.dev.dsa.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    Map<Integer, Integer> parentMap = new HashMap<>();

    public UnionFind(Integer n) {
        for (int i = 0; i < n; i++) {
            parentMap.put(i, i);
        }
    }

    public int find(int i) {
        while (parentMap.get(i) != i) {
            i = parentMap.get(i);
        }
        return i;
    }

    public boolean union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi == pj) {
            return false;
        }
        parentMap.put(pi, pj);
        return true;
    }


}

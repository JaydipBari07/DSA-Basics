package com.dev.dsa.BinaryTree.BFS;

import java.util.*;


/**
 * They asked me this in google mock interview.
 * I solved with this approach at the end but few modifications were pending and 45 min time was up.
 */
public class DeleteNodesAndReturnForest {

    public List<List<Integer>> returnForest(List<Integer> tree, List<Integer> toDelete) {
        for (Integer node : toDelete) {
            tree.set(tree.indexOf(node), null);
        }
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> subList = new ArrayList<>();
        int cur = 0, size = tree.size();
        visited.add(0);
        subList.add(tree.get(0));
        while (cur < tree.size()) {
            if (tree.get(cur) == null) {
                cur += 1;
                continue;
            }
            if (visited.contains(cur)) {
                if (cur * 2 + 1 < size) {
                    subList.add(tree.get(cur * 2 + 1));
                    visited.add(cur * 2 + 1);
                }
                if (cur * 2 + 2 < size) {
                    subList.add(tree.get(cur * 2 + 2));
                    visited.add(cur * 2 + 2);
                }
            } else {
                result.add(subList);
                subList = new ArrayList<>();
                subList.add(tree.get(cur));
                visited.add(cur);
                if (cur * 2 + 1 < size) {
                    subList.add(tree.get(cur * 2 + 1));
                    visited.add(cur * 2 + 1);
                }
                if (cur * 2 + 2 < size) {
                    subList.add(tree.get(cur * 2 + 2));
                    visited.add(cur * 2 + 2);
                }
            }
            cur += 1;
        }
        result.add(subList);
        return result;
    }

    public static void main(String[] args) {
//        Integer[] tree = new Integer[]{1, 2, 3};
//        Integer[] toDelete = new Integer[]{1};
//        Integer[] tree = new Integer[]{1, 2, 3, 4, 5, 6, 7};
//        Integer[] toDelete = new Integer[]{3, 5};
        Integer[] tree = new Integer[]{1, 2, 3, 4};
        Integer[] toDelete = new Integer[]{4};
        System.out.println(new DeleteNodesAndReturnForest().returnForest(Arrays.asList(tree), Arrays.asList(toDelete)));
    }
}

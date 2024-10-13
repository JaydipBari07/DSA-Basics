package com.dev.dsa.graphs.adjencencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    HashMap<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        return deepCopyIt(node);
    }

    public Node deepCopyIt(Node node) {
        if (node == null) {
            return null;
        }
        Node copy = new Node();
        copy.val = node.val;
        if (node.neighbors != null && !node.neighbors.isEmpty()) {
            if (!visited.containsKey(node.val)) {
                visited.put(copy.val, copy);
                for (Node i : node.neighbors) {
                    if (!visited.containsKey(i.val)) {
                        copy.neighbors.add(deepCopyIt(i));
                    } else {
                        copy.neighbors.add(visited.get(i.val));
                    }
                }
            }
        }
        return copy;
    }

    public static void printIt(Node node, List<Integer> visited) {
        System.out.print(node.val + ": ");
        visited.add(node.val);
        for (Node i : node.neighbors) {
            System.out.print(i.val + ", ");
        }
        System.out.println();
        for (Node i : node.neighbors) {
            if (!visited.contains(i.val)) {
                visited.add(i.val);
                printIt(i, visited);
            }
        }
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        System.out.println("Original: ");
        printIt(node1, new ArrayList<>());
        System.out.println("Copy: ");
        printIt(new CloneGraph().cloneGraph(node1), new ArrayList<>());
    }
}

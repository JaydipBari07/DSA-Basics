package com.dev.dsa.graphs.adjencencyList;

import java.sql.Array;
import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses > 0 && (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0)) {
            return true;
        }
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] i : prerequisites) {
            if (adjList.containsKey(i[0])) {
                adjList.get(i[0]).add(i[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i[1]);
                adjList.put(i[0], list);
            }
        }
        List<Integer> queue = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        List<Integer> vis = new ArrayList<>();
        for (int[] i : prerequisites) {
            if(visited.contains(i[0]))
                continue;
            visited = new ArrayList<>();
            visited.add(i[0]);
            queue.addAll(adjList.get(i[0]));
            while (!queue.isEmpty()) {
                int len = queue.size();
                System.out.println("Queue: " + queue);
                System.out.println("Visited: " + visited);
                for (int k = 0; k < len; k++) {
                    int course = queue.remove(0);
                    vis.add(course);
                    if (adjList.containsKey(course)) {
                        for (int j : adjList.get(course)) {
                            if (visited.contains(j)) {
                                System.out.println(j);
                                return false;
                            } else {
                                if (!queue.contains(j))
                                    queue.add(j);
                            }
                        }
                    }
                }
                visited.addAll(vis);
                vis = new ArrayList<>();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,4},{2,4},{3,1},{3,2}};
        int capacity = 6;
        System.out.println(new CourseSchedule().canFinish(capacity, prerequisites));
    }
}

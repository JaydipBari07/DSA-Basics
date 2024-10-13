package com.dev.dsa.graphs.adjencencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseScheduleDfsStyle {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] i : prerequisites) {
            if (map.containsKey(i[0])) {
                map.get(i[0]).add(i[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i[1]);
                map.put(i[0], list);
            }
        }
        List<Integer> visited = new ArrayList<>();
        for (int course : map.keySet()) {
            if (!checkCanFinish(map, visited, course)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkCanFinish(HashMap<Integer, List<Integer>> map, List<Integer> visited, int course) {
        if (!map.containsKey(course) || map.get(course).isEmpty()) {
            return true;
        }
        if (visited.contains(course)) {
            return false;
        }
        visited.add(course);
        for (int preCourse : map.get(course)) {
            if (!checkCanFinish(map, visited, preCourse)) {
                return false;
            }
        }
        map.put(course, new ArrayList<>());
        visited.remove(new Integer(course));
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        int capacity = 6;
        System.out.println(new CourseScheduleDfsStyle().canFinish(capacity, prerequisites));
    }
}

package com.dev.dsa.hashing;

import java.util.ArrayList;
import java.util.List;

public class LRUCache {

    Integer[] keys;
    Integer[] values;
    List<Integer> lru;
    int capacity;
    int cur;

    public LRUCache(int capacity) {
        keys = new Integer[capacity];
        values = new Integer[capacity];
        lru = new ArrayList<>();
        this.capacity = capacity;
        cur = 0;
    }

    public int get(int key) {
        for (int i = 0; i < cur; i++) {
            if (key == keys[i]) {
                lru.remove(new Integer(key));
                lru.add(key);
                System.out.println("Get " + key + ": " + lru);
                return values[i];
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        for (int i = 0; i < cur; i++) {
            if (keys[i] == key) {
                values[i] = value;
                lru.remove(new Integer(key));
                lru.add(key);
                System.out.println("Put " + key + ": " + lru);
                return;
            }
        }
        if (cur >= capacity) {
            int lruKey = lru.get(0);
            for (int i = 0; i < cur; i++) {
                if (keys[i] == lruKey) {
                    values[i] = value;
                    lru.remove(new Integer(lruKey));
                    lru.add(lruKey);
                    System.out.println("Put " + key + ": " + lru);
                    return;
                }
            }
        } else {
            keys[cur] = key;
            values[cur] = value;
            lru.add(key);
            cur += 1;
            System.out.println("Put " + key + ": " + lru);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
//        System.out.println(cache.get(2));
        cache.put(1, 10);
        System.out.println(cache.get(1));
        cache.put(2, 20);
        cache.put(3, 30);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
    }
}

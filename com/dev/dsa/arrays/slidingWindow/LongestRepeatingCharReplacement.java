package com.dev.dsa.arrays.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacement {

    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, len = s.length(), maxLen = 0, curLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right <= len) {
            if (map.size() > 2) {
                while (left <= right && map.size() > 2) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    if (map.get(s.charAt(left)) == 0) {
                        map.remove(s.charAt(left));
                    }
                    curLen--;
                    left++;
                }
            } else {
                if (!map.isEmpty() && (map.get(s.charAt(left)) <= k || curLen - map.get(s.charAt(left)) <= k)) {
                    maxLen = Math.max(maxLen, curLen);
                } else if (!map.isEmpty()) {
                    while (map.get(s.charAt(left)) > k) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                        if (map.get(s.charAt(left)) == 0) {
                            map.remove(s.charAt(left));
                        }
                        curLen--;
                        left++;
                    }
                }
            }
            if (right == len) {
                break;
            }
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            curLen++;
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABA";
        String s1 = "AABABBA";
        String s2 = "AABCABBAB";
        System.out.println(new LongestRepeatingCharReplacement().characterReplacement(s, 1));
        System.out.println(new LongestRepeatingCharReplacement().characterReplacement(s1, 1));
        System.out.println(new LongestRepeatingCharReplacement().characterReplacement(s2, 1));
    }
}

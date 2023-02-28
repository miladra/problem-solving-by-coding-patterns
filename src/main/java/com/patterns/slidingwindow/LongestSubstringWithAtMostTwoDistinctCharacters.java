package com.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, maxLen = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > 2) {
                char left = s.charAt(start);
                int count = map.get(left);
                if (count == 1) {
                    map.remove(left);
                } else {
                    map.put(left, count - 1);
                }
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s1)); // Output: 3

        String s2 = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s2)); // Output: 5
    }


}

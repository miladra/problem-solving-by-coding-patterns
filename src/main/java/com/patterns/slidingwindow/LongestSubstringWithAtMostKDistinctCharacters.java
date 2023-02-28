package com.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

        public static int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (s == null || s.length() == 0 || k == 0) {
                return 0;
            }

            int n = s.length();
            int left = 0, right = 0;
            int maxLen = 0;
            HashMap<Character, Integer> map = new HashMap<>();

            while (right < n) {
                char c = s.charAt(right);
                map.put(c, map.getOrDefault(c, 0) + 1);
                right++;

                while (map.size() > k) {
                    char leftChar = s.charAt(left);
                    int count = map.get(leftChar);
                    count--;

                    if (count == 0) {
                        map.remove(leftChar);
                    } else {
                        map.put(leftChar, count);
                    }
                    left++;
                }

                maxLen = Math.max(maxLen, right - left);
            }

            return maxLen;
        }

    public static void main(String[] args) {
        String s1 = "eceba";
        System.out.println(lengthOfLongestSubstringKDistinct(s1 , 2)); // Output: 3
    }
}

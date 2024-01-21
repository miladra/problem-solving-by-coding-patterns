package com.patterns.hashing;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestConsecutive {
    public int findLongestSequence(int[] nums) {
// Hashset to store all array elements
        HashSet<Integer> numSet = new HashSet<>();

// Add all numbers to hashset
        for (int num: nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num: numSet) {
            // If current number - 1 doesn't exist, it's start of streak
            if (!numSet.contains(num - 1)) {

                // Keep checking next numbers till streak breaks
                int currentStreak = 1;
                while(numSet.contains(num + currentStreak)) {
                    currentStreak += 1;
                }

                // Update longest streak found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
  return longestStreak;
    }


    @Test
    public void test1() {
        int[] input = {100, 4, 200, 1, 3, 2};
        int expected = 4;
        int actual = findLongestSequence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyArray() {
        int[] input = {};
        int expected = 0;
        int actual = findLongestSequence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testNegativeNumbers() {
        int[] input = {-5, -4, -1};
        int expected = 2;
        int actual = findLongestSequence(input);
        assertEquals(expected, actual);
    }
}
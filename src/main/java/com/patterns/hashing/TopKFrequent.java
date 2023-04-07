package com.patterns.hashing;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TopKFrequent {
    public int[] topKFrequentBruteForce(int[] nums, int k) {
        // Count the frequency of each element
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Sort the elements based on their frequency
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freq.entrySet());
        Collections.sort(entries, (a, b) -> b.getValue() - a.getValue());

        // Return the k most frequent elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }

        return result;
    }


    //time complexity of O(n log k)
    public int[] topKFrequent(int[] nums, int k) {

        // find the frequency of each number
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();

        for (int n : nums) {
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>( (a, b) -> a.getValue() == b.getValue() ? Integer.compare(a.getKey(), b.getKey()) : a.getValue() - b.getValue());

        // go through all numbers of map & push them in a minHeap which will have top k elements
        // If at any time it has > K elements, then remove the smallest element.

        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Let's create a list of top k elements
        int[] topNumbers = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            topNumbers[i] = minHeap.poll().getKey();
            i++;
        }
        return topNumbers;
    }
}

class TestTopKFrequent {

    @Test
    public void testTopKFrequent() {
        TopKFrequent topKFrequent = new TopKFrequent();
        // Test case where k is larger than the number of unique elements in the list
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 10;
        int[] expectedOutput1 = {1, 2, 3, 4, 5,0,0,0,0,0};
        assertArrayEquals(expectedOutput1, topKFrequent.topKFrequent(nums1, k1));

        // Test case where k is equal to the length of the list
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 5;
        int[] expectedOutput2 = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedOutput2, topKFrequent.topKFrequent(nums2, k2));

        // Test case where all elements in the list are the same
        int[] nums3 = {2, 2, 2, 2, 2};
        int k3 = 1;
        int[] expectedOutput3 = {2};
        assertArrayEquals(expectedOutput3, topKFrequent.topKFrequent(nums3, k3));

        // Test case where the input list is empty
        int[] nums4 = {};
        int k4 = 0;
        int[] expectedOutput4 = {};
        assertArrayEquals(expectedOutput4, topKFrequent.topKFrequent(nums4, k4));

        // Test case where the input list contains only one element
        int[] nums5 = {42};
        int k5 = 1;
        int[] expectedOutput5 = {42};
        assertArrayEquals(expectedOutput5, topKFrequent.topKFrequent(nums5, k5));

        // Test case where there are ties for the kth most frequent element
        int[] nums6 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int k6 = 2;
        int[] expectedOutput6 = {4, 5};
        assertArrayEquals(expectedOutput6, topKFrequent.topKFrequent(nums6, k6));
    }
}


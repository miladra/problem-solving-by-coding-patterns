package com.patterns.twoheap;

import java.util.HashMap;
import java.util.PriorityQueue;

class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        // Create a min heap to store start values
        PriorityQueue<int[]> startHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Create a min heap to store end values
        PriorityQueue<int[]> endHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // Create a HashMap to store indices
        HashMap<int[], Integer> indices = new HashMap<>();

        // Add all intervals to heaps and HashMap
        for (int i = 0; i < intervals.length; i++) {
            startHeap.offer(intervals[i]);
            endHeap.offer(intervals[i]);
            indices.put(intervals[i], i);
        }

        // Create result array
        int[] result = new int[intervals.length];

        // Iterate through end values heap
        while (!endHeap.isEmpty()) {
            int[] interval = endHeap.poll();
            int endValue = interval[1];
            int index = indices.get(interval);

            // Check if there is a start value greater than or equal to end value
            while (!startHeap.isEmpty() && startHeap.peek()[0] < endValue) {
                startHeap.poll();
            }

            if (startHeap.isEmpty()) {
                result[index] = -1;
            } else {
                result[index] = indices.get(startHeap.peek());
            }
        }

        return result;
    }
}


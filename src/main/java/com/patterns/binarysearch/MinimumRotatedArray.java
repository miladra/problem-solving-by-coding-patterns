package com.patterns.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumRotatedArray {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }
}

class MinimumRotatedArrayTest {

    @Test
    public void testFindMin() {
        MinimumRotatedArray mra = new MinimumRotatedArray();

        // Test a rotated array with no duplicates
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(0, mra.findMin(nums1));

        // Test a rotated array with duplicates
        int[] nums2 = {2, 2, 2, 0, 1};
        assertEquals(0, mra.findMin(nums2));

        // Test an already sorted array
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(1, mra.findMin(nums3));

        // Test an array with only one element
        int[] nums4 = {5};
        assertEquals(5, mra.findMin(nums4));

        // Test null input
        int[] nums5 = null;
        assertEquals(0, mra.findMin(nums5));

        // Test empty input
        int[] nums6 = {};
        assertEquals(0, mra.findMin(nums6));
    }
}


package com.patterns.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
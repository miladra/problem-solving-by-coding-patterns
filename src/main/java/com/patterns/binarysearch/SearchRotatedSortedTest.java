package com.patterns.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchRotatedSortedTest {

    @Test
    public void testSearch() {
        SearchRotatedSorted solution = new SearchRotatedSorted();

        // Test normal input with target found in the middle
        int[] nums1 = {2, 4, 5, 7, 9, 10};
        int target1 = 5;
        assertEquals(2, solution.search(nums1, target1));

        // Test normal input with target found at the beginning
        int[] nums2 = {4, 6, 8, 10, 12};
        int target2 = 4;
        assertEquals(0, solution.search(nums2, target2));

        // Test normal input with target found at the end
        int[] nums3 = {1, 3, 5, 7, 9};
        int target3 = 9;
        assertEquals(4, solution.search(nums3, target3));

        // Test normal input with target not found
        int[] nums4 = {2, 4, 6, 8, 10};
        int target4 = 7;
        assertEquals(-1, solution.search(nums4, target4));

        // Test input with only one element
        int[] nums5 = {3};
        int target5 = 3;
        assertEquals(0, solution.search(nums5, target5));

        // Test input with no elements
        int[] nums6 = {};
        int target6 = 2;
        assertEquals(-1, solution.search(nums6, target6));

        // Test input with all elements equal to the target
        int[] nums7 = {7, 7, 7, 7, 7};
        int target7 = 7;
        assertEquals(2, solution.search(nums7, target7));

        // Test input with all elements equal to each other but not the target
        int[] nums8 = {5, 5, 5, 5, 5};
        int target8 = 3;
        assertEquals(-1, solution.search(nums8, target8));
    }
}

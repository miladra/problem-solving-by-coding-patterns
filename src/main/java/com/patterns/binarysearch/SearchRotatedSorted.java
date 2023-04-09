package com.patterns.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchRotatedSorted {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            /*
            If the left half is sorted, we check if the target is within the range of the left half.
            If it is, we continue the search in the left half by updating the right pointer to mid - 1.
            Otherwise, we update the left pointer to mid + 1 and continue the search in the right half.
            */
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                /*
                If the right half is sorted, we check if the target is within the range of the right half.
                If it is, we continue the search in the right half by updating the left pointer to mid +  1.
                 Otherwise, we update the right pointer to mid - 1 and continue the search in the left half.
                */
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

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


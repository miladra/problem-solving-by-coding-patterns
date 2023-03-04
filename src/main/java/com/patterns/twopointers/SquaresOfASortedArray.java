package com.patterns.twopointers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    @Test
    public void testSortedSquares() {
        SquaresOfASortedArray solution = new SquaresOfASortedArray();

        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] expected1 = {0, 1, 9, 16, 100};
        int[] result1 = solution.sortedSquares(nums1);
        assertArrayEquals(expected1, result1);

        int[] nums2 = {-7,-3,2,3,11};
        int[] expected2 = {4,9,9,49,121};
        int[] result2 = solution.sortedSquares(nums2);
        assertArrayEquals(expected2, result2);

        int[] nums3 = {-10,-5,0,5,10};
        int[] expected3 = {0,25,25,100,100};
        int[] result3 = solution.sortedSquares(nums3);
        assertArrayEquals(expected3, result3);
    }
}


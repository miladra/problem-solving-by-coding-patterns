package com.patterns.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DutchNationalFlag {

    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void testSortColors1() {
        int[] nums = {2,0,2,1,1,0};
        int[] expected = {0,0,1,1,2,2};
        DutchNationalFlag sortColors = new DutchNationalFlag();
        sortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }
}
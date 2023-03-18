package com.patterns.cyclesort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            // We use the absolute value of the current element to get the index
            int index = Math.abs(nums[i])-1;
            // If the value at that index is negative, it means we have seen this value before
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            // We negate the value at that index to mark it as seen
            nums[index] = -nums[index];
        }
        return res;
    }

    @Test
    public void testFindDuplicates() {
        int[] nums1 = {4,3,2,7,8,2,3,1};
        List<Integer> expected1 = Arrays.asList(2,3);
        assertEquals(expected1, findDuplicates(nums1));

        int[] nums2 = {1,1,2};
        List<Integer> expected2 = Arrays.asList(1);
        assertEquals(expected2, findDuplicates(nums2));

        int[] nums3 = {1};
        List<Integer> expected3 = new ArrayList<>();
        assertEquals(expected3, findDuplicates(nums3));
    }
}

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
}

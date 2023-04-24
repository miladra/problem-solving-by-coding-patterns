package com.patterns.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinDifference {
    public int minDifference(int[] nums) {
        if(nums.length <= 4) return 0;

        Arrays.sort(nums);

        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0 ; i <=3 ; i++){
            minDiff = Math.min(minDiff , nums[n - 4 + i] - nums[i]);
        }

        return minDiff;
    }

    @Test
    public void test1() {
        int[] nums = {5,3,2,4};
        int expected = 0;
        int actual = minDifference(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = {1,5,0,10,14};
        int expected = 1;
        int actual = minDifference(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = {3,100,20};
        int expected = 0;
        int actual = minDifference(nums);
        assertEquals(expected, actual);
    }

}

package com.patterns.cyclesort;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // Calculate expected sum using Gauss' Formula
        int expectedSum = n * (n + 1) / 2;
        // Calculate actual sum
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        // Return difference between expected and actual sum
        return expectedSum - actualSum;
    }
}

package com.patterns.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateArray {

    public void rotateBruteForce(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            // Move the last element to the beginning
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public void rotateExtraArray(int[] nums, int k) {
        int n = nums.length;
        int[] rotatedArray = new int[n];
        for (int i = 0; i < n; i++) {
            rotatedArray[(i + k) % n] = nums[i];
        }
        System.arraycopy(rotatedArray, 0, nums, 0, n);
    }

    public void rotate(int[] nums, int k) {
        if(nums.length == 0) return;
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void testRotateEmptyArray() {
        int[] nums = {};
        int k = 3;
        rotate(nums, k);
        assertEquals(0, nums.length);
    }

    @Test
    public void testRotateSingleElementArray() {
        int[] nums = {1};
        int k = 4;
        rotate(nums, k);
        assertArrayEquals(new int[]{1}, nums);
    }

    @Test
    public void testRotateEvenLengthArray() {
        int[] nums = {1,2,3,4};
        int k = 2;
        rotate(nums, k);
        assertArrayEquals(new int[]{3,4,1,2}, nums);
    }

    @Test
    public void testRotateOddLengthArray() {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        rotate(nums, k);
        assertArrayEquals(new int[]{3,4,5,1,2}, nums);
    }

    @Test
    public void testRotateKGreaterThanN() {
        int[] nums = {1,2,3,4,5};
        int k = 6;
        rotate(nums, k);
        assertArrayEquals(new int[]{5,1,2,3,4}, nums);
    }

    @Test
    public void testRotateKZero() {
        int[] nums = {1,2,3,4,5};
        int k = 0;
        rotate(nums, k);
        assertArrayEquals(new int[]{1,2,3,4,5}, nums);
    }

}

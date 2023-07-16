package com.patterns.cyclesort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingNumberTest {

    @Test
    public void testMissingNumber() {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums1 = {3, 0, 1};
        assertEquals(2, missingNumber.missingNumber(nums1));

        int[] nums2 = {0, 1};
        assertEquals(2, missingNumber.missingNumber(nums2));

        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        assertEquals(8, missingNumber.missingNumber(nums3));

        // Test edge case with only one element
        int[] nums4 = {0};
        assertEquals(1, missingNumber.missingNumber(nums4));

        // Test edge case with large n
        int[] nums5 = new int[10000];
        for (int i = 0; i < nums5.length; i++) {
            nums5[i] = i;
        }
        assertEquals(10000, missingNumber.missingNumber(nums5));
    }

}

package com.patterns.cyclesort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicatesInAnArrayTest {

    DuplicatesInAnArray duplicatesInAnArray = new DuplicatesInAnArray();
    @Test
    public void testFindDuplicates() {
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> expected1 = Arrays.asList(2, 3);
        assertEquals(expected1, duplicatesInAnArray.findDuplicates(nums1));
    }
    @Test
    public void testFindDuplicates1() {
        int[] nums2 = {1, 1, 2};
        List<Integer> expected2 = Arrays.asList(1);
        assertEquals(expected2, duplicatesInAnArray.findDuplicates(nums2));
    }
    @Test
    public void testFindDuplicatesOneElement() {
        int[] nums3 = {1};
        List<Integer> expected3 = new ArrayList<>();
        assertEquals(expected3, duplicatesInAnArray.findDuplicates(nums3));
    }

}

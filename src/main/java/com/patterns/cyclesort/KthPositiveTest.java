package com.patterns.cyclesort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthPositiveTest {

    @Test
    public void testFindKthPositiveCase1() {
        KthPositive kthPositive = new KthPositive();
        int[] arr1 = {2, 3, 4, 7, 11};
        int k1 = 5;
        assertEquals(9, kthPositive.findKthPositive(arr1, k1));
    }

    @Test
    public void testFindKthPositiveCase2() {
        KthPositive kthPositive = new KthPositive();
        int[] arr2 = {1, 2, 3, 4};
        int k2 = 2;
        assertEquals(6, kthPositive.findKthPositive(arr2, k2));
    }
}

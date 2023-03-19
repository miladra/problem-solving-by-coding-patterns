package com.patterns.cyclesort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthPositive {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int currentNum = 1;
        int index = 0;

        while(missingCount < k){
            if(index < arr.length && currentNum == arr[index]){
                index++;
            } else {
                missingCount++;
            }
            currentNum++;
        }

        return currentNum - 1;

    }

    @Test
    public void testFindKthPositive() {
        int[] arr1 = {2, 3, 4, 7, 11};
        int k1 = 5;
        assertEquals(9, findKthPositive(arr1, k1));

        int[] arr2 = {1, 2, 3, 4};
        int k2 = 2;
        assertEquals(6, findKthPositive(arr2, k2));
    }
}

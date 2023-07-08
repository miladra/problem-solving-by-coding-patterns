package com.patterns.cyclesort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthPositive {
    public int findKthPositive(int[] arr, int k) {
        // Initialize variables
        int missingCount = 0;
        int currentNumber = 1;
        int index = 0;

        // Loop until we find the kth missing positive integer
        while (missingCount < k) {
            // Check if currentNumber is missing from the array
            if (index < arr.length && arr[index] == currentNumber) {
                // If not missing, move to the next element in the array
                index++;
            } else {
                // If missing, increment missingCount
                missingCount++;
            }
            // Move to the next positive integer
            currentNumber++;
        }

        // Return the kth missing positive integer
        return currentNumber - 1;
    }
}

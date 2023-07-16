package com.patterns.fastslowporinter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HappyNumber {
    public static boolean isHappy(int n) {
        int slow = n;       // Slow pointer starting from n
        int fast = n;       // Fast pointer starting from n

        do {
            slow = calculateSquareSum(slow);                // Move slow pointer one step
            fast = calculateSquareSum(calculateSquareSum(fast));   // Move fast pointer two steps
        } while (slow != fast);   // Repeat until slow and fast pointers meet

        return slow == 1;   // If the cycle ends at 1, it is a happy number; otherwise, it is not
    }

    private static int calculateSquareSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;        // Extract the last digit
            sum += digit * digit;        // Add the square of the digit to the sum
            num /= 10;                   // Move to the next digit
        }
        return sum;
    }
}


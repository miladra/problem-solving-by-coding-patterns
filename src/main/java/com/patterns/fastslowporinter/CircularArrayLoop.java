package com.patterns.fastslowporinter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) { // loop through each index in the array
            if (nums[i] == 0) { // if the current number is zero, skip to the next index
                continue;
            }

            int slow = i, fast = getNext(nums, i); // set slow and fast pointers to current position i and its next position

            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[getNext(nums, fast)] > 0) { // check if there's a valid cycle
                if (slow == fast) { // if slow and fast meet at the same position
                    if (slow != getNext(nums, slow)) { // check if cycle has length greater than 1
                        return true; // if it does, return true
                    } else {
                        break; // otherwise, break out of the loop as cycle length is 1
                    }
                }

                slow = getNext(nums, slow); // move slow one step ahead
                fast = getNext(nums, getNext(nums, fast)); // move fast two steps ahead
            }

            int j = i; // create a new variable to mark all indices in the cycle
            while (nums[j] * nums[getNext(nums, j)] > 0) { // loop through the cycle indices
                int temp = j; // store current index in temp variable
                j = getNext(nums, j); // update j to next index
                nums[temp] = 0; // mark current index as visited by setting its value to 0
            }
        }

        return false; // if no valid cycle is found, return false
    }

    private int getNext(int[] nums, int i) { // helper method to get next index
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n; // to handle negative index, calculate (i + nums[i]) % n
    }

    @Test
    void testCircularArrayLoop1() {
        int[] nums = {2,-1,1,2,2};
        assertTrue(circularArrayLoop(nums));
    }

    @Test
    void testCircularArrayLoop2() {
        int[] nums = {-1,-2,-3,-4,-5,6};
        assertFalse(circularArrayLoop(nums));
    }

    @Test
    void testCircularArrayLoop3() {
        int[] nums = {1,-1,5,1,4};
        assertTrue(circularArrayLoop(nums));
    }

}

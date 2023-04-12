package com.patterns.datastream;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUniqueNumber {

    public int firstUniqueNumber(int[] nums, int number) {
        // use a linked hash map to store the numbers and their frequencies
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        // use a boolean flag to indicate if the terminating number is found
        boolean found = false;
        // iterate over the array of numbers
        for (int num : nums) {
            // update the frequency of the current number in the map
            map.put(num, map.getOrDefault(num, 0) + 1);
            // if the current number is the terminating number, set the flag to true and break the loop
            if (num == number) {
                found = true;
                break;
            }
        }
        // if the terminating number is not found, return -1
        if (!found) {
            return -1;
        }
        // iterate over the entries of the map in insertion order
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // if the frequency of the key is 1, return it as the first unique number
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        // if no unique number is found, return -1
        return -1;
    }
}

 class SolutionTest {
    // create a solution object
    FirstUniqueNumber solution = new FirstUniqueNumber();

    @Test
    public void testExample1() {
        // given
        int[] nums = {1, 2, 2, 1, 3, 4, 4, 5, 6};
        int number = 5;
        // when
        int result = solution.firstUniqueNumber(nums, number);
        // then
        assertEquals(3, result);
    }

    @Test
    public void testExample2() {
        // given
        int[] nums = {1, 2, 2, 1, 3, 4, 4, 5, 6};
        int number = 7;
        // when
        int result = solution.firstUniqueNumber(nums, number);
        // then
        assertEquals(-1, result);
    }

    @Test
    public void testExample3() {
        // given
        int[] nums = {1, 2, 2, 1, 3, 4};
        int number = 3;
        // when
        int result = solution.firstUniqueNumber(nums, number);
        // then
        assertEquals(3, result);
    }

    @Test
    public void testExample4() {
        // given
        int[] nums = {7, 7, 7};
        int number = 7;
        // when
        int result = solution.firstUniqueNumber(nums, number);
        // then
        assertEquals(7, result);
    }
}

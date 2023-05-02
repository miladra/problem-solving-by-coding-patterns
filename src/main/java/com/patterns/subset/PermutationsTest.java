package com.patterns.subset;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationsTest {

    @Test
    public void testPermute() {
        Permutations s = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 2, 3));
        expected.add(Arrays.asList(1, 3, 2));
        expected.add(Arrays.asList(2, 1, 3));
        expected.add(Arrays.asList(2, 3, 1));
        expected.add(Arrays.asList(3, 1, 2));
        expected.add(Arrays.asList(3, 2, 1));
        List<List<Integer>> actual = s.permute(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testPermuteSingleElement() {
        Permutations s = new Permutations();
        int[] nums = {1};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1));
        List<List<Integer>> actual = s.permute(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testPermuteTwoElements() {
        Permutations s = new Permutations();
        int[] nums = {0, 1};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 1));
        expected.add(Arrays.asList(1, 0));
        List<List<Integer>> actual = s.permute(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testPermuteEmptyArray() {
        Permutations s = new Permutations();
        int[] nums = {};
        List<List<Integer>> expected = new ArrayList<>();
        List<List<Integer>> actual = s.permute(nums);
        assertEquals(expected, actual);
    }
}
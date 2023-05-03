package com.patterns.subset;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationsTest {
    @Test
    void testCombine() {
        Combinations s = new Combinations();
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1,2));
        expected.add(Arrays.asList(1,3));
        expected.add(Arrays.asList(1,4));
        expected.add(Arrays.asList(2,3));
        expected.add(Arrays.asList(2,4));
        expected.add(Arrays.asList(3,4));
        assertEquals(expected, s.combine(4, 2));
    }

    @Test
    void testCombineSingleElement() {
        Combinations s = new Combinations();
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1));
        assertEquals(expected, s.combine(1, 1));
    }

    @Test
    void testCombineZeroElements() {
        Combinations s = new Combinations();
        assertEquals(1, s.combine(0, 0).size());
    }
}

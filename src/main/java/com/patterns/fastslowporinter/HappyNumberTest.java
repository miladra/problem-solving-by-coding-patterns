package com.patterns.fastslowporinter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HappyNumberTest {

    @Test
    public void testIsHappy_HappyNumber() {
        int happyNumber = 19;
        assertTrue(HappyNumber.isHappy(happyNumber));
    }

    @Test
    public void testIsHappy_NotHappyNumber() {
        int notHappyNumber = 2;
        assertFalse(HappyNumber.isHappy(notHappyNumber));
    }

    @Test
    public void testIsHappy_LargeHappyNumber() {
        int largeHappyNumber = 97;
        assertTrue(HappyNumber.isHappy(largeHappyNumber));
    }

    @Test
    public void testIsHappy_SingleDigitHappyNumber() {
        int singleDigitHappyNumber = 7;
        assertTrue(HappyNumber.isHappy(singleDigitHappyNumber));
    }

    @Test
    public void testIsHappy_MaximumInputValue() {
        int maximumInput = 2_147_483_647;
        assertFalse(HappyNumber.isHappy(maximumInput));
    }
}



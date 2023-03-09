package com.patterns.fastslowporinter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HappyNumber {

    public boolean isHappy(int n){
        int slow = n;
        int fast = getNext(n);
        while(fast != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n){
        int totalSum = 0;
        while(n > 0){
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    @Test
    public void testIsHappy() {
        HappyNumber solution = new HappyNumber();
        assertTrue(solution.isHappy(19));
        assertFalse(solution.isHappy(2));
        assertTrue(solution.isHappy(1));
        assertFalse(solution.isHappy(0));
    }
}

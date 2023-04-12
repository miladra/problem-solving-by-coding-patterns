package com.patterns.slidingwindow;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovingAverage {

    Queue<Integer> queue;
    int capacity;
    double sum;
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.capacity = size;
        this.sum = 0;
    }

    public double next(int val) {
        if(queue.size() == capacity){
            sum -= queue.poll();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();
    }

    @Test
    public void testMovingAverage() {
        MovingAverage ma = new MovingAverage(3);
        assertEquals(ma.next(1), 1.0, 0.0001);
        assertEquals(ma.next(10), 5.5, 0.0001);
        assertEquals(ma.next(3), 4.6667, 0.0001);
        assertEquals(ma.next(5), 6.0, 0.0001);
        assertEquals(ma.next(7), 5.0, 0.0001);
    }

    @Test
    public void testMovingAverageWithWindowSizeOne() {
        MovingAverage ma = new MovingAverage(1);
        assertEquals(ma.next(1), 1.0, 0.0001);
        assertEquals(ma.next(2), 2.0, 0.0001);
        assertEquals(ma.next(3), 3.0, 0.0001);
    }

}

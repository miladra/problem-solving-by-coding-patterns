package com.patterns.datastream;

import org.junit.jupiter.api.Test;
import java.util.PriorityQueue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MedianFinder {
    PriorityQueue<Integer> lowerHalf;
    PriorityQueue<Integer> upperHalf;

    public MedianFinder(){
        lowerHalf = new PriorityQueue<Integer>((a,b) -> b - a );
        upperHalf = new PriorityQueue<Integer>();
    }

   public void addNum(int num) {
       if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
           lowerHalf.add(num);
       } else {
           upperHalf.add(num);
       }

       if (upperHalf.size() > lowerHalf.size()) {
           lowerHalf.add(upperHalf.poll());
       } else if (upperHalf.size() + 1 < lowerHalf.size()) {
           upperHalf.add(lowerHalf.poll());
       }
   }

    public double findMedian() {
        if(lowerHalf.size() == upperHalf.size()){
            return (double) (lowerHalf.peek() + upperHalf.peek()) / 2 ;

        } else {
            return (double)(lowerHalf.peek());
        }
    }


    @Test
    public void testMedianFinder() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian(), 0.00001);
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian(), 0.00001);
    }

    @Test
    public void testEmpty() {
        MedianFinder medianFinder = new MedianFinder();
        assertNull(medianFinder.findMedian());
    }

    @Test
    public void testSingleElement() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        assertEquals(1.0, medianFinder.findMedian(), 0.00001);
    }

    @Test
    public void testNegativeNumbers() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        assertEquals(-1.5, medianFinder.findMedian(), 0.00001);
    }


}

package io.github.dwin357.euler;

import org.junit.Test;

import static org.junit.Assert.*;

/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Euler001_FizzBuzzSumTest {


    @Test
    public void spec_sumOfAllFizzBuzzNumbers() {
        int expectedSum = -1;
        int limit = 1000;
        Euler001_FizzBuzzSum impl = new Euler001_FizzBuzzSum(limit);

        int actualSum = impl.findSum();

        assertEquals(expectedSum, actualSum);
    }
}
package io.github.dwin357.euler;

import org.junit.Test;

import static org.junit.Assert.*;

/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Euler001_FizzBuzzSumTest {


    @Test
    public void demo_sumOfAllFizzBuzzNumbersUpTo10() {
        int expectedSum = 23;
        int limit = 10;
        Euler001_FizzBuzzSum impl = new Euler001_FizzBuzzSum(limit);

        int actualSum = impl.fizzBuzzSum();

        assertEquals(expectedSum, actualSum);
    }

    // long running test
    //@Test
    public void live_sumOfAllFizzBuzzNumbersUpTo1000() {
        int expectedSum = 233168; // derived by running the code
        int limit = 1000;
        Euler001_FizzBuzzSum impl = new Euler001_FizzBuzzSum(limit);

        int actualSum = impl.fizzBuzzSum();

        assertEquals(expectedSum, actualSum);
    }
}
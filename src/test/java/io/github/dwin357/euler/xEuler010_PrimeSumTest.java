package io.github.dwin357.euler;

import org.junit.Test;

import static org.junit.Assert.*;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 *
 */
public class xEuler010_PrimeSumTest {
    @Test
    public void demo_sumOfPrimes() {
        int expected = 17;
        int limit = 10;
        xEuler010_PrimeSum impl = new xEuler010_PrimeSum(limit);

        int actual = impl.primeSum();

        assertEquals(expected, actual);
    }

    @Test
    public void demo_edgeCase_sumOfPrimes() {
        int expected = 17;
        int limit = 7;
        xEuler010_PrimeSum impl = new xEuler010_PrimeSum(limit);

        int actual = impl.primeSum();

        assertEquals(expected, actual);
    }

    //// long running test
    @Test // executes in about 5min
    public void live_sumOfPrimes() {
        int expected = 1_179_908_154; // not correct?
        int limit = 2_000_000;
        xEuler010_PrimeSum impl = new xEuler010_PrimeSum(limit);

        int actual = impl.primeSum();

        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
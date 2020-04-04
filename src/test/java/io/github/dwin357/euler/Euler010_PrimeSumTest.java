package io.github.dwin357.euler;

import org.junit.Test;

import static org.junit.Assert.*;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 *
 */
public class Euler010_PrimeSumTest {
    @Test
    public void demo_sumOfPrimes() {
        int expected = 17;
        int limit = 10;
        Euler010_PrimeSum impl = new Euler010_PrimeSum(limit);

        int actual = impl.primeSum();

        assertEquals(expected, actual);
    }

    @Test
    public void demo_edgeCase_sumOfPrimes() {
        int expected = 17;
        int limit = 7;
        Euler010_PrimeSum impl = new Euler010_PrimeSum(limit);

        int actual = impl.primeSum();

        assertEquals(expected, actual);
    }

    @Test // executes in about 5min
    public void live_sumOfPrimes() {
        int expected = 1_179_908_154;
        int limit = 2_000_000;
        Euler010_PrimeSum impl = new Euler010_PrimeSum(limit);

        int actual = impl.primeSum();

        assertEquals(expected, actual);
    }
}
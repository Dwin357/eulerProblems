package io.github.dwin357.euler;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 *
 * What is the 10,001'st prime number?
 */

public class Euler007_10001PrimeTest {

    @Test
    public void givenExample_sixthPrime_is13() {
        int primePosition = 6;
        long expected = 13;
        Euler007_10001Prime impl = new Euler007_10001Prime();

        long actual = impl.getPrimeNumber(primePosition);

        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void givenProblem_tenThousandAndFirstPrime_isUnknown() {
        int primePosition = 10_001;
        long expected = 13;
        Euler007_10001Prime impl = new Euler007_10001Prime();

        long actual = impl.getPrimeNumber(primePosition);

        assertEquals(expected, actual);
    }
}
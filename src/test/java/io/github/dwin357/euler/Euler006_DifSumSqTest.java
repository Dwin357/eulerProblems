package io.github.dwin357.euler;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * The sum of the squares of the first ten natural numbers is,
 * 1^2+2^2+...+10^2=385
 * The square of the sum of the first ten natural numbers is,
 * (1+2+...+10)^2=55^2=3025
 * Hence the difference between the sum of the squares of the first ten
 * natural numbers and the square of the sum is 3025−385=2640.
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 *
 */

public class Euler006_DifSumSqTest {

    @Test
    public void givenExample_1to10_is2640() {
        int st = 1;
        int fin = 10;
        long expected = 2640L;
        Euler006_DifSumSq impl = new Euler006_DifSumSq();

        long actual = impl.difSum(st, fin);

        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void givenExample_1to100_isUnknown() {
        int st = 1;
        int fin = 100;
        long expected = 2640L;
        Euler006_DifSumSq impl = new Euler006_DifSumSq();

        long actual = impl.difSum(st, fin);

        assertEquals(expected, actual);
    }
}
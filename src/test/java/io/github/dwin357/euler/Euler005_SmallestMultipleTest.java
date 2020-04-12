package io.github.dwin357.euler;

import io.github.dwin357.tools.Histogram;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/*
 * 2520 is the smallest number that can be divided by each
 * of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible
 * by all of the numbers from 1 to 20?
 */

public class Euler005_SmallestMultipleTest {

    @Test
    public void smallestCommonFactor_oneToTen_2520() {
        int rangeStart = 1;
        int rangeEnd = 10;
        int expectedFactor = 2520;
        Euler005_SmallestMultiple impl = new Euler005_SmallestMultiple();

        int actualFactor = impl.smallestCommonFactor(rangeStart, rangeEnd);

        assertEquals(expectedFactor, actualFactor);

    }

    @Test
    public void multiplyAllFactors() {
        int expected = 2*2*2 *3*3 *5 *7;
        Histogram<Integer> given = new Histogram<>(Arrays.asList(2,2,2,3,3,5,7));
        Euler005_SmallestMultiple impl = new Euler005_SmallestMultiple();

        int actual = impl.multiplyAllFactors(given);

        assertEquals(expected, actual);
    }

    @Test
    public void smallestCommonFactor_oneToTwenty_unknown() {
        int rangeStart = 1;
        int rangeEnd = 20;
        int expectedFactor = 232_792_560; // my derived answer
        Euler005_SmallestMultiple impl = new Euler005_SmallestMultiple();

        int actualFactor = impl.smallestCommonFactor(rangeStart, rangeEnd);

        assertEquals(expectedFactor, actualFactor);

    }
}
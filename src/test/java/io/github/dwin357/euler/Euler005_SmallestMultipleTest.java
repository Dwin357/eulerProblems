package io.github.dwin357.euler;

import org.junit.Ignore;
import org.junit.Test;

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

    @Ignore
    @Test
    public void smallestCommonFactor_oneToTwenty_unknown() {
        int rangeStart = 1;
        int rangeEnd = 20;
        int expectedFactor = -1;
        Euler005_SmallestMultiple impl = new Euler005_SmallestMultiple();

        int actualFactor = impl.smallestCommonFactor(rangeStart, rangeEnd);

        assertEquals(expectedFactor, actualFactor);

    }
}
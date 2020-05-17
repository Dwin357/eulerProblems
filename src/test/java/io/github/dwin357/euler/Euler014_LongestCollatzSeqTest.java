package io.github.dwin357.euler;

import org.junit.Test;

import static org.junit.Assert.*;

/*
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers
 * finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 */
public class Euler014_LongestCollatzSeqTest {

    @Test
    public void givenProblem() {
        int startingRange = 13;
        int endingRange = 13;
        int expected = 10;

        int actual = Euler014_LongestCollatzSeq.solve(startingRange, endingRange);

        assertEquals(expected, actual);
    }

    @Test
    public void solveProblem() {
        int startingRange = 1;
//        int endingRange = 1_000_000;
        int endingRange = 114_000;
        int expected = 10;

        int actual = Euler014_LongestCollatzSeq.solve(startingRange, endingRange);

        assertEquals(expected, actual);
    }
}
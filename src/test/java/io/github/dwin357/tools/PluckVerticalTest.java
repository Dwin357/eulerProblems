package io.github.dwin357.tools;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
/*
 *      0,  1,  2,  3,  4,
        5,  6,  7,  8,  9,
        10, 11, 12, 13, 14,
        15, 16, 17, 18, 19,
        20, 21, 22, 23, 24,
        25, 26, 27, 28, 29
 */
public class PluckVerticalTest {

    @Test
    public void firstCol_firstRow_fullLength() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 6;
        PluckVertical tested = new PluckVertical(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 0;
        int[] expected = {0, 5, 10, 15, 20, 25};

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void lastCol_firstRow_fullLength() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 6;
        PluckVertical tested = new PluckVertical(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 4;
        int[] expected = {4, 9, 14, 19, 24, 29};

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void lastCol_secondRow_fullLength() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 6;
        PluckVertical tested = new PluckVertical(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 9;
        int[] expected = null;

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        assertNull(actual);
    }

    //TODO: test case for inner + starts at top (less full length) + ends at btm (<full)
}
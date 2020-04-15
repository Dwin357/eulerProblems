package io.github.dwin357.tools;

import org.junit.Test;

import static org.junit.Assert.*;
/*
 *      0,  1,  2,  3,  4,
        5,  6,  7,  8,  9,
        10, 11, 12, 13, 14,
        15, 16, 17, 18, 19,
        20, 21, 22, 23, 24,
        25, 26, 27, 28, 29
 */
public class PluckHorizontalTest {

    @Test
    public void firstCol_firstRow_fullLength() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 6;
        PluckHorizontal tested = new PluckHorizontal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 0;
        int[] expected = {0,5,10,15,20,25};

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        assertArrayEquals(expected, actual);
    }
}
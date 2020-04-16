package io.github.dwin357.tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class PluckHorizontalTest {
/*
 *      0,  1,  2,  3,  4,
        5,  6,  7,  8,  9,
        10, 11, 12, 13, 14,
        15, 16, 17, 18, 19,
        20, 21, 22, 23, 24,
        25, 26, 27, 28, 29
 */

    @Test
    public void firstRow_fullLength_returnsRow() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 5;
        PluckHorizontal tested = new PluckHorizontal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 0;
        int[] expected = {0,1,2,3,4};

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void lastRow_fullLength_returnsRow() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 5;
        PluckHorizontal tested = new PluckHorizontal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 25;
        int[] expected = {25,26,27,28,29};

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void innerRow_fullLength_returnsRow() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 5;
        PluckHorizontal tested = new PluckHorizontal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 10;
        int[] expected = {10,11,12,13,14};

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void firstRow_firstCol_partialLen() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 3;
        PluckHorizontal tested = new PluckHorizontal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 1;
        int[] expected = {1,2,3};

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void lastRow_lastCol_partialLength() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 3;
        PluckHorizontal tested = new PluckHorizontal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 25;
        int[] expected = {25,26,27};

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void firstRow_midStart_offEnd() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 4;
        PluckHorizontal tested = new PluckHorizontal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 4;
        int[] expected = null;

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void midRow_midStart_offEdge() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 5;
        PluckHorizontal tested = new PluckHorizontal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 17;
        int[] expected = null;

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void lastRow_midStart_offEdge() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 3;
        PluckHorizontal tested = new PluckHorizontal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 28;
        int[] expected = null;

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void negativeStartIndex() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 3;
        PluckHorizontal tested = new PluckHorizontal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = -28;
        int[] expected = null;

        int[] actual = tested.getVerticleSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    private void nullableAssertEquals(int[] expected, int[] actual) {
        if(expected == null) {
            assertNull(actual);
        } else {
            assertArrayEquals(expected, actual);
        }
    }
}
package io.github.dwin357.tools.plucker;

import io.github.dwin357.tools.plucker.PluckVertical;
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
public class PluckVerticalTest {

    @Test
    public void firstCol_firstRow_fullLength() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 6;
        PluckVertical tested = new PluckVertical(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 0;
        int[] expected = {0, 5, 10, 15, 20, 25};

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void lastCol_firstRow_fullLength() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 6;
        PluckVertical tested = new PluckVertical(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 4;
        int[] expected = {4, 9, 14, 19, 24, 29};

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void lastCol_secondRow_fullLength() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 6;
        PluckVertical tested = new PluckVertical(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 9;
        int[] expected = null;

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void innerCol_midRow_partLength() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 3;
        PluckVertical tested = new PluckVertical(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 11;
        int[] expected = {11, 16, 21};

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void innerCol_offGrid_partLength() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 3;
        PluckVertical tested = new PluckVertical(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 21;
        int[] expected = null;

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void lastCol_offGrid_partLength() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 4;
        PluckVertical tested = new PluckVertical(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 19;
        int[] expected = null;

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void firstCol_offGrid_partLength() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 6;
        PluckVertical tested = new PluckVertical(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 5;
        int[] expected = null;

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void negativeStartIndex() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 6;
        PluckVertical tested = new PluckVertical(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = -5;
        int[] expected = null;

        int[] actual = tested.pluckSubsetIndexs(startIndex);

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
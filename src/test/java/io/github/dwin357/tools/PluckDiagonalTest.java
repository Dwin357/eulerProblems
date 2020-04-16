package io.github.dwin357.tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class PluckDiagonalTest {

/*
 *      0,  1,  2,  3,  4,
        5,  6,  7,  8,  9,
        10, 11, 12, 13, 14,
        15, 16, 17, 18, 19,
        20, 21, 22, 23, 24,
        25, 26, 27, 28, 29
 */

    @Test
    public void firstRow_firstCol_fullDiag() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 5;
        PluckDiagonal tested = new PluckDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 0;
        int[] expected = {0,6,12,18,24};

        int[] actual = tested.getDiagonalSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void innerRow_innerCol_partDiag() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 2;
        PluckDiagonal tested = new PluckDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 16;
        int[] expected = {16,22};

        int[] actual = tested.getDiagonalSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void lastRow_firstCol_partDiag() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 4;
        PluckDiagonal tested = new PluckDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 10;
        int[] expected = {10,16,22,28};

        int[] actual = tested.getDiagonalSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void firstRow_lastCol_partDiag() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 3;
        PluckDiagonal tested = new PluckDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 2;
        int[] expected = {2,8,14};

        int[] actual = tested.getDiagonalSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void breaksBottomRow() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 4;
        PluckDiagonal tested = new PluckDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 15;
        int[] expected = null;

        int[] actual = tested.getDiagonalSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void breaksLastCol() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 5;
        PluckDiagonal tested = new PluckDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 1;
        int[] expected = null;

        int[] actual = tested.getDiagonalSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void lastRow_lastCol_fullDiag() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 5;
        PluckDiagonal tested = new PluckDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 5;
        int[] expected = {5,11,17,23,29};

        int[] actual = tested.getDiagonalSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void negativeStartIndex() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 5;
        PluckDiagonal tested = new PluckDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = -5;
        int[] expected = null;

        int[] actual = tested.getDiagonalSubsetIndexs(startIndex);

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
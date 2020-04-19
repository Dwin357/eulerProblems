package io.github.dwin357.tools.plucker;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PluckSlashDiagonalTest {

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

        PluckSlashDiagonal tested = new PluckSlashDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 4;
        int[] expected = {4,8,12,16,20};

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void lastRow_lastCol_fullDiag() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 5;

        PluckSlashDiagonal tested = new PluckSlashDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 9;
        int[] expected = {9,13,17,21,25};

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void innerRow_innerCol_partDiag() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 2;

        PluckSlashDiagonal tested = new PluckSlashDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 17;
        int[] expected = {17,21};

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void lastRow_lastCol_partDiag() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 4;

        PluckSlashDiagonal tested = new PluckSlashDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 14;
        int[] expected = {14,18,22,26};

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void firstRow_firstCol_partDiag() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 3;

        PluckSlashDiagonal tested = new PluckSlashDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 2;
        int[] expected = {2,6,10};

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void breaksBottomRow() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 5;

        PluckSlashDiagonal tested = new PluckSlashDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 15;
        int[] expected = null;

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void breaksFirstCol() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 5;

        PluckSlashDiagonal tested = new PluckSlashDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 3;
        int[] expected = null;

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void negativeStartIndex() {
        int horizontalEdge = 5;
        int verticleEdge = 6;
        int subsetSize = 5;
        PluckSlashDiagonal tested = new PluckSlashDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = -5;
        int[] expected = null;

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    @Test
    public void realWorld_indexOutOfBounds() {
        int horizontalEdge = 20;
        int verticleEdge = 20;
        int subsetSize = 4;
        PluckSlashDiagonal tested = new PluckSlashDiagonal(horizontalEdge, verticleEdge, subsetSize);

        int startIndex = 343;
        int[] expected = null;

        int[] actual = tested.pluckSubsetIndexs(startIndex);

        nullableAssertEquals(expected, actual);
    }

    private void nullableAssertEquals(int[] expected, int[] actual) {
        if(expected == null) {
            assertNull(String.format("Expected null, but was:%s",Arrays.toString(actual)),actual);
        } else {
            assertArrayEquals(expected, actual);
        }
    }
}
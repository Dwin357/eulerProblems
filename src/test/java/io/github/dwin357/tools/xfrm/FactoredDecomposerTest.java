package io.github.dwin357.tools.xfrm;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class FactoredDecomposerTest {

    @Test
    public void one() {
        int given = 1;
        List<Integer> expected = Arrays.asList(1);
        FactoredDecomposer tested = new FactoredDecomposer();

        List<Integer> actual = tested.decompose(given);

        assertTrue("one", CollectionUtils.isEqualCollection(expected, actual));
    }

    @Test
    public void three() {
        int given = 3;
        List<Integer> expected = Arrays.asList(1,3);
        FactoredDecomposer tested = new FactoredDecomposer();

        List<Integer> actual = tested.decompose(given);

        assertTrue("three", CollectionUtils.isEqualCollection(expected, actual));
    }

    @Test
    public void six() {
        int given = 6;
        List<Integer> expected = Arrays.asList(1,2,3,6);
        FactoredDecomposer tested = new FactoredDecomposer();

        List<Integer> actual = tested.decompose(given);

        assertTrue("six", CollectionUtils.isEqualCollection(expected, actual));
    }

    @Test
    public void ten() {
        int given = 10;
        List<Integer> expected = Arrays.asList(1,2,5,10);
        FactoredDecomposer tested = new FactoredDecomposer();

        List<Integer> actual = tested.decompose(given);

        assertTrue("ten", CollectionUtils.isEqualCollection(expected, actual));
    }

    @Test
    public void fifteen() {
        int given = 15;
        List<Integer> expected = Arrays.asList(1,3,5,15);
        FactoredDecomposer tested = new FactoredDecomposer();

        List<Integer> actual = tested.decompose(given);

        assertTrue("fifteen", CollectionUtils.isEqualCollection(expected, actual));
    }

    @Test
    public void twentyOne() {
        int given = 21;
        List<Integer> expected = Arrays.asList(1,3,7,21);
        FactoredDecomposer tested = new FactoredDecomposer();

        List<Integer> actual = tested.decompose(given);

        assertTrue("twentyOne", CollectionUtils.isEqualCollection(expected, actual));
    }

    @Test
    public void twentyEight() {
        int given = 28;
        List<Integer> expected = Arrays.asList(1,2,4,7,14,28);
        FactoredDecomposer tested = new FactoredDecomposer();

        List<Integer> actual = tested.decompose(given);

        assertTrue("twentyEight", CollectionUtils.isEqualCollection(expected, actual));
    }
}
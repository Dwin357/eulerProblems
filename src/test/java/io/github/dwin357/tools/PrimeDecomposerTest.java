package io.github.dwin357.tools;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PrimeDecomposerTest {


    @Test
    public void decompose315_to3357() {
        List<Integer> expected = Arrays.asList(3,3,5,7);
        int given = 315;
        PrimeDecomposer testedDecomposer = new PrimeDecomposer();

        List<Integer> actual = testedDecomposer.decompose(given);

        assertTrue("315", CollectionUtils.isEqualCollection(expected, actual));
    }
    @Test
    public void decompose231_to3711() {
        List<Integer> expected = Arrays.asList(11,3,7);
        int given = 231;
        PrimeDecomposer testedDecomposer = new PrimeDecomposer();

        List<Integer> actual = testedDecomposer.decompose(given);

        assertTrue("231", CollectionUtils.isEqualCollection(expected, actual));
    }
    @Test
    public void decompose1323_to77333() {
        List<Integer> expected = Arrays.asList(7,7,3,3,3);
        int given = 1323;
        PrimeDecomposer testedDecomposer = new PrimeDecomposer();

        List<Integer> actual = testedDecomposer.decompose(given);

        assertTrue("1323", CollectionUtils.isEqualCollection(expected, actual));
    }
    @Test
    public void decompose3087_to77733() {
        List<Integer> expected = Arrays.asList(7,7,7,3,3);
        int given = 3087;
        PrimeDecomposer testedDecomposer = new PrimeDecomposer();

        List<Integer> actual = testedDecomposer.decompose(given);

        assertTrue("3087", CollectionUtils.isEqualCollection(expected, actual));
    }
    @Test
    public void decompose7_to7() {
        List<Integer> expected = Arrays.asList(7);
        int given = 7;
        PrimeDecomposer testedDecomposer = new PrimeDecomposer();

        List<Integer> actual = testedDecomposer.decompose(given);

        assertTrue("7", CollectionUtils.isEqualCollection(expected, actual));
    }

    public void display() {
        int given = 2520;
        PrimeDecomposer testedDecomposer = new PrimeDecomposer();
        System.out.println(testedDecomposer.decompose(given));
    }
}
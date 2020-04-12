package io.github.dwin357.euler;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/*
 * The four adjacent digits in the 1000-digit number that have the greatest product
 * are 9 × 9 × 8 × 9 = 5832.
73167176531330624919225119674426574742355349194934
96983520312774506326239578318016984801869478851843
85861560789112949495459501737958331952853208805511
12540698747158523863050715693290963295227443043557
66896648950445244523161731856403098711121722383113
62229893423380308135336276614282806444486645238749
30358907296290491560440772390713810515859307960866
70172427121883998797908792274921901699720888093776
65727333001053367881220235421809751254540594752243
52584907711670556013604839586446706324415722155397
53697817977846174064955149290862569321978468622482
83972241375657056057490261407972968652414535100474
82166370484403199890008895243450658541227588666881
16427171479924442928230863465674813919123162824586
17866458359124566529476545682848912883142607690042
24219022671055626321111109370544217506941658960408
07198403850962455444362981230987879927244284909188
84580156166097919133875499200524063689912560717606
05886116467109405077541002256983155200055935729725
71636269561882670428252483600823257530420752963450

* Find the thirteen adjacent digits in the 1000-digit number
* that have the greatest product. What is the value of this product?
 */

public class Euler008_LargestProductInSeriesTest {

    private String MAGIC_NUM =
            "73167176531330624919225119674426574742355349194934" +
            "96983520312774506326239578318016984801869478851843" +
            "85861560789112949495459501737958331952853208805511" +
            "12540698747158523863050715693290963295227443043557" +
            "66896648950445244523161731856403098711121722383113" +
            "62229893423380308135336276614282806444486645238749" +
            "30358907296290491560440772390713810515859307960866" +
            "70172427121883998797908792274921901699720888093776" +
            "65727333001053367881220235421809751254540594752243" +
            "52584907711670556013604839586446706324415722155397" +
            "53697817977846174064955149290862569321978468622482" +
            "83972241375657056057490261407972968652414535100474" +
            "82166370484403199890008895243450658541227588666881" +
            "16427171479924442928230863465674813919123162824586" +
            "17866458359124566529476545682848912883142607690042" +
            "24219022671055626321111109370544217506941658960408" +
            "07198403850962455444362981230987879927244284909188" +
            "84580156166097919133875499200524063689912560717606" +
            "05886116467109405077541002256983155200055935729725" +
            "71636269561882670428252483600823257530420752963450";

    @Test
    public void givenExample_4set_5832() {
        int setSize = 4;
        long expected = 5832;

        Euler008_LargestProductInSeries impl = new Euler008_LargestProductInSeries();

        long actual = impl.solve(setSize, MAGIC_NUM);

        assertEquals(expected, actual);
    }

    @Test
    public void givenProblem_13set_unknown() {
        int setSize = 13;
        long expected = 23_514_624_000L; // this works

        Euler008_LargestProductInSeries impl = new Euler008_LargestProductInSeries();

        long actual = impl.solve(setSize, MAGIC_NUM);

        assertEquals(expected, actual);
    }

    @Test
    public void impl_correctlyLoadsMasterSet() {
        Euler008_LargestProductInSeries wrapper = new Euler008_LargestProductInSeries();
        String loadSet = "123456789";
        int doesntMatter = 3;
        Euler008_LargestProductInSeries.Impl impl = wrapper.getImpl(doesntMatter, loadSet);

        int[] expected = {1,2,3,4,5,6,7,8,9};
        int[] actual = impl.masterSet;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void impl_correctlyLoadsSubSets() {
        Euler008_LargestProductInSeries wrapper = new Euler008_LargestProductInSeries();
        String loadSet = "123456";
        int doesntMatter = 3;
        Euler008_LargestProductInSeries.Impl impl = wrapper.getImpl(doesntMatter, loadSet);

        Euler008_LargestProductInSeries.SubSet[] expected = {
                wrapper.getSubSet(new int[] {1,2,3}),
                wrapper.getSubSet(new int[] {2,3,4}),
                wrapper.getSubSet(new int[] {3,4,5}),
                wrapper.getSubSet(new int[] {4,5,6})
        };
        Euler008_LargestProductInSeries.SubSet[] actual = impl.subSets;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void subSet_product() {
        Euler008_LargestProductInSeries wrapper = new Euler008_LargestProductInSeries();
        Euler008_LargestProductInSeries.SubSet tested = wrapper.getSubSet(new int[] {4,5,6,7,8});

        long expected = 4*5*6*7*8;
        long actual = tested.getProduct();

        assertEquals(expected, actual);
    }

    @Test
    public void impl_maxSubSet() {
        Euler008_LargestProductInSeries wrapper = new Euler008_LargestProductInSeries();
        Euler008_LargestProductInSeries.SubSet expected = wrapper.getSubSet(new int[] {4,5,6});
        String loadSet = "123456";
        int subSz = 3;

        Euler008_LargestProductInSeries.Impl impl = wrapper.getImpl(subSz, loadSet);
        Euler008_LargestProductInSeries.SubSet actual = impl.getMaxSubSet();

        assertEquals(expected, actual);
    }

}
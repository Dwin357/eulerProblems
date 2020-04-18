package io.github.dwin357.euler;

import io.github.dwin357.tools.struct.Triple;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class Euler009_PythagoreanTipleTest {
/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

    @Rule public MockitoRule rule = MockitoJUnit.rule();
    @Mock private Euler009_PythagoreanTiple.Upstream upstream;


    @Test
    public void givenExample_345() {
        Euler009_PythagoreanTiple impl = new Euler009_PythagoreanTiple();
        int givenSum = 12;
        int expectedProduct = 60;

        int actualProduct = impl.solve(givenSum);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void givenProblem_unkn() {
        Euler009_PythagoreanTiple impl = new Euler009_PythagoreanTiple();
        int givenSum = 1000;
        int expectedProduct = 31_875_000;

        int actualProduct = impl.solve(givenSum);

        assertEquals(expectedProduct, actualProduct);
    }

    //////////////////////////////////////////////

    @Test
    public void filter_sum() {
        Euler009_PythagoreanTiple wrapper = new Euler009_PythagoreanTiple();
        Triple<Integer,Integer,Integer> nine = new Triple<>(3,3,3);
        Triple<Integer,Integer,Integer> five = new Triple<>(1,2,2);
        Triple<Integer,Integer,Integer> twelve = new Triple<>(3,4,5);
        when(upstream.getNext()).thenReturn(nine,five,twelve);

        Euler009_PythagoreanTiple.Filter testedFilter = wrapper.getSumFilter(upstream, 12);
        Triple<Integer,Integer,Integer> actual = testedFilter.getNext();

        assertEquals(twelve, actual);
    }

    @Test
    public void filter_pythag() {
        Euler009_PythagoreanTiple wrapper = new Euler009_PythagoreanTiple();
        Triple<Integer,Integer,Integer> equalat = new Triple<>(3,3,3);
        Triple<Integer,Integer,Integer> isos = new Triple<>(1,2,2);
        Triple<Integer,Integer,Integer> right = new Triple<>(3,4,5);
        when(upstream.getNext()).thenReturn(equalat,isos,right);

        Euler009_PythagoreanTiple.Filter testedFilter = wrapper.getPythagFilter(upstream);
        Triple<Integer,Integer,Integer> actual = testedFilter.getNext();

        assertEquals(right, actual);
    }

    @Test
    public void filter_abcOrder() {
        Euler009_PythagoreanTiple wrapper = new Euler009_PythagoreanTiple();
        Triple<Integer,Integer,Integer> aMoreB = new Triple<>(2,1,3);
        Triple<Integer,Integer,Integer> bMoreC = new Triple<>(1,3,2);
        Triple<Integer,Integer,Integer> valid = new Triple<>(1,2,3);
        when(upstream.getNext()).thenReturn(aMoreB,bMoreC,valid);

        Euler009_PythagoreanTiple.Filter testedFilter = wrapper.getOrderFilter(upstream);
        Triple<Integer,Integer,Integer> actual = testedFilter.getNext();

        assertEquals(valid, actual);
    }

    @Test
    public void filter_abcOrder_eq() {
        Euler009_PythagoreanTiple wrapper = new Euler009_PythagoreanTiple();
        Triple<Integer,Integer,Integer> aEqB = new Triple<>(2,2,3);
        Triple<Integer,Integer,Integer> bEqC = new Triple<>(1,3,3);
        Triple<Integer,Integer,Integer> valid = new Triple<>(1,2,3);
        when(upstream.getNext()).thenReturn(aEqB,bEqC,valid);

        Euler009_PythagoreanTiple.Filter testedFilter = wrapper.getOrderFilter(upstream);
        Triple<Integer,Integer,Integer> actual = testedFilter.getNext();

        assertEquals(valid, actual);
    }

    @Test
    public void producer_getNext() {
        int lim = 2;
        Euler009_PythagoreanTiple impl = new Euler009_PythagoreanTiple();
        Euler009_PythagoreanTiple.TripleProducer tested = impl.getProducer(lim);

        Triple<Integer,Integer,Integer> exFirst = new Triple<>(0,0,0);
        assertTrue("first hasNext", tested.hasNext());
        assertEquals("first triple", exFirst, tested.getNext());

        Triple<Integer,Integer,Integer> exSecond = new Triple<>(0,0,1);
        assertTrue("second hasNext", tested.hasNext());
        assertEquals("second triple", exSecond, tested.getNext());

        Triple<Integer,Integer,Integer> exThird = new Triple<>(0,0,2);
        assertTrue("third hasNext", tested.hasNext());
        assertEquals("third triple", exThird, tested.getNext());

        Triple<Integer,Integer,Integer> exFourth = new Triple<>(0,1,0);
        assertTrue("fourth hasNext", tested.hasNext());
        assertEquals("fourth triple", exFourth, tested.getNext());

        Triple<Integer,Integer,Integer> exFifth = new Triple<>(0,1,1);
        assertTrue("fifth hasNext", tested.hasNext());
        assertEquals("fifth triple", exFifth, tested.getNext());

        Triple<Integer,Integer,Integer> exSixth = new Triple<>(0,2,0);
        assertTrue("sixth hasNext", tested.hasNext());
        assertEquals("sixth triple", exSixth, tested.getNext());

        Triple<Integer,Integer,Integer> exSeven = new Triple<>(1,0,0);
        assertTrue("seventh hasNext", tested.hasNext());
        assertEquals("seventh triple", exSeven, tested.getNext());

        Triple<Integer,Integer,Integer> exEight = new Triple<>(1,0,1);
        assertTrue("eighth hasNext", tested.hasNext());
        assertEquals("eigth triple", exEight, tested.getNext());

        Triple<Integer,Integer,Integer> exNinth = new Triple<>(1,1,0);
        assertTrue("ninth hasNext", tested.hasNext());
        assertEquals("ninth triple", exNinth, tested.getNext());

        Triple<Integer,Integer,Integer> exTenth = new Triple<>(2,0,0);
        assertTrue("tenth hasNext", tested.hasNext());
        assertEquals("tenth triple", exTenth, tested.getNext());

        assertFalse("eleventh hasNext", tested.hasNext());
    }
}
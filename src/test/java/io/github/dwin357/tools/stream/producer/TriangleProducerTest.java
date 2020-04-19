package io.github.dwin357.tools.stream.producer;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleProducerTest {

    @Test
    public void correctlyReturnsFirstTenTriangleNumbers() {
        Integer expFirst = 1;
        Integer expSecond = 3;
        Integer expThird = 6;
        Integer expFourth = 10;
        Integer expFifth = 15;
        Integer expSixth = 21;
        Integer expSeventh = 28;
        Integer expEigth = 36;
        Integer expNinth = 45;
        Integer expTenth = 55;

        TriangleProducer tested = new TriangleProducer();

        assertTrue("first-hasNext", tested.hasNext());
        assertEquals("first value", expFirst, tested.getNext());

        assertTrue("second-hasNext", tested.hasNext());
        assertEquals("second value", expSecond, tested.getNext());

        assertTrue("third-hasNext", tested.hasNext());
        assertEquals("third value", expThird, tested.getNext());

        assertTrue("fourth-hasNext", tested.hasNext());
        assertEquals("fourth value", expFourth, tested.getNext());

        assertTrue("fifth-hasNext", tested.hasNext());
        assertEquals("fifth value", expFifth, tested.getNext());

        assertTrue("sixth-hasNext", tested.hasNext());
        assertEquals("sixth value", expSixth, tested.getNext());

        assertTrue("seventh-hasNext", tested.hasNext());
        assertEquals("seventh value", expSeventh, tested.getNext());

        assertTrue("eigth-hasNext", tested.hasNext());
        assertEquals("eigth value", expEigth, tested.getNext());

        assertTrue("ninth-hasNext", tested.hasNext());
        assertEquals("ninth value", expNinth, tested.getNext());

        assertTrue("tenth-hasNext", tested.hasNext());
        assertEquals("tenth value", expTenth, tested.getNext());
    }
}
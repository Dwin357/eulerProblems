package io.github.dwin357.tools.stream.producer;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerProducerTest {

    @Test
    public void countsAllTheIntegers() {
        int start = 5;
        int end = 8;
        IntegerProducer tested = new IntegerProducer(start, end);

        assertTrue("has next @5", tested.hasNext());
        assertEquals(new Integer(5), tested.getNext());

        assertTrue("has next @6", tested.hasNext());
        assertEquals(new Integer(6), tested.getNext());

        assertTrue("has next @7", tested.hasNext());
        assertEquals(new Integer(7), tested.getNext());

        assertTrue("has next @8", tested.hasNext());
        assertEquals(new Integer(8), tested.getNext());

        assertFalse("no next after 8", tested.hasNext());
    }
}
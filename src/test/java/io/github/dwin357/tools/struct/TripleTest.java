package io.github.dwin357.tools.struct;

import io.github.dwin357.tools.struct.Triple;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripleTest {

    @Test
    public void equals() {
        Triple<Integer,Integer,Integer> a = new Triple<>(1,2,3);

        Triple<Integer,Integer,Integer> b = new Triple<>(1,2,3);

        assertEquals(a, b);
    }
}
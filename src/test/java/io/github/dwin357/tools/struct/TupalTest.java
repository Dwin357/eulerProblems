package io.github.dwin357.tools.struct;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TupalTest {

    @Test
    public void equals() {
        Tupal<Integer, Integer> a = new Tupal<>(1,2);
        Tupal<Integer,Integer> b = new Tupal<>(1,2);

        assertEquals(a,b);
    }
}
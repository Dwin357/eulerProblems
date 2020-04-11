package io.github.dwin357.tools;

import io.github.dwin357.concepts.DayOfWeek;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.github.dwin357.concepts.DayOfWeek.*;
import static org.junit.Assert.*;

public class HistogramTest  {

    @Test
    public void whenListOfOneElement_hasHistogramOfOne() {
        Integer expectedCount = 1;
        Histogram<DayOfWeek> testedHistogram = new Histogram<>(Arrays.asList(WEDNESDAY));

        Integer actualCount = testedHistogram.get(WEDNESDAY);

        assertEquals(expectedCount, actualCount);
    }
    @Test
    public void whenListOfThreeElement_hasHistogramOfThree() {
        Integer expectedWedCount = 1;
        Integer expectedFriCount = 2;
        Histogram<DayOfWeek> testedHistogram = new Histogram<>(Arrays.asList(WEDNESDAY, FRIDAY, FRIDAY));

        Integer actualWedCount = testedHistogram.get(WEDNESDAY);
        Integer actualFriCount = testedHistogram.get(FRIDAY);

        assertEquals(expectedWedCount, actualWedCount);
        assertEquals(expectedFriCount, actualFriCount);
    }
    @Test
    public void whenEmptyList_zero() {
        Integer expectedCount = 0;
        Histogram<DayOfWeek> testedHistogram = new Histogram<>();

        Integer actualCount = testedHistogram.get(WEDNESDAY);

        assertEquals(expectedCount, actualCount);
    }
    @Test
    public void whenAddElement_incrementsCount() {
        Integer expectedBeforeCount = 2;
        Integer expectedAfterCount = 5;
        Histogram<DayOfWeek> testedHistogram = new Histogram<>(Arrays.asList(THRUSDAY, THRUSDAY));

        // sanity ck
        assertEquals(expectedBeforeCount, testedHistogram.get(THRUSDAY));

        // tested act
        testedHistogram.add(THRUSDAY, 3);

        Integer actualAfterCount = testedHistogram.get(THRUSDAY);

        assertEquals(expectedAfterCount, actualAfterCount);
    }

    @Test
    public void implementsForLoop() {

        Histogram<DayOfWeek> testedHistogram = new Histogram<>(Arrays.asList(
                TUESDAY, WEDNESDAY, WEDNESDAY, THRUSDAY, THRUSDAY, THRUSDAY));

        DayOfWeek[] actual = new DayOfWeek[4];
        // ie the histogram is expected to have: { 1 tuesday, 2 wed, ... }
        DayOfWeek[] expected = {null, TUESDAY, WEDNESDAY, THRUSDAY};

        // testedAct
        for(Map.Entry<DayOfWeek, Integer> entry : testedHistogram.entrySet()) {
            actual[entry.getValue()] = entry.getKey();
        }

        assertArrayEquals(expected, actual);
    }
}
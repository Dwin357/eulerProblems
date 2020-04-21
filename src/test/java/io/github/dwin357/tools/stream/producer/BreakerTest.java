package io.github.dwin357.tools.stream.producer;

import io.github.dwin357.euler.Euler009_PythagoreanTiple;
import io.github.dwin357.tools.stream.StreamProducer;
import io.github.dwin357.tools.stream.StreamTerminal;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BreakerTest {
    @Rule public MockitoRule rule = MockitoJUnit.rule();
    @Mock private StreamProducer<String> upstream;
    @Mock private StreamTerminal<Integer> terminal;
    private Predicate<Integer> breakCondition;

    @Test
    public void hasNextWhileConditionFalse() {
        when(upstream.hasNext()).thenReturn(true);
        when(terminal.peek()).thenReturn(7,6,5,4,3);
        List<String> expected = Arrays.asList("a","b","c");
        breakCondition = (i) -> {
            return i < 5;
        };
        when(upstream.getNext()).thenReturn("a","b","c","d","e");
        Breaker<String,Integer> tested = new Breaker<>(upstream,terminal,breakCondition);

        List<String> measurement = new ArrayList<>();
        while(tested.hasNext()) {
            measurement.add(tested.getNext());
        }
        assertEquals(expected.size(), measurement.size());
    }

    @Test
    public void returnsExpectedItems() {
        when(upstream.hasNext()).thenReturn(true);
        when(terminal.peek()).thenReturn(7,6,5,4,3);
        List<String> expected = Arrays.asList("a","b","c");
        breakCondition = (i) -> {
            return i < 5;
        };
        when(upstream.getNext()).thenReturn("a","b","c","d","e");
        Breaker<String,Integer> tested = new Breaker<>(upstream,terminal,breakCondition);

        List<String> measurement = new ArrayList<>();
        while(tested.hasNext()) {
            measurement.add(tested.getNext());
        }
        assertTrue(CollectionUtils.isEqualCollection(expected,measurement));
    }
}
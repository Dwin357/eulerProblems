package io.github.dwin357.tools.stream.junction;

import io.github.dwin357.tools.stream.StreamConsumer;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class SplitterTest {
    @Rule public MockitoRule rule = MockitoJUnit.rule();
    @Mock private StreamConsumer<Integer> con1;
    @Mock private StreamConsumer<Integer> con2;
    @Mock private StreamConsumer<Integer> con3;

    private final Random rand = new Random();

    @Test
    public void consume_delegatesToAllConsumers() {
        Integer given = rand.nextInt();
        Splitter<Integer> tested = new Splitter<>(Arrays.asList(con1,con2,con3));

        tested.consume(given);
        verify(con1).consume(given);
        verify(con2).consume(given);
        verify(con3).consume(given);
    }
}
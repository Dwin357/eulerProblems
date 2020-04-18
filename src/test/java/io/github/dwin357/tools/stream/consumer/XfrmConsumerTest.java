package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.stream.StreamConsumer;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Random;
import java.util.function.Function;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class XfrmConsumerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock StreamConsumer<String> mockConsumer;
    @Captor ArgumentCaptor<String> passed;

    private final Random rand = new Random();

    @Test
    public void xfrExecutesFunctionAndDelegatesToDownstream() {
        Function<Integer,String> f = (i) -> {
           return Integer.toString(i);
        };
        Integer given = rand.nextInt();
        String expected = Integer.toString(given);

        XfrmConsumer<Integer,String> tested = new XfrmConsumer<>(f,mockConsumer);
        tested.consume(given);

        verify(mockConsumer).consume(passed.capture());
        assertEquals(expected, passed.getValue());
    }
}
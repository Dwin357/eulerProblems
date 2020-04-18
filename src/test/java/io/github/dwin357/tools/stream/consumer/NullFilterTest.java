package io.github.dwin357.tools.stream.consumer;

import org.apache.commons.lang3.RandomStringUtils;

import io.github.dwin357.tools.stream.StreamConsumer;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class NullFilterTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    StreamConsumer<String> mockConsumer;

    @Test
    public void nonNull_isPassedOn() {
        NullFilter<String> tested = new NullFilter<>(mockConsumer);
        String given = RandomStringUtils.random(5);

        tested.consume(given);

        verify(mockConsumer).consume(given);
    }

    @Test
    public void nullIsSwallowed() {
        NullFilter<String> tested = new NullFilter<>(mockConsumer);
        String given = null;

        tested.consume(given);

        verifyZeroInteractions(mockConsumer);
    }
}
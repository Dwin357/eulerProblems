package io.github.dwin357.tools.stream.junction;

import io.github.dwin357.tools.stream.StreamConsumer;
import io.github.dwin357.tools.stream.StreamProducer;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

public class SwitchTest {

    @Rule public MockitoRule rule = MockitoJUnit.rule();
    @Mock private StreamProducer<Integer> prod;
    @Mock private StreamConsumer<Integer> con;
    private final Random rand = new Random();

    @Test
    public void delegatesProducerOutputToConsumers() {
        Integer a = rand.nextInt();
        Integer b = rand.nextInt();
        Integer c = rand.nextInt();
        when(prod.hasNext()).thenReturn(true,true,true,false);
        when(prod.getNext()).thenReturn(a,b,c);

        Switch<Integer> tested = new Switch<>(prod, con);
        tested.flip();

        InOrder order = inOrder(con);
        order.verify(con).consume(a);
        order.verify(con).consume(b);
        order.verify(con).consume(c);
    }
}
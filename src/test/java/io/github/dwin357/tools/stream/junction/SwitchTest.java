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
    @Mock private StreamConsumer<Integer> con1;
    @Mock private StreamConsumer<Integer> con2;
    @Mock private StreamConsumer<Integer> con3;
    private final Random rand = new Random();

    @Test
    public void delegatesProducerOutputToConsumers() {
        Integer a = rand.nextInt();
        Integer b = rand.nextInt();
        Integer c = rand.nextInt();
        when(prod.hasNext()).thenReturn(true,true,true,false);
        when(prod.getNext()).thenReturn(a,b,c);

        Switch<Integer> tested = new Switch<>(prod, Arrays.asList(con1,con2,con3));
        tested.flip();

        InOrder order1 = inOrder(con1);
        order1.verify(con1).consume(a);
        order1.verify(con1).consume(b);
        order1.verify(con1).consume(c);

        InOrder order2 = inOrder(con2);
        order2.verify(con2).consume(a);
        order2.verify(con2).consume(b);
        order2.verify(con2).consume(c);

        InOrder order3 = inOrder(con3);
        order3.verify(con3).consume(a);
        order3.verify(con3).consume(b);
        order3.verify(con3).consume(c);
    }
}
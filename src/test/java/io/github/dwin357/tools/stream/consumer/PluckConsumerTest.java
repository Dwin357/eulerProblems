package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.plucker.Plucker;
import io.github.dwin357.tools.stream.StreamConsumer;
import io.github.dwin357.tools.stream.consumer.PluckConsumer;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Random;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PluckConsumerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    Plucker mockPlucker;
    @Mock StreamConsumer<int[]> mockDownStream;

    private final Random rand = new Random();

    @Test
    public void delegatesToPluckerThenPassesDownstream() {
        int upstream = rand.nextInt();
        int[] pluckResponse = randomIntAry(rand);
        PluckConsumer tested = new PluckConsumer(mockPlucker, mockDownStream);
        when(mockPlucker.pluckSubsetIndexs(upstream)).thenReturn(pluckResponse);

        tested.consume(upstream);

        verify(mockDownStream).consume(pluckResponse);
    }

    private int[] randomIntAry(Random random) {
        int[] rtn = new int[random.nextInt(30)];
        for(int i=0; i<rtn.length; i++){
            rtn[i] = random.nextInt();
        }
        return rtn;
    }
}
package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.stream.StreamConsumer;
import io.github.dwin357.tools.struct.Tupal;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class AryValueEnricherTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock StreamConsumer downStream;

    private final Random rand = new Random();

    @Test
    public void plucksIndexsAndPassToDownstream() {
        int[] masterSet = randomIntAry(rand, 15);
        AryValueEnricher tested = new AryValueEnricher(masterSet, downStream);

        int ai = rand.nextInt(15);
        int a = masterSet[ai];
        int bi = rand.nextInt(15);
        int b = masterSet[bi];
        int ci = rand.nextInt(15);
        int c = masterSet[ci];
        int[] givenIndexs = {ai, bi, ci};
        int[] expectedValues = {a,b,c};
        Tupal<int[],int[]> expected = new Tupal<>(givenIndexs, expectedValues);

//        tested.consume(givenIndexs);

        verify(downStream).consume(expected);
    }

    private int[] randomIntAry(Random random, int sz) {
        int[] rtn = new int[sz];
        for(int i=0; i<rtn.length; i++){
            rtn[i] = random.nextInt();
        }
        return rtn;
    }
}
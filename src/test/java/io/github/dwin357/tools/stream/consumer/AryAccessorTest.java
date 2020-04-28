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

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class AryAccessorTest {

    private final Random randy = new Random();
    @Rule public MockitoRule rule = MockitoJUnit.rule();
    @Mock private StreamConsumer<Integer[]> mockDownStream;
    @Captor ArgumentCaptor<Integer[]> passed;

    @Test
    public void delegatesValuesFromSelectedIndexs() {
        Integer[] seedAry = getRandomIntegerAry();
        Integer[] selectIndexs = {getRandomIndex(seedAry), getRandomIndex(seedAry), getRandomIndex(seedAry)};
        Integer[] expectedOut = {seedAry[selectIndexs[0]], seedAry[selectIndexs[1]], seedAry[selectIndexs[2]]};
        AryAccessor<Integer> tested = new AryAccessor<>(seedAry, Integer.class, mockDownStream);

        tested.consume(selectIndexs);

        verify(mockDownStream).consume(passed.capture());
        assertArrayEquals(expectedOut, passed.getValue());
    }

    private Integer getRandomIndex(Integer[] set) {
        return randy.nextInt(set.length);
    }
    private Integer[] getRandomIntegerAry() {
        Integer[] rtn = new Integer[randy.nextInt(10)+10]; // between 10-20 long
        for(int i=0; i<rtn.length; i++) {
            rtn[i] = randy.nextInt();
        }
        return rtn;
    }

}
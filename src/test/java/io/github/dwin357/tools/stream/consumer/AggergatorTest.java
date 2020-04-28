package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.stream.StreamConsumer;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.function.BiFunction;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AggergatorTest {

    @Rule public MockitoRule rule = MockitoJUnit.rule();
    @Mock private StreamConsumer<Superhero> mockDownStream;
    @Mock private BiFunction<Superhero,Supervillian,Superhero> doJustice;
    @Mock private Superhero mockHeroOne;
    @Mock private Supervillian mockVillianOne;
    @Mock private Superhero mockHeroTwo;
    @Mock private Supervillian mockVillianTwo;
    @Mock private Superhero mockHeroThree;

    @Test
    public void twoConstructorArg_noAdds_returnsCacheValue() {
        Superhero expected = mockHeroOne;
        Aggergator<Superhero,Supervillian> tested = new Aggergator<>(mockHeroOne,doJustice);

        Superhero actual = tested.peek();

        assertSame(expected, actual);
    }
    @Test
    public void threeConstructorArg_noAdds_returnsCacheValue() {
        Superhero expected = mockHeroOne;
        Aggergator<Superhero,Supervillian> tested = new Aggergator<>(mockHeroOne,doJustice,mockDownStream);

        Superhero actual = tested.peek();

        assertSame(expected, actual);
    }
    @Test
    public void threeConstructorArg_oneAdds_returnsNewValue() {
        Superhero expected = mockHeroTwo;
        when(doJustice.apply(mockHeroOne,mockVillianOne)).thenReturn(mockHeroTwo);
        Aggergator<Superhero,Supervillian> tested = new Aggergator<>(mockHeroOne,doJustice,mockDownStream);

        tested.consume(mockVillianOne);
        Superhero actual = tested.peek();

        assertSame(expected, actual);
    }
    @Test
    public void threeConstructorArg_oneAdds_delegatesValue() {
        Superhero expected = mockHeroTwo;
        when(doJustice.apply(mockHeroOne,mockVillianOne)).thenReturn(mockHeroTwo);
        Aggergator<Superhero,Supervillian> tested = new Aggergator<>(mockHeroOne,doJustice,mockDownStream);

        tested.consume(mockVillianOne);

        verify(mockDownStream).consume(expected);
    }
    @Test
    public void twoConstructorArg_oneAdds_returnsNewValue() {
        Superhero expected = mockHeroTwo;
        when(doJustice.apply(mockHeroOne,mockVillianOne)).thenReturn(mockHeroTwo);
        Aggergator<Superhero,Supervillian> tested = new Aggergator<>(mockHeroOne,doJustice);

        tested.consume(mockVillianOne);
        Superhero actual = tested.peek();

        assertSame(expected, actual);
    }
    @Test
    public void twoConstructorArg_twoAdds_returnsNewValue() {
        Superhero expected = mockHeroThree;
        when(doJustice.apply(mockHeroOne,mockVillianOne)).thenReturn(mockHeroTwo);
        when(doJustice.apply(mockHeroTwo,mockVillianTwo)).thenReturn(mockHeroThree);
        Aggergator<Superhero,Supervillian> tested = new Aggergator<>(mockHeroOne,doJustice);

        tested.consume(mockVillianOne);
        tested.consume(mockVillianTwo);
        Superhero actual = tested.peek();

        assertSame(expected, actual);
    }
    @Test
    public void threeConstructorArg_twoAdds_returnsNewValue() {
        Superhero expected = mockHeroThree;
        when(doJustice.apply(mockHeroOne,mockVillianOne)).thenReturn(mockHeroTwo);
        when(doJustice.apply(mockHeroTwo,mockVillianTwo)).thenReturn(mockHeroThree);
        Aggergator<Superhero,Supervillian> tested = new Aggergator<>(mockHeroOne,doJustice,mockDownStream);

        tested.consume(mockVillianOne);
        tested.consume(mockVillianTwo);
        Superhero actual = tested.peek();

        assertSame(expected, actual);
    }
    @Test
    public void threeConstructorArg_twoAdds_delegatesValues() {
        when(doJustice.apply(mockHeroOne,mockVillianOne)).thenReturn(mockHeroTwo);
        when(doJustice.apply(mockHeroTwo,mockVillianTwo)).thenReturn(mockHeroThree);
        Aggergator<Superhero,Supervillian> tested = new Aggergator<>(mockHeroOne,doJustice,mockDownStream);

        tested.consume(mockVillianOne);
        tested.consume(mockVillianTwo);

        InOrder order = inOrder(mockDownStream);
        order.verify(mockDownStream).consume(mockHeroTwo);
        order.verify(mockDownStream).consume(mockHeroThree);
    }

    private interface Superhero{}
    private interface Supervillian {}
}
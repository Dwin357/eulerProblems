package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.struct.Tupal;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertSame;

public class LocalExtremaConsumerTest {

    private Comparator<Tupal<String,Integer>> fruitOrder;
    private Tupal<String, Integer> apple;
    private Tupal<String, Integer> pairApples;
    private Tupal<String, Integer> apples;
    private Tupal<String, Integer> peachs;
    private Tupal<String, Integer> pear;

    @Before
    public void setupData() {
        apple = new Tupal<>("apple", 1);
        pairApples = new Tupal<>("apple", 2);
        apples = new Tupal<>("apple", 5);
        peachs = new Tupal<>("peach", 10);
        pear = new Tupal<>("pear", 1);
        // alphabetical first, count(high first) second
        fruitOrder = (a,b) -> {
            int nameCompare = a.getOne().compareTo(b.getOne());
            if(nameCompare != 0) {
                return nameCompare;
            } else {
                return b.getTwo().compareTo(a.getTwo());
            }
        };
    }

    @Test
    public void hodsExpectedValue_seed() {
        Tupal<Integer,Integer> zero = new Tupal<>(0,0);
        Tupal<Integer,Integer> two = new Tupal<>(2,2);
        Tupal<Integer,Integer> one = new Tupal<>(1,1);
        Comparator<Tupal<Integer,Integer>> numOrder = (a,b) ->{
            int aa = a.getTwo();
            int bb = b.getTwo();
            return bb - aa;
        };

        LocalExtremaConsumer<Tupal<Integer,Integer>> tested = new LocalExtremaConsumer<>(numOrder,zero);

        assertSame(zero, tested.getCachedElement());

        tested.consume(two);
        assertSame(two, tested.getCachedElement());

        tested.consume(one);
        assertSame(two, tested.getCachedElement());
    }

    @Test
    public void holdsExpectedValue_noSeed() {
        LocalExtremaConsumer<Tupal<String,Integer>> tested = new LocalExtremaConsumer<>(fruitOrder);

        assertNull(tested.getCachedElement());

        tested.consume(peachs);
        assertSame(peachs, tested.getCachedElement());

        tested.consume(pear); // after peachs on spelling
        assertSame(peachs, tested.getCachedElement());

        tested.consume(pairApples); // before peachs on spelling
        assertSame(pairApples, tested.getCachedElement());

        tested.consume(apple); // after pairApples on count
        assertSame(pairApples, tested.getCachedElement());

        tested.consume(apples); // before pairApples on count
        assertSame(apples, tested.getCachedElement());
    }


}
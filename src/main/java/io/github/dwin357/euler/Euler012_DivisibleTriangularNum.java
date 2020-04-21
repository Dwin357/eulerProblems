package io.github.dwin357.euler;

import io.github.dwin357.tools.stream.consumer.SimpleTerminal;
import io.github.dwin357.tools.stream.consumer.XfrmConsumer;
import io.github.dwin357.tools.stream.junction.Splitter;
import io.github.dwin357.tools.stream.junction.Switch;
import io.github.dwin357.tools.stream.producer.Breaker;
import io.github.dwin357.tools.stream.producer.TriangleProducer;
import io.github.dwin357.tools.xfrm.FactoredDecomposer;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * 2020.04.19:1056 - first observations
 * ...so now that I have the stream architecture setup,
 * x - it seems pretty trivial to create a "triangle num producer"...
 *
 * However this will force a new producer-component (working-name "breaker")
 *   This is needed b/c the trig-prod is an infinite stream/series
 *     so the breaker is a way short the infinite run
 *  x - This also then begs the question: the breaker needs to be constantly cking
 *     some measurement, and break flow when a certain condition is met...
 *  x - This implies to me another new consumer-component (working-name "terminal")
 *     which essentially implements a peek function
 *
 * x - Also, I clearly need a "factorer" which accepts a num and returns a list of factors
 *
 * Once we have those factor lists, it should be trivial to count the list size
 *
 * This list sz can then be pushed to a terminal (which will trip the breaker when 15 is hit)
 *
 *
 */
public class Euler012_DivisibleTriangularNum {

    public static int firstTriNumWithThresholdFactors(int threshold) {
        TriangleProducer triProd = new TriangleProducer();
        SimpleTerminal<Integer> factorCtTerminal = new SimpleTerminal<>(0);
        Predicate<Integer> breakCondition = (factorCt) -> {
            return factorCt >= threshold;
        };
        FactoredDecomposer decomp = new FactoredDecomposer();
        Function<Integer,Integer> factorCounter = (tri) -> {
            return decomp.decompose(tri).size();
        };
        Breaker<Integer,Integer> thresholdBreaker = new Breaker<>(triProd,factorCtTerminal,breakCondition);
        XfrmConsumer<Integer,Integer> factComp = new XfrmConsumer<>(factorCounter,factorCtTerminal);
        SimpleTerminal<Integer> triagTerminal = new SimpleTerminal<>();
        Splitter<Integer> triagSplitter = new Splitter<>(Arrays.asList(factComp,triagTerminal));
        Switch<Integer> switchh = new Switch<>(thresholdBreaker,triagSplitter);

        switchh.flip();
        return triagTerminal.peek();
    }

}

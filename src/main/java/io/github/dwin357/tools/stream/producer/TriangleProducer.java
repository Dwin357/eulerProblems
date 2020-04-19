package io.github.dwin357.tools.stream.producer;

import io.github.dwin357.tools.stream.StreamProducer;

public class TriangleProducer implements StreamProducer<Integer> {
    private int runningSum;
    private int lastIncrement;

    public TriangleProducer() {
        runningSum = 0;
        lastIncrement = 1;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer getNext() {
        runningSum = runningSum + lastIncrement;
        lastIncrement++;
        return runningSum;
    }
}

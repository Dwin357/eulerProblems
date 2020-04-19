package io.github.dwin357.tools.stream.producer;

import io.github.dwin357.tools.stream.StreamProducer;

public class IntegerProducer implements StreamProducer<Integer> {

    private final Integer lastInteger;
    private Integer currentInteger;

    public IntegerProducer(int start, int end) {
        this.currentInteger = start;
        this.lastInteger = end;
    }

    @Override
    public boolean hasNext() {
        return currentInteger.compareTo(lastInteger) < 0;
    }

    @Override
    public Integer getNext() {
        Integer nxt = currentInteger;
        currentInteger = currentInteger + 1;
        return nxt;
    }
}

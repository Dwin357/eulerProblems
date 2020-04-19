package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.stream.StreamConsumer;
import io.github.dwin357.tools.stream.StreamTerminal;

public class SimpleTerminal<K> implements StreamConsumer<K>, StreamTerminal<K> {
    private K cacheValue;

    @Override
    public void consume(K nextItem) {
        this.cacheValue = nextItem;
    }

    @Override
    public K peek() {
        return cacheValue;
    }
}

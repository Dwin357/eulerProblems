package io.github.dwin357.tools.stream.junction;

import io.github.dwin357.tools.stream.StreamConsumer;

import java.util.List;

public class Splitter<K> implements StreamConsumer<K> {

    private final List<? extends StreamConsumer<K>> consumers;

    public Splitter(List<? extends StreamConsumer<K>> consumers) {
        this.consumers = consumers;
    }

    @Override
    public void consume(K nextItem) {
        for(StreamConsumer<K> consumer : consumers) {
            consumer.consume(nextItem);
        }
    }
}

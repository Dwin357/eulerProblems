package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.stream.StreamConsumer;

public class NullFilter<K> implements StreamConsumer<K> {

    private final StreamConsumer<K> downStream;

    public NullFilter(StreamConsumer<K> downStream) {
        this.downStream = downStream;
    }

    @Override
    public void consume(K nextItem) {
        if(nextItem != null) {
            downStream.consume(nextItem);
        }
    }
}

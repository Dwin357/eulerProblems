package io.github.dwin357.tools.stream.junction;

import io.github.dwin357.tools.stream.StreamConsumer;
import io.github.dwin357.tools.stream.StreamProducer;

import java.util.List;

public class Switch<K> {
    private final StreamProducer<K> producer;
    private final StreamConsumer<K> consumer;

    public Switch(StreamProducer<K> producer, StreamConsumer<K> consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    public void flip() {
        K input;
        while(producer.hasNext()) {
            input = producer.getNext();
            consumer.consume(input);
        }
    }
}

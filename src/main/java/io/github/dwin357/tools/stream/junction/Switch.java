package io.github.dwin357.tools.stream.junction;

import io.github.dwin357.tools.stream.StreamConsumer;
import io.github.dwin357.tools.stream.StreamProducer;

import java.util.List;

public class Switch<K> {
    private final StreamProducer<K> producer;
    private final List<StreamConsumer<K>> consumers;

    public Switch(StreamProducer<K> producer, List<StreamConsumer<K>> consumers) {
        this.producer = producer;
        this.consumers = consumers;
    }

    public void flip() {
        K input;
        while(producer.hasNext()) {
            input = producer.getNext();
            for(StreamConsumer<K> channel : consumers) {
                channel.consume(input);
            }
        }
    }
}

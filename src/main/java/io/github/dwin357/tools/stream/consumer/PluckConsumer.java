package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.plucker.Plucker;
import io.github.dwin357.tools.stream.StreamConsumer;

public class PluckConsumer implements StreamConsumer<Integer> {

    private final Plucker plucker;
    private final StreamConsumer<int[]> downStream;

    public PluckConsumer(Plucker plucker, StreamConsumer<int[]> next) {
        this.plucker = plucker;
        this.downStream = next;
    }


    @Override
    public void consume(Integer nextItem) {
        downStream.consume(plucker.pluckSubsetIndexs(nextItem));
    }
}

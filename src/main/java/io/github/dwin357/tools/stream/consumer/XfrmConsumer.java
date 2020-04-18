package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.stream.StreamConsumer;

import java.util.function.Function;

public class XfrmConsumer<I,O> implements StreamConsumer<I> {
    private final Function<I,O> xfrm;
    private final StreamConsumer<O> downStream;

    public XfrmConsumer(Function<I, O> xfrm, StreamConsumer<O> downStream) {
        this.xfrm = xfrm;
        this.downStream = downStream;
    }

    @Override
    public void consume(I nextItem) {
        downStream.consume(xfrm.apply(nextItem));
    }
}

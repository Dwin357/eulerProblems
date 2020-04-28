package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.stream.StreamConsumer;
import io.github.dwin357.tools.stream.StreamTerminal;

import java.util.function.BiFunction;

public class Aggergator<C,K> implements StreamTerminal<C>, StreamConsumer<K> {
    private C cache;
    private final BiFunction<C,K,C> cacheUpdate;
    private final StreamConsumer<C> downStream;

    public Aggergator(C cache, BiFunction<C, K, C> cacheUpdate) {
        this(cache, cacheUpdate, null);
    }

    public Aggergator(C cache, BiFunction<C, K, C> cacheUpdate, StreamConsumer<C> downStream) {
        this.cache = cache;
        this.cacheUpdate = cacheUpdate;
        this.downStream = downStream;
    }


    @Override
    public void consume(K nextItem) {
        cache = cacheUpdate.apply(cache, nextItem);
        if(downStream != null) {
            downStream.consume(cache);
        }
    }

    @Override
    public C peek() {
        return cache;
    }
}

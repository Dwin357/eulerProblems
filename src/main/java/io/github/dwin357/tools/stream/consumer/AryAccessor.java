package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.stream.StreamConsumer;

import java.lang.reflect.Array;

public class AryAccessor<K> implements StreamConsumer<Integer[]> {

    private final K[] masterSet;
    private final Class<K> setType;
    private final StreamConsumer<K[]> downStream;

    public AryAccessor(K[] masterSet, Class<K> setType, StreamConsumer<K[]> downStream) {
        this.masterSet = masterSet;
        this.setType = setType;
        this.downStream = downStream;
    }

    @Override
    public void consume(Integer[] nextItem) {
        K[] rtn = (K[]) Array.newInstance(setType, nextItem.length);
        for(int i=0; i<nextItem.length; i++) {
            rtn[i] = masterSet[nextItem[i]];
        }
        downStream.consume(rtn);
    }
}

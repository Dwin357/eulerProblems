package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.stream.StreamConsumer;
import io.github.dwin357.tools.struct.Tupal;

import java.util.Arrays;

public class AryValueEnricher implements StreamConsumer<int[]> {

    private final int[] masterSet;
    private final StreamConsumer<Tupal<int[],int[]>> downStream;

    public AryValueEnricher(int[] masterSet, StreamConsumer<Tupal<int[],int[]>> next) {
        this.masterSet = masterSet;
        this.downStream = next;
    }

    @Override
    public void consume(int[] nextItem) {
        downStream.consume(new Tupal<>(nextItem, pluckIndexs(nextItem)));
    }

    private int[] pluckIndexs(int[] indexs) {
        int[] rtn = new int[indexs.length];
        for(int i=0; i<indexs.length; i++){
            rtn[i] = masterSet[indexs[i]];
        }
        return rtn;
    }
}

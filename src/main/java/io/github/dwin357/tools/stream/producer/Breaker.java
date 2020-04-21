package io.github.dwin357.tools.stream.producer;

import io.github.dwin357.tools.stream.StreamProducer;
import io.github.dwin357.tools.stream.StreamTerminal;

import java.util.function.Predicate;

public class Breaker<U,T> implements StreamProducer<U> {

    private final StreamProducer<U> upstream;
    private final StreamTerminal<T> terminal;
    private final Predicate<T> breakCondition;

    public Breaker(StreamProducer<U> upstream, StreamTerminal<T> terminal, Predicate<T> breakCondition) {
        this.upstream = upstream;
        this.terminal = terminal;
        this.breakCondition = breakCondition;
    }

    @Override
    public boolean hasNext() {
        return upstream.hasNext() && isNotBroken();
    }

    private boolean isNotBroken() {
        return !breakCondition.test(terminal.peek());
    }

    @Override
    public U getNext() {
        return upstream.getNext();
    }
}

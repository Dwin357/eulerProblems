package io.github.dwin357.tools.stream;

/*
 * For push streams
 */
public interface StreamConsumer<K> {

    public void consume(K nextItem);
}

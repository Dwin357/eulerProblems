package io.github.dwin357.tools.stream;

/*
 * This is for pull systems
 */
public interface StreamProducer<K> {

    public boolean hasNext();
    public K getNext();
}

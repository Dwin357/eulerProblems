package io.github.dwin357.tools.stream.consumer;

import io.github.dwin357.tools.stream.StreamConsumer;

import java.util.Comparator;

/*
 * had to look "Extrema" up on the internets
 * (from wikipedia)
 * "In mathematical analysis, the maxima and minima (the respective
 * plurals of maximum and minimum) of a function, known collectively
 * as extrema (the plural of extremum)..."
 */
public class LocalExtremaConsumer<E> implements StreamConsumer<E> {

    private final Comparator<E> comp;
    private E cachedElement;

    public LocalExtremaConsumer(Comparator<E> comp, E seed) {
        this.comp = comp;
        this.cachedElement = seed;
    }
    public LocalExtremaConsumer(Comparator<E> comp) {
        this(comp, null);
    }

    @Override
    public void consume(E nextItem) {
        if(cachedElement != null) {
            if(comp.compare(cachedElement, nextItem) >= 1) {
                this.cachedElement = nextItem;
            }
        } else {
            this.cachedElement = nextItem;
        }
    }

    public E getCachedElement() {
        return cachedElement;
    }
}

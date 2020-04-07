package io.github.dwin357.tools;

import java.util.*;
import java.util.function.Consumer;

public class Histogram <K> {

    private Map<K, Integer> hist;

    public Histogram () {
        super();
        hist = new HashMap<K, Integer>();
    }

    public Histogram(List<K> elements) {
        this();
        for(K el : elements) {
            this.add(el, 1);
        }
    }

    public Integer get(K key) {
        return hist.getOrDefault(key, 0);
    }

    public void add(K key, Integer ct) {
        hist.put(key, (get(key)+ct));
    }

    public Set<Map.Entry<K, Integer>> blah() {
        return hist.entrySet();
    }


}

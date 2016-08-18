package com.coffeegem.hacker.data;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import java.util.Collections;

public class MultimapGraph<E> extends Graph<E> {
    private Multimap<E,E> edges = LinkedHashMultimap.create();

    public void addEdge(E src, E dest) {
        edges.put(src,dest);
    }

    /**
     * Return an unmodifiable list of neighbors.
     *
     * @param vertex node (point) in the graph
     * @return an unmodifiable list of neighbors for the given vertex (key)
     */
    public Iterable<E> getNeighbors(E vertex) {
        return Collections.unmodifiableCollection(edges.get(vertex));
    }
}

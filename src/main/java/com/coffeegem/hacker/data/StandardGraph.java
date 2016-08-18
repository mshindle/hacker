package com.coffeegem.hacker.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardGraph<E> extends Graph<E> {
    // Alternatively use Google's Multimap implementation. Sticking with std java for now.
    private Map<E,List<E>> edges = new HashMap<>();

    public void addEdge(E src, E dest) {
        List<E> neighbors = edges.get(src);
        if (neighbors == null) {
            neighbors = new ArrayList<E>();
            edges.put(src,neighbors);
        }
        neighbors.add(dest);
    }

    /**
     * Return an unmodifiable list of neighbors.
     *
     * @param vertex node (point) in the graph
     * @return an unmodifiable list of neighbors for the given vertex (key)
     */
    public Iterable<E> getNeighbors(E vertex) {
        List<E> neighbors = edges.get(vertex);
        if (neighbors == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(neighbors);
    }
}

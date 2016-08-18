package com.coffeegem.hacker.data;

import com.google.common.base.Objects;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class WeightedGraph<T> {
    private Multimap<T,Edge<T>> graph = LinkedHashMultimap.create();

    public WeightedGraph() {}

    public void addEdge(T source, T dest, int weight) {
        Edge<T> edge = new Edge<T>(source, dest, weight);
        graph.put(source, edge);
    }

    public void removeEdge(T source, Edge<T> edge) {
        graph.remove(source, edge);
    }

    public Iterable<Edge<T>> getEdges(T vertex) {
        return Collections.unmodifiableCollection(graph.get(vertex));
    }

    public Map<T, Integer> shortestPaths(T source) {
        PriorityQueue<QueueEntry<T>> pq = new PriorityQueue<>();
        QueueEntry<T> root = new QueueEntry<T>(source,0);
        pq.add(root);

        return shortestPaths(pq);
    }

    private Map<T, Integer> shortestPaths(PriorityQueue<QueueEntry<T>> pq) {
        Map<T, Integer> distances = new HashMap<>();
        Map<T, Integer> result = new HashMap<>();
        QueueEntry<T> u, v;

        while (!pq.isEmpty()) {
            u = pq.poll();
            result.put(u.vertex,u.distance);
            // look at distances to each neighbor
            for (Edge<T> edge : getEdges(u.vertex)) {
                int altDistance = u.distance + edge.getWeight();
                int curDistance = distances.getOrDefault(edge.getDest(), Integer.MAX_VALUE);
                if (altDistance < curDistance) {
                    // remove the old entry & re-add using the new weight
                    v = new QueueEntry<T>(edge.getDest(),altDistance);
                    pq.remove(v);
                    pq.add(v);
                    distances.put(v.vertex,v.distance);
                }
            }
        }
        return result;
    }

     public static class Edge<T> {
        private T source;
        private T dest;
        private int weight;

        public Edge(T source, T dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }

        public T getSource() {
            return source;
        }

        public T getDest() {
            return dest;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge<?> edge = (Edge<?>) o;
            return Objects.equal(getSource(), edge.getSource()) &&
                    Objects.equal(getDest(), edge.getDest());
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(getSource(), getDest());
        }
    }

    private static class QueueEntry<T> implements Comparable<QueueEntry<T>> {
        T vertex;
        Integer distance;

        QueueEntry(T vertex, Integer distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            QueueEntry<?> that = (QueueEntry<?>) o;
            return Objects.equal(vertex, that.vertex);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(vertex);
        }

        @Override
        public int compareTo(QueueEntry<T> o) {
            return distance.compareTo(o.distance);
        }
    }
}

package com.coffeegem.hacker.data;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public abstract class Graph<E> {
    abstract public void addEdge(E src, E dest);
    abstract public Iterable<E> getNeighbors(E vertex);

    /**
     *
     * @param vertex node (point) in the graph to begin the traversal
     * @param visitor agent which acts upon each node visited in the traversal
     */
    public void preOrderTraversal(E vertex, Visitor<E> visitor) {
        preOrderTraversal(vertex, visitor, new HashSet<E>());
    }

    private void preOrderTraversal(E vertex, Visitor<E> visitor, Set<E> visited) {
        visitor.visit(vertex);
        visited.add(vertex);

        for (E neighbor : getNeighbors(vertex)) {
            // if neighbor has not been visited then recurse
            if (!visited.contains(neighbor)) {
                preOrderTraversal(neighbor, visitor, visited);
            }
        }
    }

    public void breadthFirstTraversal(E vertex, Visitor<E> visitor) {
        Set<E> visited = new HashSet<>();
        Queue<E> queue = new LinkedList<>();

        queue.add(vertex);              //Adds to end of queue
        visited.add(vertex);

        while (!queue.isEmpty()) {
            //removes from front of queue
            vertex = queue.remove();
            visitor.visit(vertex);

            //Visit child first before grandchild
            for (E neighbor : getNeighbors(vertex)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}

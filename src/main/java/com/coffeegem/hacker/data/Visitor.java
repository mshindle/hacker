package com.coffeegem.hacker.data;

/**
 * Created by mike on 8/17/16.
 */
public interface Visitor<E> {
    void visit(E vertex);
}

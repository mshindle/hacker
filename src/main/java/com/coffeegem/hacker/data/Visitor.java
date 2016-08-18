package com.coffeegem.hacker.data;

public interface Visitor<E> {
    void visit(E vertex);
}

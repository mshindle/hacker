package com.coffeegem.hacker.data;

import com.google.common.base.Objects;

public class Vertex {
    private String id;

    public Vertex(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equal(getId(), vertex.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}

package com.coffeegem.hacker.data;

public class Node<E> {
    private E value;
    private Node<E> right;
    private Node<E> left;

    public Node(E value) {
        this.value = value;
    }

    public Node() { }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}

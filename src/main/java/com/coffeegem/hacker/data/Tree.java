package com.coffeegem.hacker.data;

import java.util.Stack;

public class Tree {
    public static <E> void preOrderTraversal(Node<E> node, Visitor<Node<E>> visitor) {
        if (node == null) return;
        visitor.visit(node);
        preOrderTraversal(node.getLeft(), visitor);
        preOrderTraversal(node.getRight(), visitor);
    }

    public static <E> void preOrderIter(Node<E> root, Visitor<Node<E>> visitor) {
        if (root == null) return;
        Stack<Node<E>> stack = new Stack<>();

        stack.push(root);
        while (!stack.empty()) {
            Node<E> node = stack.pop();
            visitor.visit(node);
            if (node.getRight() != null)
                stack.push(node.getRight());
            if (node.getLeft() != null)
                stack.push(node.getLeft());
        }
    }

    public static <E> void inOrderTraversal(Node<E> node, Visitor<Node<E>> visitor) {
        if (node == null) return;
        inOrderTraversal(node.getLeft(), visitor);
        visitor.visit(node);
        inOrderTraversal(node.getRight(), visitor);
    }

    public static <E> void inOrderIter(Node<E> root, Visitor<Node<E>> visitor) {
        Stack<Node<E>> stack = new Stack<>();
        Node<E> node = root;
        while (!stack.empty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                visitor.visit(node);
                node = node.getRight();
            }
        }
    }

    public static <E> void postOrderTraversal(Node<E> node, Visitor<Node<E>> visitor) {
        if (node == null) return;
        postOrderTraversal(node.getLeft(), visitor);
        postOrderTraversal(node.getRight(), visitor);
        visitor.visit(node);
    }

    public static <E> void postOrderIter(Node<E> root, Visitor<Node<E>> visitor) {
        Stack<Node<E>> stack = new Stack<>();
        Node<E> node = root, lastVisited = null, peekNode;

        while (!stack.empty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                peekNode = stack.peek();
                if (peekNode.getRight() != null && lastVisited != peekNode.getRight()) {
                    node = peekNode.getRight();
                } else {
                    lastVisited = stack.pop();
                    visitor.visit(lastVisited);
                }
            }
        }
    }
}

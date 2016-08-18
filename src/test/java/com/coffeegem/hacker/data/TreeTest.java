package com.coffeegem.hacker.data;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mike on 8/17/16.
 */
public class TreeTest {
    private static Node<String> root;

    @BeforeClass
    public static void setUp() throws Exception {
        Node<String> a = new Node<String>("A");
        Node<String> b = new Node<String>("B");
        Node<String> c = new Node<String>("C");
        Node<String> d = new Node<String>("D");
        Node<String> e = new Node<String>("E");
        Node<String> f = new Node<String>("F");
        Node<String> g = new Node<String>("G");
        Node<String> h = new Node<String>("H");
        Node<String> i = new Node<String>("I");

        d.setLeft(c);
        d.setRight(e);
        b.setLeft(a);
        b.setRight(d);
        f.setLeft(b);
        f.setRight(g);
        g.setRight(i);
        i.setLeft(h);

        root = f;
    }

    @Test
    public void preOrderTraversal() throws Exception {
        Visitor<Node<String>> crumbtrail = new TreeTest.Crumbtrail();
        Tree.preOrderTraversal(root, crumbtrail);
        assertEquals("F B A D C E G I H", crumbtrail.toString());
    }

    @Test
    public void preOrderIter() throws Exception {
        Visitor<Node<String>> crumbtrail = new TreeTest.Crumbtrail();
        Tree.preOrderIter(root, crumbtrail);
        assertEquals("F B A D C E G I H", crumbtrail.toString());
    }

    @Test
    public void inOrderTraversal() throws Exception {
        Visitor<Node<String>> crumbtrail = new TreeTest.Crumbtrail();
        Tree.inOrderTraversal(root, crumbtrail);
        assertEquals("A B C D E F G H I", crumbtrail.toString());
    }

    @Test
    public void inOrderIter() throws Exception {
        Visitor<Node<String>> crumbtrail = new TreeTest.Crumbtrail();
        Tree.inOrderIter(root, crumbtrail);
        assertEquals("A B C D E F G H I", crumbtrail.toString());
    }

    @Test
    public void postOrderTraversal() throws Exception {
        Visitor<Node<String>> crumbtrail = new TreeTest.Crumbtrail();
        Tree.postOrderTraversal(root, crumbtrail);
        assertEquals("A C E D B H I G F", crumbtrail.toString());
    }

    @Test
    public void postOrderIter() throws Exception {
        Visitor<Node<String>> crumbtrail = new TreeTest.Crumbtrail();
        Tree.postOrderIter(root, crumbtrail);
        assertEquals("A C E D B H I G F", crumbtrail.toString());
    }

    private static class Crumbtrail implements Visitor<Node<String>> {
        private StringBuilder sb = new StringBuilder();

        @Override
        public void visit(Node<String> vertex) {
            sb.append(' ').append(vertex.getValue());
        }

        public String toString() {
            return sb.substring(1);
        }
    }
}
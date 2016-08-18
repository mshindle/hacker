package com.coffeegem.hacker.data;

import com.google.common.collect.Multimap;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class GraphTest {
    public static StandardGraph<String> gstd;
    public static MultimapGraph<String> gmulti;

    @BeforeClass
    public static void setUp() throws Exception {
        gstd = new StandardGraph<String>();
        buildGraph(gstd);
        gmulti = new MultimapGraph<>();
        buildGraph(gmulti);
    }

    public static void buildGraph(Graph<String> g) {
        g.addEdge("A","B");
        g.addEdge("B","C");
        g.addEdge("B","D");
        g.addEdge("B","A");
        g.addEdge("B","E");
        g.addEdge("B","F");
        g.addEdge("C","A");
        g.addEdge("D","C");
        g.addEdge("E","B");
        g.addEdge("F","B");
    }

    @Test
    public void preOrderTraversalFromAStd() throws Exception {
        Visitor<String> crumbtrail = new Crumbtrail();
        gstd.preOrderTraversal("A",crumbtrail);
        assertEquals("A B C D E F", crumbtrail.toString());
    }

    @Test
    public void breadthFirstTraversalFromBStd() throws Exception {
        Visitor<String> crumbtrail = new Crumbtrail();
        gstd.breadthFirstTraversal("B",crumbtrail);
        assertEquals("B C D A E F", crumbtrail.toString());
    }

    @Test
    public void preOrderTraversalFromAMulti() throws Exception {
        Visitor<String> crumbtrail = new Crumbtrail();
        gmulti.preOrderTraversal("A",crumbtrail);
        assertEquals("A B C D E F", crumbtrail.toString());
    }

    @Test
    public void breadthFirstTraversalFromBMulti() throws Exception {
        Visitor<String> crumbtrail = new Crumbtrail();
        gmulti.breadthFirstTraversal("B",crumbtrail);
        assertEquals("B C D A E F", crumbtrail.toString());
    }

    private static class Crumbtrail implements Visitor<String> {
        private StringBuilder sb = new StringBuilder();

        @Override
        public void visit(String vertex) {
            sb.append(' ').append(vertex);
        }

        public String toString() {
            return sb.substring(1);
        }
    }
}
package com.coffeegem.hacker.data;

import com.google.common.collect.Maps;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class WeightedGraphTest {
    private static WeightedGraph<Vertex> wgraph;
    private static Vertex source;
    private static Map<Vertex,Integer> expected;

    @BeforeClass
    public static void setUp() throws Exception {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        Vertex g = new Vertex("g");
        Vertex h = new Vertex("h");
        Vertex i = new Vertex("i");

        wgraph = new WeightedGraph<>();
        wgraph.addEdge(a,b,4);
        wgraph.addEdge(b,c,8);
        wgraph.addEdge(c,d,7);
        wgraph.addEdge(d,e,9);
        wgraph.addEdge(f,e,10);
        wgraph.addEdge(d,f,14);
        wgraph.addEdge(a,b,4);
        wgraph.addEdge(c,i,2);
        wgraph.addEdge(g,i,6);
        wgraph.addEdge(g,f,2);
        wgraph.addEdge(h,g,1);
        wgraph.addEdge(h,i,7);
        wgraph.addEdge(b,h,11);
        wgraph.addEdge(a,h,8);
        wgraph.addEdge(c,f,4);

        source = a;

        expected = new HashMap<>(9);
        expected.put(a,0);
        expected.put(b,4);
        expected.put(c,12);
        expected.put(d,19);
        expected.put(e,21);
        expected.put(f,11);
        expected.put(g,9);
        expected.put(h,8);
        expected.put(i,14);
    }

    @Test
    public void shortestPathTest() throws Exception {
        Map<Vertex,Integer> result = wgraph.shortestPaths(source);
        result.keySet().stream().forEach((v) -> System.out.printf("%s: %d\n",v,result.get(v)));
        assertTrue(Maps.difference(expected,result).areEqual());
    }
}
package nnov.hse.optimization.parser;

import java.util.*;

/**
 * @author vkuzn on 25.09.2016.
 */
public class Graph {

    private int vertices;
    private List<Edge> edges;

    public Graph() {
        edges = new ArrayList<>();
    }

    public Graph(List<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertices=" + vertices +
                ", edges=" + edges +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Graph graph = (Graph) o;

        if (vertices != graph.vertices) return false;
        return !(edges != null ? !edges.equals(graph.edges) : graph.edges != null);

    }

    @Override
    public int hashCode() {
        int result = vertices;
        result = 31 * result + (edges != null ? edges.hashCode() : 0);
        return result;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}

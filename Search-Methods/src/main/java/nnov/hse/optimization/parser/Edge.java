package nnov.hse.optimization.parser;

/**
 * @author vkuzn on 25.09.2016.
 */
public class Edge {
    private int firstVertex;
    private int secondVertex;

    public Edge() {
    }

    public Edge(int firstVertex, int secondVertex) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }

    public int getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(int firstVertex) {
        this.firstVertex = firstVertex;
    }

    public int getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(int secondVertex) {
        this.secondVertex = secondVertex;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "firstVertex=" + firstVertex +
                ", secondVertex=" + secondVertex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (firstVertex != edge.firstVertex) return false;
        return secondVertex == edge.secondVertex;

    }

    @Override
    public int hashCode() {
        int result = firstVertex;
        result = 31 * result + secondVertex;
        return result;
    }
}

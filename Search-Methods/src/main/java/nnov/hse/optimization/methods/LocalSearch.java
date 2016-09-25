package nnov.hse.optimization.methods;

import nnov.hse.optimization.parser.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author vkuzn on 25.09.2016.
 */
public class LocalSearch {

    private Graph graph;
    private List<Integer> currentSolution = new ArrayList<>();
    private List<Integer> bestFound = new ArrayList<>();

    public LocalSearch(Graph graph) {
        this.graph = graph;
    }

    public void localSearch() {
        int firstVertex = getRandomVertexFromGraph();
        currentSolution.add(firstVertex);
        bestFound.add(firstVertex);
    }

    private int getRandomVertexFromGraph() {
        return ThreadLocalRandom.current().nextInt(1, graph.getEdges().size() + 1);
    }

    public List<Integer> getAllNeighborsOfVertex(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        graph.getEdges().stream().filter(edge -> edge.getFirstVertex() == vertex)
                .forEach(edge -> neighbors.add(edge.getSecondVertex()));
        graph.getEdges().stream().filter(edge -> edge.getSecondVertex() == vertex)
                .forEach(edge -> neighbors.add(edge.getFirstVertex()));
        return neighbors;
    }
}

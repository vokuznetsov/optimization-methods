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
    private static final int NUMBER_OF_ITERATIONS = 1000;     // stopping criteria

    public LocalSearch(Graph graph) {
        this.graph = graph;
    }

    public void localSearch() {
        int firstVertex = getRandomVertexFromGraph();
        System.out.println("Random vertex is " + firstVertex);
        currentSolution.add(firstVertex);
        bestFound.add(firstVertex);
        int count = 0;
        while (count < NUMBER_OF_ITERATIONS) {

            count++;
        }

    }

    public int getRandomVertexFromGraph() {
        return ThreadLocalRandom.current().nextInt(1, graph.getVertices());
    }

    public List<Integer> getAllNeighborsOfVertex(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        graph.getEdges().stream().filter(edge -> edge.getFirstVertex() == vertex)
                .forEach(edge -> neighbors.add(edge.getSecondVertex()));
        graph.getEdges().stream().filter(edge -> edge.getSecondVertex() == vertex)
                .forEach(edge -> neighbors.add(edge.getFirstVertex()));
        return neighbors;
    }

    public List<Integer> getClique(List<Integer> vertices) {
        List<Integer> clique = new ArrayList<>(vertices);
        List<Integer> newVertex = new ArrayList<>(getAllNeighborsOfVertex(clique.get(0)));
        vertices.stream().anyMatch(vert -> {
            newVertex.retainAll(getAllNeighborsOfVertex(vert));
            return newVertex.isEmpty();
        });

        if (newVertex.isEmpty())
            return clique;
        if (newVertex.size() > 1)
            clique.add(newVertex.get(ThreadLocalRandom.current().nextInt(0, newVertex.size() - 1)));
        else clique.add(newVertex.get(0));
        return clique;
    }
}

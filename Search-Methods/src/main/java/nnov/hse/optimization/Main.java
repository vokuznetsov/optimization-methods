package nnov.hse.optimization;

import nnov.hse.optimization.methods.LocalSearch;
import nnov.hse.optimization.parser.Graph;
import nnov.hse.optimization.parser.Parser;

import java.io.IOException;

/**
 * @author vkuzn on 25.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        String path = "/graphs/C125.9.clq.txt";

        Parser parser = new Parser();
        LocalSearch localSearch;
        try {
            Graph graph = parser.parser(path);
            localSearch = new LocalSearch(graph);
            System.out.println("vertices: " + graph.getVertices() + " edge: " + graph.getEdges().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

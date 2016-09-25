package nnov.hse.optimization.parser;

import java.io.*;

/**
 * @author vkuzn on 25.09.2016.
 */
public class Parser {

    private Graph graph;

    public Parser() {
        graph = new Graph();
    }

    public Graph parser(String pathToGraph) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(openFile(pathToGraph)));

        String str;
        while ((str = in.readLine()) != null) {
            if (str.startsWith("p")) {
                int indexOfSecondSubSpace = str.indexOf(" ", 2);
                int numberOfVertices = Integer.
                        parseInt(str.substring(indexOfSecondSubSpace + 1, str.indexOf(" ", indexOfSecondSubSpace + 1)));
                graph.setVertices(numberOfVertices);
            } else if (str.startsWith("e")) {
                int firstVertex = Integer.parseInt(str.substring(2, str.indexOf(" ", 3)));
                int secondVertex = Integer.parseInt(str.substring(str.lastIndexOf(" ") + 1, str.length()));
                graph.getEdges().add(new Edge(firstVertex, secondVertex));
            }
        }
        return graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    private InputStream openFile(String path) {
        InputStream is = this.getClass().getResourceAsStream(path);
        return is;
    }
}

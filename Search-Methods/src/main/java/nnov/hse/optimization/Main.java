package nnov.hse.optimization;

import nnov.hse.optimization.methods.LocalSearch;
import nnov.hse.optimization.parser.Graph;
import nnov.hse.optimization.parser.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

            List<Integer> vertices = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                vertices.clear();
                vertices.add(7);
                for (int i = 0; i < 100; i++) {
                    vertices = localSearch.getClique(vertices);
                }
                System.out.println("Clique is is " + vertices + "\nSize of clique: " + vertices.size());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package depthFirstSearch;

import adjacencyList.Graph;
import adjacencyList.Node;

public class DepthFirstSearch {

    public static void depthFirstSearch(Graph graph, int source) {
        boolean[] visited = new boolean[graph.getNumVertices()];
        int[] parent = new int[graph.getNumVertices()];

        System.out.print(source + " ");
        depthFirstSearch(graph.getNode(source),visited,parent);
    }

    public static void depthFirstSearch(Node source, boolean[] visited, int[] parent) {
        if(source!= null && !visited[source.getVertex()]) {
            visited[source.getVertex()] = true;
            for (Node node: source.getAdjacentVertices()) {
                if(!visited[node.getVertex()]) {
                    parent[node.getVertex()] = source.getVertex();
                    System.out.print(node.getVertex() + " ");
                    depthFirstSearch(node, visited, parent);
                    visited[node.getVertex()] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.display();
        System.out.println();
        depthFirstSearch(graph, 2); // 2 0 1 3
    }
}

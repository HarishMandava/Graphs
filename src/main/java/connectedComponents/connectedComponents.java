package connectedComponents;

import adjacencyList.Graph;
import adjacencyList.Node;

public class connectedComponents {

    public static void connectedComponents(Graph graph) {
        boolean[] visited = new boolean[graph.getNumVertices()];
        int[] connected = new int[graph.getNumVertices()];
        int count = 1;

        count = connectedComponents(graph, visited, connected, count);
        for (int i = 1; i <= count; i++) {
            System.out.println();
            for (int j = 0; j < connected.length; j++) {
                if (connected[j] == i) {
                    System.out.print(j + " ");
                }
            }
//            System.out.println();
        }
    }

    public static int connectedComponents(Graph graph, boolean[] visited, int[] connected, int count) {
        for (Node node: graph.getAdjacencyList()) {
            if(!visited[node.getVertex()]) {
                depthFirstSearch(node, visited, connected, count);
                count++;
            }
        }

        return --count;
    }

    public static void depthFirstSearch(Node source, boolean[] visited, int[] connected, int count) {
        if(source!=null && !visited[source.getVertex()]) {
            visited[source.getVertex()] = true;
            connected[source.getVertex()] = count;
            for (Node node : source.getAdjacentVertices()) {
                if (!visited[node.getVertex()]) {
                    depthFirstSearch(node, visited, connected, count);
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.display();
        connectedComponents(graph); // 0 1, 2 3 4
    }
}

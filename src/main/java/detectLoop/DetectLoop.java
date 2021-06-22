package detectLoop;

import adjacencyList.Graph;
import adjacencyList.Node;

public class DetectLoop {

    public static boolean hasLoop(Graph graph) {
        boolean[] visited = new boolean[graph.getNumVertices()];
        for (Node node: graph.getAdjacencyList()) {
          if(hasLoop(node, visited))
              return true;
        }
        return false;
    }

    public static boolean hasLoop(Node source, boolean[] visited) {
        if(visited[source.getVertex()]) {
            return true;
        }
        visited[source.getVertex()] = true;
        for (Node node : source.getAdjacentVertices()) {
            if (hasLoop(node, visited))
                return true;
        }
        visited[source.getVertex()] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
        graph.addEdge(1, 2);

//        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
//        graph.addEdge(3, 3);
        System.out.println(hasLoop(graph));
    }
}

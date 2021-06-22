package breadthFirstSearch;

import adjacencyList.Graph;
import adjacencyList.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void breadthFirstSearch(Graph graph, int source) {
        boolean[] visited = new boolean[graph.getNumVertices()];

        System.out.print(source + " ");
        breadthFirstSearch(graph.getNode(source), visited);
    }

    public static void breadthFirstSearch(Node source, boolean[] visited) {
        if (source != null && !visited[source.getVertex()]) {
            visited[source.getVertex()] = true;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(source);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                for(Node temp : node.getAdjacentVertices()) {
                    if(!visited[temp.getVertex()]) {
                        System.out.print(temp.getVertex() + " ");
                        visited[temp.getVertex()] = true;
                        queue.offer(temp);
                    }
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
        breadthFirstSearch(graph, 2); // 2 0 3 1
    }
}

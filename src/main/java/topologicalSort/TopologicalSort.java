package topologicalSort;

import adjacencyList.Graph;
import adjacencyList.Node;

import java.util.Stack;

public class TopologicalSort {

    public static Stack<Integer> topologicalSort(Graph graph) {
        Stack<Integer> topologicalOrder = new Stack<>();
        boolean[] visited = new boolean[graph.getNumVertices()];
        for (Node node: graph.getAdjacencyList()) {
            topologicalSort(node, topologicalOrder, visited);
        }
        return topologicalOrder;
    }

    public static void topologicalSort(Node source, Stack<Integer> topologicalOrder, boolean[] visited) {
        if(!visited[source.getVertex()]) {
            visited[source.getVertex()] = true;
            for (Node node: source.getAdjacentVertices()) {
                topologicalSort(node, topologicalOrder, visited);
            }
            System.out.println(source.getVertex() );
            topologicalOrder.push(source.getVertex());
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        Stack<Integer> stack = topologicalSort(graph);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

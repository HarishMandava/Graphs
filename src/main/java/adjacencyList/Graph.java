package adjacencyList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {

    private final List<Node> adjacencyList = new ArrayList<>();

    public List<Node> getAdjacencyList(int vertex) {
        return adjacencyList.stream()
                .filter(node -> node.getVertex() == vertex)
                .flatMap(node -> node.getAdjacentVertices().stream())
                .collect(Collectors.toList());
    }

    public void addEdge(int a, int b) {
        Node nodeA = adjacencyList.stream()
                .filter(node -> node.getVertex() == a)
                .findAny().orElse(new Node(a));
        Node nodeB = adjacencyList.stream()
                .filter(node -> node.getVertex() == b)
                .findAny().orElse(new Node(b));
        nodeA.getAdjacentVertices().add(nodeB);
        if(!adjacencyList.contains(nodeA)) {
            adjacencyList.add(nodeA);
        }
        if (!adjacencyList.contains(nodeB)) {
            adjacencyList.add(nodeB);
        }
    }

    public int getNumVertices() {
        return adjacencyList.size();
    }

    public void display() {
        for (Node node : adjacencyList) {
            System.out.print(node.getVertex() + " -> ");
            for (Node temp : node.getAdjacentVertices()) {
                System.out.print(temp.getVertex() + " ");
            }
            System.out.println();
        }
    }

    public Node getNode(int vertex) {
        return adjacencyList.stream()
                .filter(node -> node.getVertex() == vertex)
                .findAny().orElse(null);
    }

    public List<Node> getAdjacencyList() {
        return adjacencyList;
    }
}

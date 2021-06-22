package adjacencyList;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int vertex;
    private List<Node> adjacentVertices;

    public Node(int vertex) {
        this.vertex = vertex;
        this.adjacentVertices = new ArrayList<>();
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public List<Node> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(List<Node> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }
}

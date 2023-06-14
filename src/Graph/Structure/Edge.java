package Graph.Structure;

public class Edge {
    Node adjacentNode;
    int weight;

    public Edge(Node adjacentNode, int weight) {
        this.adjacentNode = adjacentNode;
        this.weight = weight;
    }
}

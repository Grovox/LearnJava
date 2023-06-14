package Graph.Structure;

public class Edge {
    public Node adjacentNode;
    public int weight;

    public Edge(Node adjacentNode, int weight) {
        this.adjacentNode = adjacentNode;
        this.weight = weight;
    }
}

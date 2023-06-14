package Graph.Structure;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Node {
    int value;
    LinkedHashSet<Edge> edges = new LinkedHashSet<>();
    LinkedHashMap<Node, Edge> parents = new LinkedHashMap<>();

    public Node(int value) {
        this.value = value;
    }
}

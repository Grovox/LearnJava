package Graph;

import Graph.Structure.Edge;
import Graph.Structure.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

import static Graph.Generation.addOrGetNode;

class PathNode{
    public Node node;
    public PathNode parent;
    public PathNode(Node node, PathNode parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class FindingShortestPath {
    static PathNode getShortestPath(Node start, Node end){
    HashSet<Node> visitingOrPassed = new HashSet<>();
    LinkedList<PathNode> queue = new LinkedList<>();
    queue.addLast(new PathNode(start,null));
    visitingOrPassed.add(start);
    while (!queue.isEmpty()){
        PathNode pathNode = queue.removeFirst();
        if(pathNode.node == end)return pathNode;
        for (Edge edge : pathNode.node.edges){
            if (visitingOrPassed.contains(edge.adjacentNode)) continue;
            if (edge.adjacentNode == end){
                return new PathNode(edge.adjacentNode, pathNode);
            }
            queue.addLast(new PathNode(edge.adjacentNode,pathNode));
            visitingOrPassed.add(pathNode.node);
        }
    }
    return null;
    }

    public static void main(String[] args) {
        //    Пример
        // от | до | вес
        //  7 |  2 |  1
        //  7 |  6 |  1
        //  7 |  5 |  1
        //  6 |  4 |  1
        //  4 |  9 |  1
        //  2 |  1 |  1
        //  1 |  9 |  1
        //  5 |  9 |  1
        //  8 | 10 |  1
        int[][] graphData = new int[9][3];
        graphData[0][0] = 7; graphData[0][1] = 2; graphData[0][2] = 1;
        graphData[1][0] = 7; graphData[1][1] = 6; graphData[1][2] = 1;
        graphData[2][0] = 7; graphData[2][1] = 5; graphData[2][2] = 1;
        graphData[3][0] = 6; graphData[3][1] = 4; graphData[3][2] = 1;
        graphData[4][0] = 4; graphData[4][1] = 9; graphData[4][2] = 1;
        graphData[5][0] = 2; graphData[5][1] = 1; graphData[5][2] = 1;
        graphData[6][0] = 1; graphData[6][1] = 9; graphData[6][2] = 1;
        graphData[7][0] = 5; graphData[7][1] = 9; graphData[7][2] = 1;
        graphData[8][0] = 8; graphData[8][1] = 10; graphData[8][2] = 1;

        HashMap<Integer, Node> graph = new HashMap<>();
        for (int[] row : graphData){
            Node node = addOrGetNode(graph, row[0]);
            Node adjacentNode = addOrGetNode(graph, row[1]);
            if(adjacentNode == null) continue;
            Edge edge = new Edge(adjacentNode, row[2]);
            node.edges.add(edge);
            adjacentNode.parents.put(node, edge);
        }

        //Поиск крачайего пути
        Node node1 = graph.get(7);
        Node node2 = graph.get(9);
        PathNode endNode = getShortestPath(node1, node2);

        LinkedList<Node> part = new LinkedList<>();
        while (endNode != null){
            part.addFirst(endNode.node);
            endNode = endNode.parent;
        }

        System.out.println(part.stream().map(s -> s.value).collect(Collectors.toList()));
    }
}

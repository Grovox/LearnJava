package Graph;

import Graph.Structure.Edge;
import Graph.Structure.Node;

import java.util.HashMap;
import java.util.Scanner;

public class Generation {
    public static Node addOrGetNode(HashMap<Integer, Node> graph, int value){
        if(value == -1) return null;
        if(graph.containsKey(value)) return graph.get(value);
        Node node = new Node(value);
        graph.put(value,node);
        return node;
    }

    public static void main(String[] args) {
        //    Пример
        // от | до | вес
        //  7 |  5 |  1
        //  7 |  6 |  1
        //  6 |  4 |  1
        //  8 | -1 |  1
        //  5 |  9 |  1
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] graphData = new int[n][3];
        for (int i = 0; i < n; i++){
            graphData[i][0] = scanner.nextInt();
            graphData[i][1] = scanner.nextInt();
            graphData[i][2] = scanner.nextInt();
            scanner.nextLine();
        }

        HashMap<Integer, Node> graph = new HashMap<>();
        for (int[] row : graphData){
            Node node = addOrGetNode(graph, row[0]);
            Node adjacentNode = addOrGetNode(graph, row[1]);
            if(adjacentNode == null) continue;
            Edge edge = new Edge(adjacentNode, row[2]);
            node.edges.add(edge);
            adjacentNode.parents.put(node, edge);
        }

        System.out.println(graph.keySet());
    }
}

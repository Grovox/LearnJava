package Graph;

import Graph.Structure.Edge;
import Graph.Structure.Node;
import java.util.*;
import java.util.stream.Collectors;

import static Graph.Generation.addOrGetNode;

public class FindingPath {
    static boolean getPath(Node start, Node end, HashSet<Node> passed, LinkedList<Node> path){
        if(start == end) {
            path.addFirst(start);
            return true;
        }
        passed.add(start);
        for (Edge edge : start.edges){
            if(!passed.contains(edge.adjacentNode)){
                if(getPath(edge.adjacentNode,end,passed,path)){
                    path.addFirst(start);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //    Пример
        // от | до | вес
        //  7 |  2 |  1
        //  7 |  6 |  1
        //  7 |  5 |  1
        //  6 |  4 |  1
        //  2 |  1 |  1
        //  5 |  9 |  1
        //  8 | 10 |  1
        int[][] graphData = new int[7][3];
        graphData[0][0] = 7; graphData[0][1] = 2; graphData[0][2] = 1;
        graphData[1][0] = 7; graphData[1][1] = 6; graphData[1][2] = 1;
        graphData[2][0] = 7; graphData[2][1] = 5; graphData[2][2] = 1;
        graphData[3][0] = 6; graphData[3][1] = 4; graphData[3][2] = 1;
        graphData[4][0] = 2; graphData[4][1] = 1; graphData[4][2] = 1;
        graphData[5][0] = 5; graphData[5][1] = 9; graphData[5][2] = 1;
        graphData[6][0] = 8; graphData[6][1] = 10; graphData[6][2] = 1;

        HashMap<Integer, Node> graph = new HashMap<>();
        for (int[] row : graphData){
            Node node = addOrGetNode(graph, row[0]);
            Node adjacentNode = addOrGetNode(graph, row[1]);
            if(adjacentNode == null) continue;
            Edge edge = new Edge(adjacentNode, row[2]);
            node.edges.add(edge);
            adjacentNode.parents.put(node, edge);
        }

        //Поиск пути
        Node node1 = graph.get(7);
        Node node2 = graph.get(9);

        LinkedList<Node> path = new LinkedList<>();
        HashSet<Node> passed = new HashSet<>();
        System.out.println(getPath(node1, node2, passed, path));
        System.out.println(path.stream().map(s -> s.value).collect(Collectors.toList()));

        System.out.println("\n-----------------\n");

        LinkedList<Node> path2 = new LinkedList<>();
        HashSet<Node> passed2 = new HashSet<>();
        Node node3 = graph.get(10);
        System.out.println(getPath(node1, node3, passed2, path2));
        System.out.println(path2.stream().map(s -> s.value).collect(Collectors.toList()));
    }
}

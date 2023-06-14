package Graph;

import Graph.Structure.Edge;
import Graph.Structure.Node;

import java.util.*;
import java.util.stream.Collectors;

import static Graph.Generation.addOrGetNode;

public class FindingPaths {
    static void getPathAll(Node start, Node end, LinkedHashSet<Node> passed, List<LinkedHashSet<Node>> paths){
        if(start == end) {
            paths.add((LinkedHashSet<Node>) passed.clone());
            paths.get(paths.size() - 1).add(end);
        }
        passed.add(start);
        for (Edge edge : start.edges){
            if(!passed.contains(edge.adjacentNode)){
                getPathAll(edge.adjacentNode, end, passed, paths);
            }
        }
        passed.remove(start);
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

        //Поиск пути
        Node node1 = graph.get(7);
        Node node2 = graph.get(9);

        List<LinkedHashSet<Node>> paths = new ArrayList<>();
        LinkedHashSet<Node> passed = new LinkedHashSet<>();
        getPathAll(node1, node2, passed, paths);

        for(LinkedHashSet<Node> path : paths){
            System.out.println(path.stream().map(s -> s.value).collect(Collectors.toList()));
        }

    }
}

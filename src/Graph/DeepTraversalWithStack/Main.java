package Graph.DeepTraversalWithStack;

import Graph.Structure.Edge;
import Graph.Structure.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

import static Graph.Generation.Main.addOrGetNode;

public class Main {
    static void DNF(Node node, HashSet<Node> passed){
        System.out.println(node.value);

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (stack.size() != 0){
            node = stack.peek();
            if (!passed.contains(node)){
                System.out.println(node.value);

                passed.add(node);
            }
            boolean hasChildren = false;
            for (Edge edge : node.edges){
                if(!passed.contains(edge.adjacentNode)){
                    stack.push(edge.adjacentNode);
                    hasChildren = true;
                    break;
                }
            }
            if(!hasChildren){
                stack.pop();
            }
        }
    }

    static void DFSWrap(HashMap<Integer,Node> graph, int top){
        HashSet<Node> passed = new HashSet<>();
        DNF(graph.get(top),passed);
        for (Map.Entry<Integer,Node> graphEntry : graph.entrySet()){
            Node node = graphEntry.getValue();
            if(!passed.contains(node)){
                DNF(node,passed);
            }
        }
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

        //перебор в глубину через рекурсию
        DFSWrap(graph, 7);
    }
}

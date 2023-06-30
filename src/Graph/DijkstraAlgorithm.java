package Graph;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstraAlgorithm {
    static LinkedList<Node> getShortestPath(HashMap<Character, Node> graph, Node start, Node end){
        HashSet<Node> unprocessedNodes = new HashSet<>();
        HashMap<Node, Integer> timeToNodes = new HashMap<>();
        initHashTable(start, graph, unprocessedNodes, timeToNodes);
        calculateTimeToEachNode(unprocessedNodes,timeToNodes);
        if (timeToNodes.get(end) == Integer.MAX_VALUE) return null;
        return getShortestPath(start, end, timeToNodes);
    }

    static LinkedList<Node> getShortestPath(Node start, Node end, HashMap<Node, Integer> timeToNode){
        LinkedList<Node> path = new LinkedList<>();
        Node node = end;
        while (node != start){
            int minTimeToNode = timeToNode.get(node);
            path.addFirst(node);
            for (Map.Entry<Node,Edge> parentAndEdge : node.parents.entrySet()){
                Node parent = parentAndEdge.getKey();
                Edge parentEdge = parentAndEdge.getValue();
                if(!timeToNode.containsKey(parent)) continue;
                boolean prevNodeFound = (parentEdge.weight + timeToNode.get(parent)) == minTimeToNode;
                if (prevNodeFound){
                    timeToNode.remove(node);
                    node = parent;
                    break;
                }
            }
        }
        path.addFirst(node);
        return path;
    }

    static void calculateTimeToEachNode(HashSet<Node> unprocessedNodes, HashMap<Node, Integer> timeToNodes) {
        while (!unprocessedNodes.isEmpty()){
            Node node = getNodeWithMinTimeToIt(unprocessedNodes, timeToNodes);
            if(timeToNodes.get(node) == Integer.MAX_VALUE) return;
            for (Edge edge : node.edges){
                Node adjacentNode = edge.adjacentNode;
                if (unprocessedNodes.contains(adjacentNode)){
                    int timeToCheck = timeToNodes.get(node) + edge.weight;
                    if(timeToCheck < timeToNodes.get(adjacentNode))
                        timeToNodes.put(adjacentNode, timeToCheck);
                }
            }
            unprocessedNodes.remove(node);
        }
    }

    static Node getNodeWithMinTimeToIt(HashSet<Node> unprocessedNodes, HashMap<Node, Integer> timeToNodes){
        Node nodeWithMinTimeToIt = null;
        int minTime = Integer.MAX_VALUE;
        for (Node node : unprocessedNodes){
            int time = timeToNodes.get(node);
            if(time < minTime){
                minTime = time;
                nodeWithMinTimeToIt = node;
            }
        }
        return nodeWithMinTimeToIt;
    }

    static void initHashTable(Node start, HashMap<Character, Node> graph,
                              HashSet<Node> unprocessedNodes, HashMap<Node, Integer> timeToNodes){
        for (Map.Entry<Character, Node> mapEntry : graph.entrySet()){
            Node node = mapEntry.getValue();
            unprocessedNodes.add(node);
            timeToNodes.put(node, Integer.MAX_VALUE);
        }
        timeToNodes.put(start, 0);
    }

    public static Node addOrGetNode(HashMap<Character, Node> graph, char value){
        if(graph.containsKey(value)) return graph.get(value);
        Node node = new Node(value);
        graph.put(value, node);
        return node;
    }

    public static void main(String[] args) {
        //    Пример
        // от | до | вес
        //  A |  C |  7
        //  A |  B |  3
        //  C |  D |  5
        //  B |  D |  8
        //  B |  E |  1
        //  E |  F |  5
        //  F |  D |  1
        List<DataG> graphData = new ArrayList<>();
        graphData.add(new DataG('A', 'C', 7));
        graphData.add(new DataG('A', 'B', 3));
        graphData.add(new DataG('C', 'D', 5));
        graphData.add(new DataG('B', 'D', 8));
        graphData.add(new DataG('B', 'E', 1));
        graphData.add(new DataG('E', 'F', 5));
        graphData.add(new DataG('F', 'D', 1));

        HashMap<Character, Node> graph = new HashMap<>();
        for (DataG row : graphData){
            Node node = addOrGetNode(graph, row.whereFrom);
            Node adjacentNode = addOrGetNode(graph, row.where);
            if(adjacentNode == null) continue;
            Edge edge = new Edge(adjacentNode, row.weight);
            node.edges.add(edge);
            adjacentNode.parents.put(node, edge);
        }

        // Поиск самого быстрого пути
        LinkedList<Node> path = getShortestPath(graph, addOrGetNode(graph, 'A'), addOrGetNode(graph, 'D'));

        System.out.println(path.stream().map(s -> s.value).collect(Collectors.toList()));
    }
}

class Node{
    public char value;
    public LinkedHashSet<Edge> edges = new LinkedHashSet<>();
    public LinkedHashMap<Node, Edge> parents = new LinkedHashMap<>();

    public Node(char value) {
        this.value = value;
    }
}

class Edge {
    public Node adjacentNode;
    public int weight;

    public Edge(Node adjacentNode, int weight) {
        this.adjacentNode = adjacentNode;
        this.weight = weight;
    }
}

class DataG{
    public DataG(char whereFrom, char where, int weight) {
        this.whereFrom = whereFrom;
        this.where = where;
        this.weight = weight;
    }

    char whereFrom;
    char where;
    int weight;
}
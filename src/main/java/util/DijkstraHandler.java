package util;

import classes.Edge;
import classes.Node;
import classes.meta.Graph;

import java.util.*;

public class DijkstraHandler {

    public static Map<Node, Node> getShortestPath(Graph graph, Node start) {
        // Initialize
        Set<Node> queue = new HashSet<>(graph.getNodes());
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> predecessors = new HashMap<>();

        for (Node node : graph.getNodes()) {
            distances.put(node, Integer.MAX_VALUE);
            predecessors.put(node, null);
        }

        distances.put(start, 0);
        // End

        // Loop
        while (!queue.isEmpty()) {
            Node node = getClosetVertex(queue, distances);
            if (node == null) continue;

            queue.remove(node);

            for (Edge edge : node.getEdges()) {
                Node child = edge.getChild(node);
                if (!queue.contains(child)) continue;

                // Distance Update
                int distance = distances.get(node) + edge.getDistance();
                if (distance >= distances.get(child)) continue;

                predecessors.put(child, node);
                distances.put(child, distance);
                // End
            }
        }
        // End

        return predecessors;
    }

    public static List<Node> createShortestPath(Node destination, Map<Node, Node> predecessors) {
        List<Node> path = new ArrayList<>();
        path.add(destination);

        Node node = destination;
        while (predecessors.get(node) != null) {
            node = predecessors.get(node);
            path.add(0, node);
        }

        return path;
    }

    private static Node getClosetVertex(Set<Node> queue, Map<Node, Integer> distances) {
        return queue.stream()
            .min(Comparator.comparingInt(distances::get))
            .orElse(null);
    }

}

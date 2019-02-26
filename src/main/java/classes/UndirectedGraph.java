package classes;


import classes.meta.Graph;
import util.Visualizer;

import java.util.stream.Collectors;

public class UndirectedGraph extends Graph {

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public boolean isEdgeInEdges(Node from, Node to) {
        return getEdges().stream()
            .anyMatch(edge ->
                edge.getFrom().equals(from) && edge.getTo().equals(to) ||
                edge.getFrom().equals(to) && edge.getTo().equals(from));
    }

    @Override
    public String toString() {
        return "graph G {\n" +
                getEdges().stream()
                    .map(Visualizer::toStringUnDirected)
                    .collect(Collectors.joining()) +
            "}";
    }

}

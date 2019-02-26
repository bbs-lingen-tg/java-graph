package classes;

import classes.meta.Graph;
import util.Visualizer;

import java.util.stream.Collectors;

public class DirectedGraph extends Graph {

	@Override
	public boolean isDirected() {
		return true;
	}

	@Override
	public boolean isEdgeInEdges(Node from, Node to) {
        return getEdges().stream()
			.anyMatch(edge -> edge.getFrom().equals(from) && edge.getTo().equals(to));
	}

	@Override
	public String toString() {
		return "digraph G {\n" +
				getEdges().stream()
					.map(Visualizer::toStringDirected)
					.collect(Collectors.joining()) +
			"}";
	}

}

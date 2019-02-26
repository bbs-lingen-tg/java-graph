package classes.meta;

import classes.Edge;
import classes.Node;

import java.util.HashSet;
import java.util.Set;

public abstract class Graph {

	private final Set<Edge> edges = new HashSet<>();
	private final Set<Node> nodes = new HashSet<>();

	public boolean isDirected() {
		return false;
	}

	public Set<Edge> getEdges() {
		return edges;
	}

	public Set<Node> getNodes() {
		return nodes;
	}

	public Graph addEdge(Node from, Node to, int distance) {
		Edge edge = new Edge(from, to, distance);
		edges.add(edge);

		from.addEdge(edge);
		to.addEdge(edge);

		return this;
	}

	public boolean isEdgeInEdges(Node from, Node to) {
		return false;
	}

	public Node createNode(String name) {
		Node existingNode = getNodeFromName(name);
		if (existingNode != null) return existingNode;

		Node node = new Node(name);
		nodes.add(node);

		return node;
	}

	private Node getNodeFromName(String name) {
		return nodes.stream()
			.filter(node -> node.getName().equals(name))
			.findFirst()
			.orElse(null);
	}

}

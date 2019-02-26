package classes;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private final String name;
	private final List<Edge> edges = new ArrayList<>();

	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

    public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public List<Edge> getEdges() {
		return edges;
	}

	@Override
	public String toString() {
		return
			"Node{" +
				"name=" + name +
			"}";
	}


}

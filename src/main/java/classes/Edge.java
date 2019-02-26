package classes;

public class Edge {

	private final Node from;
	private final Node to;
	private final int distance;

	public Edge(Node from, Node to, int distance) {
		this.from = from;
		this.to = to;
		this.distance = distance;
	}

	public Node getFrom() {
		return from;
	}

	public Node getTo() {
		return to;
	}

	public Node getChild(Node node) {
		return from.equals(node)
			? to
			: from;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return
			"Edge {\n" +
				"nodes=" + from.getName() + " -> " + to.getName() +
			"\n}\n";
	}

}

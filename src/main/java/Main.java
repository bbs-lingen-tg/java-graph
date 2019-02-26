import classes.Node;
import classes.UndirectedGraph;
import classes.meta.Graph;
import util.DijkstraHandler;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		runUndirectedGraphExample();
	}

	private static void runUndirectedGraphExample() {
		Graph graph = new UndirectedGraph();

		Node lingen = graph.createNode("Lingen");
		Node rheine = graph.createNode("Rheine");
		Node osnabrueck = graph.createNode("Osnabrück");
		Node muenster = graph.createNode("Münster");
		Node oldenburg = graph.createNode("Oldenburg");
		Node wilhelmshaven = graph.createNode("Wilhelmshaven");
		Node leer = graph.createNode("Leer");

		graph
			.addEdge(lingen, rheine, 5)
			.addEdge(osnabrueck, rheine, 3)
			.addEdge(muenster, rheine, 10)
			.addEdge(oldenburg, osnabrueck, 7)
			.addEdge(oldenburg, wilhelmshaven, 9)
			.addEdge(lingen, leer, 10)
			.addEdge(wilhelmshaven, leer, 2);

		System.out.println(graph);

		Map<Node, Node> predecessors = DijkstraHandler.getShortestPath(graph, lingen);
		List<Node> path = DijkstraHandler.createShortestPath(wilhelmshaven, predecessors);
		System.out.println(path);
	}

}

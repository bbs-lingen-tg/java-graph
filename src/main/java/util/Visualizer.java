package util;

import classes.Edge;

public class Visualizer {

	public static String toStringUnDirected(Edge edge) {
		return toString(edge,false);
	}

	public static String toStringDirected(Edge edge) {
		return toString(edge,true);
	}

	private static String toString(Edge edge, boolean isDirected) {
		return "\t" +
			"\"" + edge.getFrom().getName() + "\"" +
			(isDirected ? " -> " : " -- " ) +
			"\"" + edge.getTo().getName() + "\"" +
			"[label=\"" + edge.getDistance() + "\"];\n";
	}

}

package apps;

import structures.*;
import java.util.ArrayList;

public class MST {

	/**
	 * Initializes the algorithm by building single-vertex partial trees
	 *
	 * @param graph Graph for which the MST is to be found
	 * @return The initial partial tree list
	 */
	public static PartialTreeList initialize(Graph graph) {

		PartialTreeList list = new PartialTreeList();
		Vertex[] vertex = graph.vertices;
		PartialTree Tree;
		boolean[] visited = new boolean[vertex.length];
		PartialTree.Arc arc = null;
		int counter = 0;

		for (int i = 0; i < vertex.length; i++) {
			Vertex.Neighbor neighbor = vertex[i].neighbors;
			Tree = new PartialTree(vertex[i]);
			visited[i] = true;
			System.out.println(vertex[i]);
			MinHeap<PartialTree.Arc> P = Tree.getArcs(); // associating with P.

			while (neighbor != null) {
				arc = new PartialTree.Arc(vertex[i], neighbor.vertex, neighbor.weight);
				P.insert(arc);
				P.siftDown(counter);
				neighbor = neighbor.next;
			}
			if (visited[i] == true) {
				list.append(Tree);
			}
			counter++;
		}

		return list;
	}

	/**
	 * Executes the algorithm on a graph, starting with the initial partial tree list
	 * 
	 * @param ptlist Initial partial tree list
	 * @return Array list of all arcs that are in the MST - sequence of arcs is irrelevant
	 */
	public static ArrayList<PartialTree.Arc> execute(PartialTreeList ptlist) {
		
		/* COMPLETE THIS METHOD */

		return null;
	}
}

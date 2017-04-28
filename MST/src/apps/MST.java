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
		PartialTree tree;
		boolean[] visited = new boolean[vertex.length];
		PartialTree.Arc arc;
		int counter = 0;

		for (int i = 0; i < vertex.length; i++) {
			Vertex.Neighbor neighbor = vertex[i].neighbors;
			tree = new PartialTree(vertex[i]);
			visited[i] = true;
			//System.out.println("Vertex[" + i + "]: " + vertex[i]);
			MinHeap<PartialTree.Arc> pTreeHeap = tree.getArcs(); // associating with P.
			while (neighbor != null) {
				arc = new PartialTree.Arc(vertex[i], neighbor.vertex, neighbor.weight);
				//System.out.println("Arc: " + arc);
				pTreeHeap.insert(arc);
				pTreeHeap.siftDown(counter);
				//System.out.println("pTreeHeap: " + pTreeHeap);
				neighbor = neighbor.next;
			}
			if (visited[i]) {
				list.append(tree);
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

		ArrayList<PartialTree.Arc> arrayList = new ArrayList();

		while (ptlist.size() > 1) {
			PartialTree firstRemoval = ptlist.remove();
			PartialTree.Arc PQX;
			PartialTree.Arc storeArc = firstRemoval.getArcs().getMin();
			Vertex v2 = storeArc.v2;
			while(compare(v2, firstRemoval) == true) {
				storeArc = firstRemoval.getArcs().getMin();
				v2 = storeArc.v2;
			}
			PQX = firstRemoval.getArcs().deleteMin();
			PartialTree PTY = ptlist.removeTreeContaining(PQX.v2);
			firstRemoval.merge(PTY);
			arrayList.add(PQX);
			ptlist.append(firstRemoval);
		}
		return arrayList;
	}

	private static boolean compare(Vertex v2, PartialTree PTX)
	{
		while(v2 != null)
		{
			if(PTX.getRoot() == v2)
			{
				return true;
			}
			if(v2.equals(v2.parent))
			{
				return false;
			}
			v2 = v2.parent;
		}
		return false;
	}
}

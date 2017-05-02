package structures;

import apps.MST;
import apps.PartialTree;
import apps.PartialTreeList;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Sasha on 4/25/17.
 */
public class MSTDriver {

    public static void main(String[] args) {
        try {
            Graph graph = new Graph("graph2.txt");
            System.out.println("Created graph:");
            graph.print();
            System.out.println();

            PartialTreeList list = MST.initialize(graph);
            System.out.println("Initialized graph:");
            printTreeList(list);
            System.out.println();

            Iterator<PartialTree> iterator = list.iterator();
            iterator.next();
            iterator.next();
            iterator.next();
            iterator.next();

            PartialTree tree = list.removeTreeContaining(iterator.next().getRoot());
            //iterator.next();
            System.out.println("Removed tree: " + tree);
            printTreeList(list);

        } catch (IOException exception) { System.out.print("Excepetion encountered"); }
    }

    private static void printTreeList(PartialTreeList list) {
        for (PartialTree tree: list) {
            System.out.println(tree);
        }
    }
}

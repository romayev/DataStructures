import java.util.ArrayList;

/**
 * Created by Sasha on 3/17/17.
 */
public class BST<T extends Comparable<T>> {
    BSTNode<T> root;
    int size;

    public void insert(T target) {
        insert2(target);
    }
    
    public void insert1(T target)
            throws IllegalArgumentException {

        BSTNode ptr = root, prev = null;
        int c = 0;
        while (ptr != null) {
            c = target.compareTo((T) ptr.data);
            if (c == 0) {
                throw new IllegalArgumentException("Duplicate key");
            }
            prev = ptr;
            ptr = c < 0 ? ptr.left : ptr.right;
        }
        BSTNode tmp = new BSTNode(target);
        size++;
        if (root == null) {
            root = tmp;
            return;
        }
        if (c < 0) {
            prev.left = tmp;
        } else {
            prev.right = tmp;
        }
    }

    public void insert2(T target) throws IllegalArgumentException {
        root = insertNode(target, root);
        size++;
    }

    private BSTNode<T> insertNode(T target, BSTNode<T> node) throws IllegalArgumentException {
        if (node == null) {
            return new BSTNode<T>(target);
        }
        int compare = target.compareTo(node.data);
        if (compare == 0) {
            throw new IllegalArgumentException("same");
        }
        if (compare < 0) {
            node.left = insertNode(target, node.left);
        } else {
            node.right = insertNode(target, node.right);
        }
        return node;
    }


    public void print() {
        printNode(root);
        BTreePrinter.printNode(root);
    }

    private void printNode(BSTNode<T> node) {
        if (node == null) return;
        System.out.println(node);
        printNode(node.left);
        printNode(node.right);
    }

    
    public <T extends Comparable<T>> void keysInRange(BSTNode<T> root, T min, T max, ArrayList<T> result) {
        if (root == null) {
            return;
        }
        int minCompare = min.compareTo(root.data);
        int maxCompare = max.compareTo(root.data);

        if (minCompare <= 0 && maxCompare >= 0) {
            result.add(root.data);
        }
        if (maxCompare > 0) {
            keysInRange(root.right, min, max, result);
        }
        if (minCompare < 0) {
            keysInRange(root.left, min, max, result);
        }
    }


}



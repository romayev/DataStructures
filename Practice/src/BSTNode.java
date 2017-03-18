
public class BSTNode<T extends Comparable<?>> {
    T data;
    BSTNode<T> left, right;
    public BSTNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public String toString() {
        String leftString = left == null ? "null" : left.data.toString();
        String righttString = right == null ? "null" : right.data.toString();
        return "[" + leftString + "]" + data.toString() + "[" + righttString + "]";
    }
}
import java.util.NoSuchElementException;

/**
 * Created by Sasha on 2/25/17.
 */
public class Stack<T> {

    private NodeLinkedList<T> linkedList;
    private int size;

    public Stack() {
        linkedList = new NodeLinkedList<T>();
    }

    public void push(T item) {
        linkedList.addToFront(item);
        size ++;
    }

    public T pop() throws NoSuchElementException {
        T node = linkedList.deleteFirstNode();
        if (node == null) {
            throw new NoSuchElementException();
        } else {
            size--;
            return node;
        }
    }

    public void print() {
        linkedList.print();

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() { return size == 0; }
}

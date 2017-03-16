import java.util.NoSuchElementException;

public class Queue<T> {
    private NodeLinkedList<T> linkedList;
    private int size;

    public Queue() {
        linkedList = new NodeLinkedList<T>();
    }

    public void enqueue(T item) {
        linkedList.addToEnd(item);
        size++;
        //add to end

    }
    
    public T dequeue() throws NoSuchElementException {
        T node = linkedList.deleteFirstNode();
        if (node == null) {
            throw new NoSuchElementException();
        } else {
            size--;
            return node;
        }
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
    public void evenSplit() {

    }
    public int size() {
        return size;
    }
}

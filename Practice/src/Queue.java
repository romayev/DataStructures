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
    }

    public T peek() {
        return linkedList.returnFront();
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

    public void print() {
        linkedList.print();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Queue<T> evenSplit() {
        Queue<T> secondQueue = new Queue<T>();
        int boundary = size;
        for (int i = 0; i < boundary; i++) {
            T value = dequeue();
            if (i % 2 == 0) {
                enqueue(value);
            } else {
                secondQueue.enqueue(value);
            }
        }
        return secondQueue;
    }

    public int size() {
        return size;
    }
}

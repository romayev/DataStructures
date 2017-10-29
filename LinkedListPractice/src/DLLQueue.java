import java.util.NoSuchElementException;

/**
 * Created by Sasha on 10/28/17.
 */
public class DLLQueue <T> {
    private CLL<T> CLL;
    private int size;

    public DLLQueue() {
        CLL = new CLL<T>();
    }

    public void enqueue(T item) {
        CLL.addToEnd(item);
        size++;
    }

    public T peek() {
        return (T) CLL.front;
    }

    public T dequeue() throws NoSuchElementException {
        T node = CLL.deleteFirstNode();
        if (node == null) {
            throw new NoSuchElementException();
        } else {
            size--;
            return node;
        }
    }

    public void print() {
        CLL.printList();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

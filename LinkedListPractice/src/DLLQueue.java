import java.util.NoSuchElementException;

/**
 * Created by Sasha on 10/28/17.
 */
public class DLLQueue <T> {
    private CLL<T> CLL;
    private int size;

    public DLLQueue(T[] array) {
        CLL = new CLL<T>(array);
        size = array.length;
    }

    public void enqueue(T item) {
        CLL.addToEnd(item);
        size++;
    }

    public T peek() {
        
        return (T) CLL.rear.next;
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

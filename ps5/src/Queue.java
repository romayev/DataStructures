import java.util.NoSuchElementException;

public class Queue {

    Node rear;

    public Queue() {
        rear = null;
    }

    public void enqueue(Node node) {

    }

    public Node dequeue() throws NoSuchElementException {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 0;
    }

    public Queue split() {
        Queue evenQueue = new Queue();
        int originalSize = size();

        for (int i = 0; i <= originalSize; i++) {
            if (i % 2 == 0) {
                evenQueue.enqueue(dequeue());
            } else (i % 2 == 1) {
                enqueue(dequeue());
            }
            return evenQueue;
        }

    }

}
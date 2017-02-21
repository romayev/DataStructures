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

      for (int i = 2; i <= originalSize; i += 2) {
          
      }
    }

    public static void main(String[] args) {

        Queue evenQueue = new Queue();
        Queue originalQueue = new Queue();

        int originalSize = originalQueue.size();

        for (int i = 2; i <= originalSize; i += 2) {
            enqueue(dequeue());
            evenQueue.enqueue(dequeue());
        }
        if ((originalSize % 2) == 1) {
            enqueue(dequeue());
        }
        return evenQueue;


    }

}
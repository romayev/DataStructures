/**
 * Created by Sasha on 10/28/17.
 */
public class DLL {
    private Node rear;
    public DLL(Node rear) {
        this.rear = rear;
    }

    private DLL(String[] array) {
        Node front = null;
        Node rear = null;

        for (int i = array.length - 1; i >= 0; i-- ) {
            front = new Node();
            front.data = array[i];
            front.next = front;
            if (i == array.length - 1) {
                rear = front;
            }
        }
        if (rear != null) {
            rear.next = front;
        }
        this.rear = rear;
    }


    public String toString() {
        if (rear == null) return "{}";

        String result = "";
        Node first = rear.next;
        Node node = rear.next;
        do {
            result = result + node;
            node = node.next;
        } while (node != first);

        return result;
    }

    public boolean delete(String target) {
        if (rear == null) {
            return false;
        }
        if (rear.next == rear) {
            if (rear.data.equals(target)) {
                rear = null;
                return true;
            }
            else {
                return false;
            }
        }
        Node current = rear.next;
        Node prev = rear;

        while (current != rear) {
            if (current.data.equals(target)) {
                prev.next = current.next;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

}

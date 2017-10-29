/**
 * Created by Sasha on 10/29/17.
 */
public class CLL <T> {
    Node rear;
    Node front = rear.next;
    public CLL(){};

    CLL(int[] array) {
        Node front = null;
        Node curr = null;
        Node hold = null;
        for (int i = array.length - 1; i >= 0; i--) {
            curr = new Node();
            curr.next = hold;
            curr.data = array[i];
            hold = curr;
            if (i == array.length-1) {
                rear = curr;
            }
        }
        front = curr;
        rear.next = front;
    }

    T deleteFirstNode() {
        if (front == null) {
            return null;
        }
        T value = (T) front.data;
        front = front.next;
        rear.next = front;
        return value;
    }

    void addToEnd(T item) {
        Node<T> node = new Node<T>();
        node.data = item;
        Node<T> last = rear;
        if (last == null) {
            front = node;
        } else {
            last.next = node;
            last.next.next = front;
        }
    }

    void printList() {
        Node current = front;
        while (current != rear) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

}

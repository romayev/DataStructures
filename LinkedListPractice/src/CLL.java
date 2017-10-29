/**
 * Created by Sasha on 10/29/17.
 */
public class CLL <T> {
    Node rear;
    public CLL(){};

    CLL(T[] array) {
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
        if (rear.next == rear) {
            return null;
        }
        T value = (T) rear.next.data;
        Node front = rear.next;
        front = front.next;
        rear.next = front;
        return value;
    }

    void addToEnd(T item) {
        Node<T> node = new Node<T>();
        node.data = item;
        rear.next = node;
    }

    void printList() {
        if (rear.next == rear) {
            System.out.print(rear);
        }
        Node current = rear.next;
        do {
            System.out.print(current);
            current = current.next;
        } while (current != rear.next);
        System.out.println();
    }


}

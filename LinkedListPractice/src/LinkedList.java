/**
 * Created by Sasha on 10/6/17.
 */
public class LinkedList <T> {

    public Node<T> front;

    public LinkedList(){};

    LinkedList(T array[]) {
        Node<T> node = null;
        for (int i = array.length - 1; i >= 0; i--) {
            T data = array[i];
            front = new Node<T>();
            front.data = data;
            front.next = node;
            node = front;

        }
    }

    Node deleteEveryOther() {
        if (front == null) {
            return null;
        }
        for (Node pointer = front; pointer != null; pointer = pointer.next) {;
            if (pointer.next != null) {
                pointer.next = pointer.next.next;
            }
        }
        return front;
    }

    int numberOfOccurrences(T target) {
        int counter = 0;
        if (target == null) {
            return 0;
        }
        for (Node<T> pointer = front; pointer != null; pointer = pointer.next) {
            if (target.equals(pointer.data)) {
                counter++;
            }
        }
        return counter;
    }

    boolean delete(T target) {
        if (front == null) {
            return false;
        }
        if (front.next == null) {
            if (front.data.equals(target)) {
                front = null;
                return true;
            } else {
                return false;
            }
        }
        if (front.data.equals(target)) {
            front = front.next;
            return true;
        }
        Node<T> current = front.next;
        Node<T> prev = front;
        while (current != front) {
            if (current.data.equals(target)) {
                prev.next = current.next;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    boolean addAfter(T newItem, T afterItem) {
        Node<T> newNode = new Node<T>();
        newNode.data = newItem;
        newNode.next = null;
        if (front.next == null) {
            if (front.data.equals(afterItem)) {
                newNode.next = front;
                front.next = newNode;
                return true;
            }
            return false;
        }
        Node<T> prev = front;
        Node<T> current = front.next;

        if (prev.data.equals(afterItem)) {
            newNode.next = current;
            prev.next = newNode;
            return true;
        }
        while (current != front) {
            if (current.data.equals(afterItem)) {
                newNode.next = current.next;
                current.next = newNode;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    T deleteFirstNode() {
        if (front == null) {
            return null;
        }
        T value = front.data;
        front = front.next;
        return value;
    }

    void addToFront(T item) {
        Node<T> node = new Node<T>();
        node.data = item;
        if (front == null) {
            front = node;
        } else {
            node.next = front;
            front = node;
        }
    }

    void addToEnd(T item) {
        Node<T> node = new Node<T>();
        node.data = item;
        Node<T> last = findLastNode();
        if (last == null) {
            front = node;
        } else {
            last.next = node;
        }
    }

    private Node<T> findLastNode() {
        if (front == null) {
            return null;
        }
        Node<T> current = front;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    void printList() {
        Node current = front;
        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }
}

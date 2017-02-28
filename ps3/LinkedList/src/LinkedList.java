/**
 * Created by Sasha on 2/5/17.
 *
 * 
 */
public class LinkedList {
    private static final String[] SEASONS = new String[] {"winter", "spring", "summer", "fall"};
    private static final String[] DUPE_SEASONS = new String[] {"winter", "spring", "winter", "fall", "summer", "fall"};
    private static final String[] EMPTY = new String[]{"empty"};

    private Node rear;  // pointer to last node of CLL

    public LinkedList(Node rear) {
        this.rear = rear;
    }

    private LinkedList(String[] array) {
        Node front = null;
        Node rear = null;

        for (int i = array.length - 1; i >= 0; i-- ) {
            front = new Node(array[i], front);
            if (i == array.length - 1) {
                rear = front;
            }
        }
        if (rear != null) {
            rear.next = front;
        }
        this.rear = rear;
    }

    @Override
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

    public static void main(String[] args) {
        LinkedList list = new LinkedList(DUPE_SEASONS);
        System.out.println(list);

//        boolean result = list.delete("empty");
//        System.out.println("Result: " + result);
//        System.out.println(list);
        Node reverse = Reverse(SEASONS);
        System.out.println(reverse);
    }
}


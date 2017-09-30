public class LinkedList {

    private Node rear;
    public LinkedList(Node rear) {
        this.rear = rear;
    }

    public static Node deleteAll(Node front, String target) {
        Node current = front;
        Node prev;
        while (current != null) {
            if (current.data == target) {
                current = current.next;
                return front;
            }

            return null;
        }
        return front;
    }
    
    public LinkedList(String[] array) {
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
        } this.rear = rear;
    }

    public boolean delete(String target) {
        if (rear == null) { return false; }
        if (rear.next == rear) {  //one node
            if (rear.data.equals(target)) {
                rear = null;
                return true;
            }
            else {
                return false;
            }
        }
        Node current = rear.next;
        Node prev = rear;     //setting up 2 nodes to cycle through list
        while (current != rear) {
            if (current.data.equals(target)) {
                prev.next = current.next;  //removing target in middle
                return true;
            }
            prev = current;
            current = current.next;   //cycling through
        }
        return false;   //will only return false if target isn't found in previous while loop
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

    public boolean addAfter(String newItem, String afterItem) {
        Node newNode = new Node(newItem, null);
        if (rear.next == rear) {
            if (rear.data.equals(afterItem)) {
                newNode.next = rear;
                rear.next = newNode;
                return true;
            } return false;
        }
        Node prev = rear;
        Node current = rear.next;

        if (prev.data.equals(afterItem)) {
            newNode.next = current;
            prev.next = newNode;
           return true;
        }
        while (current != rear) {
            if (current.data.equals(afterItem)) {
                newNode.next = current.next;
                current.next = newNode;
                return true;
            }
            current = current.next;
        }
        return false;

    }
}


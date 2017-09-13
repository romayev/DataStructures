
public class IntNode {
    public int data;
    public IntNode next;
    public IntNode(int data, IntNode next) {
        this.data = data;
        this.next = next;
    }

    public String toString() {
        return data + "";
    }

    public static final int[] list = new int[] {1, 2, 3, 4, 5, 6};


    public static void main(String[] args) {
        int[] list = new int[] {1, 2, 3, 4, 5, 6};
        IntNode listNode = createList(list);
        printList(listNode);
    }

    public static void printList(IntNode front) {
        IntNode current = front;
        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

    private static IntNode createList(int[] array) {
        IntNode node = null;
        for (int i = array.length - 1; i >= 0; i--) {
            int data = array[i];
            node = new IntNode(data, node);
        }
        return node;
    }

    public static IntNode addBefore(IntNode front, int target, int newItem) {
        IntNode previous = null;
        IntNode current = front;

        while (current != null){
            if (current.data == target) {
                IntNode intnode = new IntNode(newItem, current);
                if (previous == null) {
                    front = intnode;
                    break;
                } previous.next = intnode;
            }
            previous = current;
            current = current.next;
        }
        return front;
    }

    public static IntNode addBeforeLast(IntNode front, int item) {
        IntNode current = front;
        if (current.next == null) {
            IntNode intnode = new IntNode(item, current);
            return intnode;
        }
        while (current != null){
            if (current.next.next == null) {
                IntNode node = new IntNode(item, current.next);
                current.next = node;
                break;
            } current = current.next;
        }
        return front;
    }

    public static IntNode deleteEveryOther(IntNode front){
        if (front == null) {
            return null;
        }
        for(IntNode ptr = front; ptr != null; ptr = ptr.next) {
            System.out.println(ptr);
            if (ptr.next != null){
                ptr.next = ptr.next.next;
            }
        } return front;
    }
}
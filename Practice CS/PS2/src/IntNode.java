/**
 * Created by Sasha on 9/8/17.
 */
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

/**
 * Created by Sasha on 2/24/17.
 */
public class LinkedList {
    private IntNode rear;

    public LinkedList() {}

    public LinkedList(int[] array) {
        IntNode hold;
        IntNode curr = rear;
        for (int i = array.length-1; i >= 0; i--) {
            hold = curr;
            curr = new IntNode();
            curr.value = array[i];
            curr.next = hold;

            if (i == array.length -1) {
                rear = curr;
            }
            if (rear != null) {
                rear.next = curr;
            }
        }

    }

    public void print() {
        IntNode curr = rear.next;
        do {  System.out.print(curr.value + " ");
            curr = curr.next;}
        while (curr != rear);
        System.out.print(curr.value);
    }

    public void delete(int target) {
        if (rear == null){
            return;
        }
        if (rear.next == rear){
            if (rear.value == target) {
                rear = null;
                return;
            } else {
                return;
            }
        }
        IntNode prev = rear;
        IntNode curr = rear.next;

        while (curr != rear) {
            if (curr.value == target) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        if (target == rear.value) {
            prev.next = curr.next;
            
        }
    }
}

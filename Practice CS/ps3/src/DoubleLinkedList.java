/**
 * Created by Sasha on 9/22/17.
 */
public class DoubleLinkedList {
     public DLLNode front = null;


    public DoubleLinkedList(String[] list) {
        DLLNode prev = null;
        DLLNode current;
        DLLNode front = null;
        for (int i = 0; i< list.length; i++) {
            String number = list[i];
            if (i == 0) {
                prev = new DLLNode(number, null, null);
                front = prev;
            } else {
                current = new DLLNode(number, null, prev);
                prev.next = current;
                prev = current;
            }
        }
        this.front = front;
    }

    public DLLNode moveToFront(DLLNode target) {
        if (target == null || front == null) {
            return null;
        }
        if (target.prev == null) {
            return target;
        }
        target.prev.next = target.next;
        if (target.next != null) {
            target.next.prev = target.prev;
        }
        target.next = front;
        target.prev = null;
        front.prev = target;
        front = target;
        return front;
    }



    public void reverse() {
        DLLNode current = front;
        while (current != null){
            DLLNode next = current.next;
            DLLNode prev = current.prev;
            current.next = prev;
            current.prev = next;
            if (next == null) {
                front = current;
            } current = next;
        }
    }

    public void printList() {
        DLLNode current = front;
        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

}

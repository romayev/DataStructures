/**
 * Created by Sasha on 3/15/17.
 */
public class NodeLinkedList<T> {

    private Node front;

    NodeLinkedList(int[] array) {
        Node curr;
        Node hold = null;
//            size = array.length;
        for (int i = array.length - 1; i >= 0; i--) {
            curr = new Node();
            curr.next = hold;
            curr.value = array[i];
            hold = curr;
            if (i == 0) {
                front = curr;
            }
        }
    }
    void print() {
        Node curr = front;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    void delete(T target) {
        Node prev;
        Node curr;
        if (front == null) {
            return;                             //<T> isn't primitive type
        }                                      //.equals bc object
        if (front.next == null && front.value.equals(target)) {
            front = null;
            return;
        }
        if (front.value.equals(target)) {
            front = front.next;
            return;
        }
        prev = front;
        curr = front.next;

        while (curr != null) {
            if (curr.value.equals(target)) {
                prev.next = curr.next;
                return;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

    }
    // 1->2->3->4->5->6->7
    void deleteEveryOther() {
        int counter = 0;
        Node curr = front;
        while (curr != null) {
            if (counter % 2 == 0) {
                curr = curr.next;
                counter++;                 
            } else {
                T delete = curr.value;
                delete(delete);
                curr = curr.next;
                counter++;
            }
        }
    }

    void deleteEveryOther2() {
        Node curr = front;
        while (curr != null && curr.next != null) {
            Node next = curr.next;
            curr.next = next.next;
            curr = curr.next;
        }
    }

    void deleteEveryOther3() {
        for (Node curr = front; curr != null && curr.next != null; curr = curr.next) {
            Node next = curr.next;
            curr.next = next.next;
        }
    }

    // 1->2->3->4
    void reverse() {
        Node current = front;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        front = prev;
    }

    void deleteSingle(T target) {
        if (front.value.equals(target)) {
            if (front.next == null) {
                return;
            } else {
                front = front.next;
            }
            return;
        }
        Node prev = front;
        Node curr = front.next;
        while (curr != null) {
            if (curr.value.equals(target)) {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // 1->2->3->4
    void moveUpOne(T target) {
        if (front.value.equals(target)) {
            return;
        }

        Node third = front.next;
        Node second = front;
        Node first = null;

        while (third != null) {
            if (third.value.equals(target)) {
                swapNodes(first, second);
                break;
            }
            first = second;
            second = third;
            third = third.next;
        }
    }

    void swapNodes(Node first, Node second) {
        if (second == null || second.next == null) {
            System.out.println("Second or third is null, should never happen");
            return;
        }
        Node third = second.next;
        second.next = third.next;
        third.next = second;
        if (first != null) {
            first.next = third;
        } else {
            front = third;
        }
    }


}

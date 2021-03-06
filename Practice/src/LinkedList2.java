import sun.awt.image.ImageWatched;

/**
 * Created by Sasha on 2/24/17.
 */
class LinkedList2 {
    private IntNode front;
    int size;

    LinkedList2(int[] array) {
        IntNode curr;
        IntNode hold = null;
        size = array.length;
        for (int i = array.length - 1; i >= 0; i--) {
            curr = new IntNode();
            curr.next = hold;
            curr.value = array[i];
            hold = curr;
//            if (i == array.length -1) {
//                curr.next = null;
//            }
            if (i == 0) {
                front = curr;
            }
        }
    }


    void print() {
        IntNode curr = front;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }


    void delete(int target) {
        IntNode prev;
        IntNode curr;
        if (front == null) {
            return;                             //<T> isn't primitive type
        }                                      //.equals bc object
        if (front.next == null && front.value == target) {
            front = null;
            return;
        }
        if (front.value == target) {
            front = front.next;
            return;
        }
        prev = front;
        curr = front.next;

        while (curr != null) {
            if (curr.value == target) {
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
        IntNode curr = front;
        while (curr != null) {
            if (counter % 2 == 0) {
                curr = curr.next;
                counter++;
            } else {
                int delete = curr.value;
                delete(delete);
                curr = curr.next;
                counter++;
            }
        }
    }

    void deleteEveryOther2() {
        IntNode curr = front;
        while (curr != null && curr.next != null) {
            IntNode next = curr.next;
            curr.next = next.next;
            curr = curr.next;
        }
    }

    void deleteEveryOther3() {
        for (IntNode curr = front; curr != null && curr.next != null; curr = curr.next) {
            IntNode next = curr.next;
            curr.next = next.next;
        }
    }

    // 1->2->3->4
    void reverse() {
        IntNode current = front;
        IntNode prev = null;
        while (current != null) {
            IntNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        front = prev;
    }

    void deleteSingle(int target){
        if (front.value == target) {
            if (front.next == null) {
                return;
            }
            else {
                front = front.next;
            }
            return;
        }
        IntNode prev = front;
        IntNode curr = front.next;
        while (curr != null) {
            if (curr.value == target) {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // 1->2->3->4
    void moveUpOne(int target) {
        if (front.value == target) {
            return;
        }

        IntNode third = front.next;
        IntNode second = front;
        IntNode first = null;

        while (third != null) {
            if (third.value == target) {
                swapNodes(first, second);
                break;
            }
            first = second;
            second = third;
            third = third.next;
        }
    }

    void swapNodes(IntNode first, IntNode second) {
        if (second == null || second.next == null) {
            System.out.println("Second or third is null, should never happen");
            return;
        }
        IntNode third = second.next;
        second.next = third.next;
        third.next = second;
        if (first != null) {
            first.next = third;
        } else {
            front = third;
        }
    }
}

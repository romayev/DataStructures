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
            return;
        }
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

    void deleteEveryOther() {
       int counter = 0;
         while (front != null) {
             if (counter % 2 == 0) {
                 front = front.next;
                counter++;
             }
             else {
                 int delete = front.value;
                 delete(delete);
                 front = front.next;
                 counter++;
             }
        }     System.out.print(front.value);


    }   
}

/**
 * Created by Sasha on 2/25/17.
 */
public class CircularList {
    IntNode rear;

    CircularList(int[] array) {
        IntNode front = null;
        IntNode curr = null;
        IntNode hold = null;
        for (int i = array.length - 1; i >= 0; i--) {
            curr = new IntNode();
            curr.next = hold;
            curr.value = array[i];
            hold = curr;
            if (i == array.length-1) {
                rear = curr;
            }
        }
        front = curr;
        rear.next = front;
        System.out.println(rear.value);
        System.out.println(rear.next.value);
    }


}
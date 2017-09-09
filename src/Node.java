/**
 * Created by Sasha on 5/7/17.
 */
public class Node {
    public int data;
    public Node next;

    public static Node merge(Node frontL1, Node frontL2) {
         if (frontL1 == null) {
             return frontL2;
         }
         if (frontL2 == null) {
             return frontL1;
         }
         if (frontL1.data == frontL2.data) {
             frontL1 = frontL1.next;
             
         }
         return null;
    }

    public static Node reverse(Node front) {
       if (front == null || front.next == null) {
           return front;
       }
       Node reverse = reverse(front.next);
       front.next.next = front;
       front.next = null;
       return reverse;
    }

    public static Node deleteAll(Node front, int target) {
         if (front == null) {
             return null;
         }
         if (front.data == target) {
             return deleteAll(front.next, target);
         }
         front.next = deleteAll(front.next, target);
         return front;
    }
}

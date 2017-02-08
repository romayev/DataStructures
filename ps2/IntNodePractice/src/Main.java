public class IntNode {
    public int data;
    public IntNode next;
    public IntNode(int data, IntNode next) {
        this.data = data; this.next = next;
    }
    public String toString() {
        return data + "";
    }

    //Implement a method that will add a new integer before a target integer in the list. The
    // method should return a pointer/reference to the front node of the resulting list.
    // If the target is not found, it should return front without doing anything:

    public static IntNode addBefore(IntNode front, int target, int newItem) {
//       IntNode current = front;
//       IntNode prev = null;
//       while (current != null){
////           if (current.data == target){
////               IntNode newNode = new IntNode (newItem, current);
////               if (prev == null){
////                  front = newNode;
////                  break;
////               }
////               prev.next = newNode;
////           }
////           prev = current;
////           current = current.next;
////        }
////        return front;
///    }

        IntNode prev = null;
        IntNode current = front;

        while (current != null){
            if (current.data);
        }

        IntNode prev=null, ptr=front;
        while (ptr != null && ptr.data != target) {
            prev = ptr;
            ptr = ptr.next;
        }
        if (ptr == null) { // target not found
            return front;
        }
        IntNode temp = new IntNode(newItem, ptr); // next of new node should point to target
        if (prev == null) { // target is first item, so new node will be new front
            return temp;
        }
        prev.next = temp;
        return front;  // front is unchanged
    }
}
/**
 * Created by Sasha on 2/5/17.
 */
public class LinkedList {
    //                                                                                                                      rear->null
    //                                                          node->blue
    private static final String[] EXAMPLE_ARRAY = new String[] {"red", "blue", "green", "red", "orange", "blue", "white", "yellow"};

    private Node rear;  // pointer to last node of CLL

    public LinkedList(Node rear) {
        this.rear = rear;
    }

    private static LinkedList createList(String[] array) {
        Node front = null;
        Node rear = null;

        for (int i = array.length - 1; i >= 0; i-- ) {
            front = new Node(array[i], front);
            if (i == array.length - 1) {
                rear = front;
            }
        }
        if (rear != null) {
            rear.next = front;
        }
        return new LinkedList(rear);
    }

//    public boolean delete(String target) {
//        Node current = rear; //going to use this one to cycle through the list, assuming rear means front
//        Node prev = null; // set equal to current, have it lag once behind
//        if (current.data == target){ // in other words if the first node is the target
//            current = current.next
//            Node temp = new Node(current.data, current.next.next);
//                prev = temp;
//            }
//            prev = current;
//            current = current.next;
//        }
//        return rear;
//    }

    public boolean delete(String target) {
        Node prev = new Node(null,null);
        if (rear == null) {
            System.out.println("list is empty");
        }

        Node curr = new Node (null,rear);
        prev = null;

        while (curr != null){
            if (curr.data == target){
                if (prev == null) {
                    rear = curr.next;
                }
                else {
                    prev = curr;
                }
                curr = curr.next
            }
            return true;
        }
        

//            if (target.equals(rear.data)) {
//            // found, delete, leaves empty lis
//                rear = null; return true; }
//                else { // not found return false; }
//                 } Node prev=rear, curr=rear.next;
//        do { if (target.equals(curr.data)) {
//            prev.next = curr.next;
//            if (curr == rear) {
//
//                //if curr is last node, prev becomes new last node
//                rear == prev;
//            }
//            return true;
//        } // skip to next node
//            prev = curr; curr = curr.next; }
//            while (prev != rear); {
//                return false; // not found }
//        }
//
//



            @Override
            public String toString() {
                String result = "";
                if (rear == null) return result;

                Node node = rear;
                while (node.next != rear) {
                    result = result  + node;
                    node = node.next;
                }
                return result;
            }


        }public static void main(String[] args) {
        LinkedList list = createList(EXAMPLE_ARRAY);
        System.out.println(list);
        list.delete("red");
        System.out.println(list);
    }
}


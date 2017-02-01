public class IntNode {
    private static final int[] PRIME_NUMBERS = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 91, 97 };

    public int data;
    public IntNode next;

    public IntNode(int data, IntNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data + " ";
    }

    public static void printList(IntNode front) {
        IntNode current = front;
        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

    public static IntNode addBefore(IntNode front, int target, int newItem) {
        // Start with front
        // iterate the linked list until you find node with data == target
        // create new node with data = newItem and next -> the found node
        // make sure the previous node's next is now pointing at the new node
        IntNode current = front;
        IntNode prev = null;

        while (current != null) {
            if (current.data == target) {
                IntNode node = new IntNode(newItem, current);
                if (prev == null) {
                    front = node;
                    break;
                }
                prev.next = node;
            }
            prev = current;
            current = current.next;
        }
        return front;
    }

    public static IntNode addBeforeLast(IntNode front, int item) {
        IntNode current = front;
        // I'm the only one here cute :) (current is last)
        if (current.next == null) {
            IntNode node = new IntNode (item, current);
            return node;
        }

        while (current != null) {
            if (current.next.next == null) {
                IntNode node = new IntNode(item, current.next);
                current.next = node;
                break;
            }
            current = current.next;
        }

        return front;
    }

    // creates a new linked list consisting of the items common to the input lists
    // return the front of this new linked list, null if there are no common items
    public static IntNode commonElements(IntNode frontL1, IntNode frontL2) {
        return null;
    }

    private static IntNode createList() {
        IntNode node = null;
        // Iterate prime numbers backwards, create nodes from end to front
        for (int i = PRIME_NUMBERS.length - 1; i >= 0; i-- ) {
            int data = PRIME_NUMBERS[i];
            node = new IntNode(data, node);
        }
        return node;
    }

    public static IntNode removerEveryOther(IntNode front){
        if (front.next == null) {
            return;
        }

        for (IntNode ptr front; ptr != null; ptr = ptr.next){
            if (ptr.next == null){
                return;
            }
            ptrn.next = ptr.next.next;
        }
    }

    public static IntNode CommonElements(IntNode frontOne, intNode frontTwo){
        IntNode ptr1= frontOne; ptr2 = frontTwo; frontThree = null;
        node ptr3 = new Node(0,null);
        while (ptr1 != null && ptr2 != null){
            if (ptr1.data == ptr2.data) {
                if (ptr3.data == null){
                    ptr2.data = ptr1.data;
                    frontThree = ptr3;
                }
            else {
                    Node temp = new Node(ptr1.data, null);
                    ptr3.next = temp;
                    ptr3 = ptr3.next;
                }
            }
            else if (ptr1.data > ptr2.data){
                ptr2 = ptr2.next;
            }
            else (ptr1.data < ptr2.data){
                ptr1 = ptr1.next;
            }
            return frontThree;
        }
    }

    public static void main(String[] args) {
        System.out.println("Adding 99 before 100");
        IntNode oneOnly = new IntNode(100, null);
        printList(oneOnly);
        oneOnly = addBefore(oneOnly, 100, 99);
        printList(oneOnly);

        System.out.println("Creating list");
        IntNode front = createList();
        printList(front);

        System.out.println("Testing add middle");
        front = addBefore(front, 7, 666);
        printList(front);

        System.out.println("Testing add before first");
        front = addBefore(front, 2, 999);
        printList(front);

        System.out.println("Testing add before first again");
        front = addBefore(front, 999, 555);
        printList(front);

        System.out.println("Testing add before last with target");
        front = addBefore(front, 97, 444);
        printList(front);

        System.out.println("Adding before last");
        front = addBeforeLast(front, 50);
        printList(front);

        System.out.println("Adding 999 before 1000");
        IntNode one = new IntNode(1000, null);
        printList(one);

        front = addBeforeLast(one, 999);
        printList(front);
    }
}

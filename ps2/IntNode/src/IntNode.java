public class IntNode {
    private static final int[] PRIME_NUMBERS = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 91, 97};
    private static final int[] LUCKY_NUMBERS = new int[] {3, 6, 7, 9, 11, 16, 20};

    private static final int[] ONE = new int[] {3, 6};
    private static final int[] TWO = new int[] {4, 6, 7};


    public int data;
    public IntNode next;

    public IntNode(int data, IntNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        String next = (this.next != null) ? String.valueOf(this.next.data) : "null";
        return data + "->" + next + " ";
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
            IntNode node = new IntNode(item, current);
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

    private static IntNode createList(int[] array) {
        IntNode node = null;
        // Iterate prime numbers backwards, create nodes from end to front
        for (int i = array.length - 1; i >= 0; i--) {
            int data = array[i];
            node = new IntNode(data, node);
        }
        return node;
    }

    public static IntNode removerEveryOther(IntNode front) {
        if (front == null) {
            return null;
        }
        for (IntNode ptr = front; ptr != null; ptr = ptr.next) {
            System.out.println(ptr);
            if (ptr.next != null) {
                ptr.next = ptr.next.next;
            }
            printList(front);
        }
        return front;
    }

    public static IntNode commonElements(IntNode frontOne, IntNode frontTwo) {
       
        IntNode ptr1 = frontOne;
        IntNode ptr2 = frontTwo;
        IntNode last = null;
        IntNode front = null;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.data > ptr2.data) {
                ptr2 = ptr2.next;
            } else if (ptr1.data < ptr2.data) {
                ptr1 = ptr1.next;
            } else {  //if the two are equal
                IntNode match = new IntNode(ptr1.data, null);
                if (last != null) {
                    last.next = match;
                } else {
                    front = match;
                }
                last = match;

                ptr1 = ptr1.next;
                ptr2 = ptr2.next;

            }
        }
        return front;
    }

    public static IntNode merge (IntNode one, IntNode two) {
//        System.out.println("One: ");
//        printList(one) ;
//
//        System.out.println("Two: ");
//        printList(two);

        if (one == null) return two;
        if (two == null) return one;
        if (one.data == two.data) {
            one.next = merge(one.next, two.next);
            return one;
        }
        if (one.data < two.data) {
            one.next = merge(one.next, two);
            return one;
        }
        if (one.data > two.data) {
            two.next = merge(one, two.next);
            return two;
        }
        return one;
    }
    
    public static void main(String[] args) {
//        System.out.println("Adding 99 before 100");
//        IntNode oneOnly = new IntNode(100, null);
//        printList(oneOnly);
//        oneOnly = addBefore(oneOnly, 100, 99);
//        printList(oneOnly);
//
//        System.out.println("Creating list");
//        IntNode front = createList();
//        printList(front);
//
//        System.out.println("Testing add middle");
//        front = addBefore(front, 7, 666);
//        printList(front);
//
//        System.out.println("Testing add before first");
//        front = addBefore(front, 2, 999);
//        printList(front);
//
//        System.out.println("Testing add before first again");
//        front = addBefore(front, 999, 555);
//        printList(front);
//
//        System.out.println("Testing add before last with target");
//        front = addBefore(front, 97, 444);
//        printList(front);
//
//        System.out.println("Adding before last");
//        front = addBeforeLast(front, 50);
//        printList(front);
//
//        System.out.println("Adding 999 before 1000");
//        IntNode one = new IntNode(1000, null);
//        printList(one);
//
//        front = addBeforeLast(one, 999);
//        printList(front);
        //        printList(front);
//        front = removerEveryOther(front);
//        printList(front);
//        front = removerEveryOther(front);
//        printList(front);
//        front = removerEveryOther(front);
//        printList(front);
//        front = removerEveryOther(front);
//        printList(front);
//        front = removerEveryOther(front);
//        printList(front);
//        front = removerEveryOther(front);
//        printList(front);

        // Test 'removerEveryOther', call them method and print the list
        // then call it again and again and again untill you see only one node

        // Test 'commonElements'

        System.out.println("Creating prime");
        IntNode primeFront = createList(PRIME_NUMBERS);
        printList(primeFront);

        System.out.println("Creating lucky");
        IntNode luckyFront = createList(LUCKY_NUMBERS);
        printList(luckyFront);

//        System.out.println("Calculating common");
//        IntNode common = commonElements(primeFront, luckyFront);
//        printList(common);

        System.out.println("Merging");
        IntNode merged = merge(primeFront, luckyFront);
        printList(merged);
    }
}

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

    private static IntNode createList() {
        IntNode node = null;
        // Iterate prime numbers backwards, create nodes from end to front
        for (int i = PRIME_NUMBERS.length - 1; i >= 0; i-- ) {
            int data = PRIME_NUMBERS[i];
            node = new IntNode(data, node);
        }
        return node;
    }

    public static IntNode removerEveryOther(IntNode front) {
        if (front.next == null) {
            return front;
        }

        // Two things here:
        // 1. The syntax is broken here: IntNode ptr front. You are saying: create a variable of type 'IntNode'
        // can call it 'ptr', which is fine. Why did you put 'front' after it? Did you mean to initialize it to
        // front, i.e. IntNode ptr = front;

        // I guess making a separate pointer isn't necessary. We went over this loop in class, I figured I would give it a go.

        // Your code was correct the first time, you were just missing the '='
        // This is what it says:
        // IntNode ptr = front: create a pointer of type 'IntNode', call it 'ptr', initialize it to 'front'
        // ptr.next != null: keep going until ptr.next is null
        // ptr = ptr.next: at the end of each loop make ptr to point to ptr.next
        // for (IntNode ptr = front; ptr.next != null; ptr = ptr.next) {


        // 2. This is a different way of iterating a linked list (we used a while loop in other problems). Is
        // there a reason you switched? Is this what you do in class? In any case, when you hand in your assignments
        // you should be consistent.

        // When this is working, change addBefore and addBeforeLast to use the for loop instead of the while loop
        // to stay consistent
        for (front; front != null; front = front.next) {
            if (front.next == null) {
                return front;
            }

            // Your variable is called ptr not ptrn. Fix it and the compiler will be happy.
            // Once you fix the loop, it should be ptr.next = ptr.next.next;
            front.next = front.next.next;
        }
        return front;
    }

    public static IntNode commonElements(IntNode frontOne, IntNode frontTwo) {
        // You can declare three variables of the same type on the same line, but not declare and assign
        // at the same time. Split into 3 lines.
        IntNode ptr1 = frontOne;
        IntNode ptr2 = frontTwo;
        IntNode frontThree = null;
        // What is 'node'? Do you mean IntNode? Same for 'Node'.
        IntNode ptr3 = new IntNode(0,null);
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.data == ptr2.data) {
                // ptr3.data is an 'int'. It cannot be 'null'. As a matter of fact, you initialized it to zero on line 124
                if (ptr3.data == null) {
                    // Everything seems fine up to this point. Wny are you assigning ptr2.data the value of ptr1.data?

                    //my mistake, meant to assign the value to ptr3

                    ptr3.data = ptr1.data;
                    frontThree = ptr3;
                } else {
                    // You don't have any objects of type 'Node'. Did you mean 'IntNode'?

                    //yes
                    IntNode temp = new IntNode(ptr1.data, null);
                    ptr3.next = temp;
                    ptr3 = ptr3.next;
                }
            } else if (ptr1.data > ptr2.data) {
                ptr2 = ptr2.next;
             // Should be 'else if' not 'else'
            } else (ptr1.data < ptr2.data) {
                ptr1 = ptr1.next;
            }
        }
        return frontThree;
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

        // Test 'removerEveryOther', call them method and print the list
        // then call it again and again and again untill you see only one node

        // Test 'commonElements'
    }
}

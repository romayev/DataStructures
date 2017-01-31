public class IntNode {
    private static final int[] PRIME_NUMBERS = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };

    public int data;
    public IntNode next;

    public IntNode(int data, IntNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data + "";
    }

    public static IntNode addBefore(IntNode front, int target, int newItem) {
        return null;
    }

    public static IntNode addBeforeLast(IntNode front, int item) {
        return null;
    }

    // creates a new linked list consisting of the items common to the input lists
    // return the front of this new linked list, null if there are no common items
    public static IntNode commonElements(IntNode frontL1, IntNode frontL2) {
        return null;
    }

    private static IntNode createList() {
        IntNode node = null;
        // Iterate prime numbers backwards, create nodes from end to front
        for (int i = 0; i < PRIME_NUMBERS.length; i-- ) {
            // Create
        }
        return node;
    }

    public static void main(String[] args) {
        IntNode front = createList();
        addBefore(front, 17, 15);
    }
}

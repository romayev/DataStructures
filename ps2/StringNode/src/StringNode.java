public class StringNode {

    private static final String[] STRING_LIST  = new String[] { "Julie", "Sasha", "Roma", "Julie", "Roma", "Roma", "Julie", "Alex", "Roma", "Rita", "Kuzya", "Julie", "Julie", "Peter"};
    private static final String[] SMALL_LIST  = new String[] { "Roma", "Julie", "Alex"};

    public String data;
    public StringNode next;
    
    public StringNode(String data, StringNode next) {
        this.data = data; this.next = next;
    }
    public String toString() {
        return data + " ";
    }

    public static int numberOfOccurrences(StringNode front, String target) {
        int counter = 0;
        if (target == null) {
            return 0;
        }
        for (StringNode ptr = front; ptr != null; ptr = ptr.next) {
            if (target.equals(ptr.data)) {
                counter++;
            }
        }
        return counter;
    }

    public static StringNode deleteAll(StringNode front, String target) {
        printList(front);
        if (front == null) {
            return null;
        }
        if (front.data.equals(target)) {
            return deleteAll(front.next, target);
        }
        front.next = deleteAll(front.next, target);
        return front;
    }


    private static StringNode createList(String[] array) {
        StringNode node = null;
        for (int i = array.length - 1; i >= 0; i--) {
            String data = array[i];
            node = new StringNode(data, node);
        }
        return node;
    }

    private static void printList(StringNode front) {
        StringNode current = front;
        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StringNode front = createList(SMALL_LIST);
        printList(front);
        
        System.out.println("Julie: " + numberOfOccurrences(front, "Julie"));
        System.out.println("Roma: " + numberOfOccurrences(front, "Roma"));

        front = deleteAll(front, "Julie");
        System.out.println("Done!");
        printList(front);
//        System.out.println("Julie: " + numberOfOccurrences(front, "Julie"));
//        System.out.println("Roma: " + numberOfOccurrences(front, "Roma"));
//
//        front = deleteAll(front, "Roma");
//        printList(front);
//        System.out.println("Julie: " + numberOfOccurrences(front, "Julie"));
//        System.out.println("Roma: " + numberOfOccurrences(front, "Roma"));
    }
}

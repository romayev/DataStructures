public class Main {
    private static final String[] NUMBERS = {"one", "two", "three", "four", "five"};

    public static DLLNode moveToFront(DLLNode front, DLLNode target) {
        if (target == null || front == null){
            return null;
        }
        if (target.prev == null) {
            return target;
        }
        target.prev.next = target.next;
        if (target.next != null) {
            target.next.prev = target.prev;
        }
        target.next = front;
        target.prev = null;
        front.prev = target;
        return target;
    }

    private static DLLNode createList(String[] list) {
        DLLNode prev = null;
        DLLNode current;
        DLLNode front = null;
        for (int i = 0; i < list.length; i++) {
            String data = list[i];
            if (i == 0) {
                prev = new DLLNode(data, null, null);
                front = prev;
            } else {
                current = new DLLNode(data, null, prev);
                prev.next = current;
                prev = current;
            }
        }return front;
    }
    public static DLLNode reverse(DLLNode front) {
        DLLNode current = front;
        while (current != null){
            DLLNode next = current.next;
            DLLNode prev = current.prev;
            current.next = prev;
            current.prev = next;
            if (next == null) {
                front = current;
            }
            current = next;
        }return front;
    }


    private static void printList(DLLNode front) {
        DLLNode current = front;
        while (current != null) {
            System.out.print(current);
            current = current.next;
        } System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("List:");
        DLLNode front = createList(NUMBERS);
        printList(front);
        System.out.println("Moving " + front.next.next + " to front");
        front = moveToFront(front, front.next.next);
        printList(front);
        System.out.println("Reverse:");
        DLLNode test = reverse(front);
        printList(test);


    }
}

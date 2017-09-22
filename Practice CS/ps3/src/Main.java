public class Main {
    private static final String[] numbers = {"one", "two", "three", "four", "five"};
    private static final String[] seasons = new String[] {"winter", "spring", "summer", "fall"};

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
        for (int i = 0; i< list.length; i++) {
            String number = list[i];
            if (i == 0) {
                prev = new DLLNode(number, null, null);
                front = prev;
            } else {
                current = new DLLNode(number, null, prev);
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
            } current = next;
        }return front;
    }


    private static void printList(DLLNode front) {
        DLLNode current = front;
        while (current != null) {
            System.out.print(current);
            current = current.next;
        } System.out.println();
    }

    public static Node merge(Node frontL1, Node frontL2) {

     return null;
    }

    private static Node createLList(String[] array) {
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
        return rear;
    }

    public static void main(String[] args) {
//        DLLNode front = createList(numbers);
//        printList(front);
//        System.out.println("Moving " + front.next.next + " to front");
//        front = moveToFront(front, front.next.next);
//        printList(front);
//        System.out.println("Reverse:");
//        DLLNode test = reverse(front);
//        printList(test);

        LinkedList list = new LinkedList(seasons);
        System.out.println("Seasons: " + list);
//        boolean delete = list.delete("winter");
//        boolean delete = list.delete("hello");
//        System.out.print(delete);
//        list.addAfter("hi", "winter");
//        System.out.println(list);



    }
}

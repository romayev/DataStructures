public class Main {

    private static String[] names = new String[] {"Sasha", "Roma", "Julie","Sasha","Sasha","Sasha"};
    private static Integer[] numbers = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        Main main = new Main();
//        Queue queue = new Queue(names);
//        System.out.println(queue.size());
//        queue.print();
//        System.out.print("dequeue: " + queue.dequeue());
//        System.out.println();
//        queue.print();
//        System.out.println(queue.size());
//        System.out.print("enqueue:");
//        queue.enqueue("Kuzya");
//        queue.print();
//        System.out.print(queue.size());

        DLLQueue que = new DLLQueue(names);
        System.out.println(que.size());
        que.print();


//        Stack stack = new Stack(numbers);
//        System.out.println(stack.size);
//        stack.printStack(stack);
//        System.out.println(stack.size);
    }

    private void test() {
        LinkedList list;
        list = new LinkedList<String>(names);
        testDeleteEveryOther(list);
        stringTestNumberOfOccurences(list, "Sasha");
        stringTestAddAfter(list, "Kuzya", "Sasha");
        stringTestDelete(list, "Kuzya");
    }

    private void testDeleteEveryOther(LinkedList list) {
        list.printList();
        list.deleteEveryOther();
        list.printList();
    }

    private void stringTestNumberOfOccurences(LinkedList list, String target) {
        list.printList();
        System.out.print("Number of occurences: "+ list.numberOfOccurrences(target));
    }

    private void intTestNumberOfOccurences(LinkedList list, Integer target) {
        list.printList();
        System.out.print("Number of occurences: "+ list.numberOfOccurrences(target));
    }


    private void stringTestAddAfter(LinkedList list, String newItem, String afteritem) {
        list.printList();
        list.addAfter(newItem, afteritem);
        list.printList();
    }

    private void intTestAddAfter(LinkedList list, Integer newItem, Integer afteritem) {
        list.printList();
        list.addAfter(newItem, afteritem);
        list.printList();
    }

    private void intTestDelete(LinkedList list, Integer target) {
        list.printList();
        list.delete(target);
    }

    private void stringTestDelete(LinkedList list, String target) {
    list.printList();
    list.delete(target);
    list.printList();
    }
}

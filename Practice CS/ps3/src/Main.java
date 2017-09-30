public class Main {


    public static void main(String[] args) {

        String[] numbers = {"one", "two", "three", "four", "five"};
//        String[] seasons = new String[]{"winter", "spring", "summer", "fall"};
//
//        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(numbers);
//        doubleLinkedList.printList();
//        doubleLinkedList.reverse();
//        doubleLinkedList.printList();
//
//        DLLNode front = doubleLinkedList.front;
//        DLLNode node = front.next;
//        System.out.println("Moving " + node + " to front");
//        doubleLinkedList.moveToFront(node);
//        doubleLinkedList.printList();
//
//        System.out.print("Reversing: ");
//        doubleLinkedList.reverse();
//        doubleLinkedList.printList();

        LinkedList linkedList = new LinkedList(numbers);
        System.out.println("Add after test");
        linkedList.addAfter("Two", "five");
        linkedList.printList();
    


//



//        LinkedList list = new LinkedList(seasons);
//        System.out.println("Seasons: " + list);
////        boolean delete = list.delete("winter");
////        boolean delete = list.delete("hello");
////        System.out.print(delete);
//        list.addAfter("hi", "winter");
//        System.out.println(list);


    }
}

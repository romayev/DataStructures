import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

import static java.util.Collections.sort;

public class Main {

    private void testStars() {
        int length = 5;

        StarCreator starCreator = new StarCreator();
        starCreator.printStars(length);
    }

    private void songComparer() {
        SongComparer songComparer = new SongComparer();
        String[] playlistOne = new String[]{"tasteless", "creep", "gemini", "youth", "wish I knew you"};
        String[] playlistTwo = new String[]{"cane shuga", "sweetie little Jean", "youth", "tasteless"};

        ArrayList commonSongs = songComparer.comparesSongs(playlistOne, playlistTwo);
        songComparer.printSongs(commonSongs);
    }

    private void testLinkedList1Delete() {
        int[] numberArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        LinkedList linkedList = new LinkedList(numberArray);
        linkedList.print();
        System.out.println();

        linkedList.delete(7);
        linkedList.print();
    }

    private void testLinkedList2Delete() {
        System.out.println("testLinkedList2Delete");
        int[] numberArray = new int[]{1};
        LinkedList2 linkedList2 = new LinkedList2(numberArray);
        linkedList2.print();
        linkedList2.deleteSingle(1);
        System.out.println("target = 1");
        linkedList2.print();
        linkedList2.deleteSingle(4);
        System.out.println("target = 4");
        linkedList2.print();
        linkedList2.deleteSingle(44);
        System.out.println("target = 44");
        linkedList2.print();
        linkedList2.deleteSingle(7);
        System.out.println("target = 7");
        linkedList2.print();
    }

////    public static <T> intSize(Stack<T> S) {
////
////        int count = 0;
////        Stack<T> stack = new Stack<T>();
////
////        while (true) {
////            try {
////                stack.push(S.pop());
////                ++count;
////            } catch (NoSuchElementException e) {
////                break;
////            }
////        }
////
////        while (true) {
////            try {
////                S.push(stack.pop());
////            } catch (NoSuchElementException e) {
////                break;
////            }
////        }
////        return count;
////    }
//
//}

    private void testLinkedListDeleteEveryOther() {
        System.out.println("testLinkedListDeleteEveryOther");
        int[] numberArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        LinkedList2 linkedList2 = new LinkedList2(numberArray);
        linkedList2.print();
        linkedList2.deleteEveryOther3();
        linkedList2.print();
    }

    private void testLinkedListReverse() {
        System.out.println("Reverse list");
        int[] numberArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        LinkedList2 linkedList2 = new LinkedList2(numberArray);
        linkedList2.print();
        linkedList2.reverse();
        linkedList2.print();
    }

    private void testCircularList() {
        int[] numberArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        CircularList circularList = new CircularList(numberArray);
    }

    private void testMoveUpOne() {
        System.out.println("Moving test");
        int[] numberArray = new int[]{1, 2, 3, 4, 5, 6};
        LinkedList2 linkedList2 = new LinkedList2(numberArray);
        linkedList2.print();
        linkedList2.moveUpOne(6);
        linkedList2.print();
    }

    private void testQueue() {
        Queue<Integer> integerQueue = new Queue<Integer>();
        integerQueue.print();
        integerQueue.enqueue(23);
        integerQueue.print();
        integerQueue.enqueue(32);
        integerQueue.print();
        integerQueue.enqueue(54);
        integerQueue.print();

        while (!integerQueue.isEmpty()) {
            try {
                int item = integerQueue.dequeue();
                System.out.println("Dequeued: " + item);
                integerQueue.print();
                System.out.println("Peek: " + integerQueue.peek());
            } catch (NoSuchElementException e) {
                System.out.println("Oops, exception" + e);
                break;
            }
        }
        System.out.println("Queue is empty!");
    }

    private void testSplitQueue() {
        Queue<String> stringQueue = new Queue<String>();
        stringQueue.enqueue("Sasha");
        stringQueue.enqueue("Alex");
        stringQueue.enqueue("Peter");
        stringQueue.enqueue("Rita");
        stringQueue.enqueue("Roma");
        stringQueue.enqueue("Julie");
        stringQueue.enqueue("Kuzya");
        stringQueue.print();
        Queue<String> stringQueue2 = stringQueue.evenSplit();
        System.out.println("Original queue:");
        stringQueue.print();
        System.out.println("Second queue:");
        stringQueue2.print();
    }

    private <T> T peek(Queue<T> queue) {
        T value;
        try {
            value = queue.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Exception encountered, empty Queue");
            return null;
        }
        Queue<T> secondQueue = new Queue<T>();
        secondQueue.enqueue(value);
        while (!queue.isEmpty()) {
            secondQueue.enqueue(queue.dequeue());
        }
        while (!secondQueue.isEmpty()) {
            queue.enqueue(secondQueue.dequeue());
        }
        return value;
    }

    private <T> T peek2(Queue<T> queue) {
        T value = null;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                value = queue.dequeue();
                queue.enqueue(value);
            } else {
                queue.enqueue(queue.dequeue());
            }
        }
        return value;
    }

    private static <T> int size(Stack<T> stack) {
        int size = 0;
        Stack<T> secondStack = new Stack<T>();
        while (!stack.isEmpty()) {
            secondStack.push(stack.pop());
            size++;
        }
        while (!secondStack.isEmpty()) {
            stack.push(secondStack.pop());
            System.out.print("Second stack: ");
            secondStack.print();
        }
        return size;
    }

    private void testStackSize() {
        Stack<String> stack = new Stack<String>();
        stack.print();
        stack.push("a");
        System.out.println("Size: " + size(stack));
        stack.print();
        stack.push("b");
        System.out.println("Size: " + size(stack));
        stack.print();
        stack.push("c");
        System.out.println("Size: " + size(stack));
        stack.print();
        while (!stack.isEmpty()) {
            stack.pop();
            stack.print();
            System.out.println("Size: " + size(stack));
        }
    }

    private void testPeek() {
        Queue<String> stringQueue = new Queue<String>();
        stringQueue.enqueue("Apple");
        stringQueue.enqueue("Banana");
        stringQueue.enqueue("Orange");
        stringQueue.enqueue("Watermelon");
        stringQueue.print();

        System.out.println("First node of Queue " + peek2(stringQueue));
        stringQueue.print();
        while (!stringQueue.isEmpty()) {
            System.out.println("First node of Queue " + peek2(stringQueue));
            stringQueue.dequeue();
        }
    }

    private void testStack() {
        Stack<String> stack = new Stack<String>();
        stack.print();
        stack.push("a");
        stack.print();
        stack.push("b");
        stack.print();
        while (stack.size() >= 0) {
            try {
                String item = stack.pop();
                System.out.println("popped: " + item);
            } catch (NoSuchElementException e) {
                System.out.println("Stack is empty!");
                break;
            }
            stack.print();
        }
    }
    private void testBST() {
        BST<Integer> tree = new BST<Integer>();
//        for (int i = 0; i < 10; i++) {
//            int random = (int )(Math.random() * 50 + 1);
//            tree.insert(random);
//        }
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(7);
        tree.insert(9);
        tree.insert(12);
        tree.print();
    }
    private void testKeysInRange() {
        BST<Integer> tree = new BST<Integer>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(7);
        tree.insert(9);
        tree.insert(12);
        ArrayList<Integer> list = new ArrayList<Integer>();
        tree.keysInRange(tree.root, 6, 8, list );
        tree.print();
        sort(list);
        System.out.println(list);

    }

    private void testReverse() {
        BST<Integer> tree = new BST<Integer>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(7);
        tree.insert(9);
        tree.insert(12);
        tree.print();
        tree.reverseKeys(tree.root);
        tree.print();

    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.testReverse();
    }
}

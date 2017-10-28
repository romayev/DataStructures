import java.util.NoSuchElementException;

public class Stack<T> {
    private LinkedList<T> linkedList;
    int size = 0;

    private Stack() {
        linkedList = new LinkedList<T>();
    }

    Stack(T[] array) {
        linkedList = new LinkedList<T>(array);
        size = array.length;
    }

    private boolean ignore = false;

    private void push(T item) {
        linkedList.addToFront(item);
        if (!ignore) {
            size++;
        }
    }


    private T pop() throws NoSuchElementException {
        T node = linkedList.deleteFirstNode();
        if (!ignore) {
            size--;
        }
        if (node == null) {
            throw new NoSuchElementException();
        } else {
            return node;
        }

    }
    private boolean isEmpty() {
        return linkedList.front == null;
    }

//    public <T> int size(Stack<T> S) {
//        Stack stack = new Stack();
//        int sizeCount = 0;
//
//        while (!S.isEmpty()) {
//            stack.push(S.pop());
//            sizeCount++;
//        }
//        return sizeCount;
//
//    }

    void printStack(Stack<T> stack) {
        ignore = true;
        Stack<T> secondStack = new Stack<T>();
        while (!stack.isEmpty()) {
            T node = stack.pop();
            System.out.println(node);
            secondStack.push(node);
        }
        ignore = false;
        stack.linkedList = secondStack.linkedList;
    }
}


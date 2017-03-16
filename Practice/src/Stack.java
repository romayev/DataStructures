/**
 * Created by Sasha on 2/25/17.
 */
public class Stack<T> {

    private NodeLinkedList<T> linkedList;
    private int size;

    public Stack() {
        linkedList = new NodeLinkedList<T>();
    }

    Stack stack = new Stack();

    public void push(T item) {
        stack = new Node<T> (item, stack);
    }

    public T pop() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = stack.Node.value;
        stack = stack.Node.next;
        return data;
    }

    public boolean isEmpty() {
        return stack == null;
    }


}

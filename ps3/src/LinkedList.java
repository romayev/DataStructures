/**
 * Created by Sasha on 2/5/17.
 */
public class LinkedList {
    //                                                                                                                      rear->null
    //                                                          node->blue
    private static final String[] EXAMPLE_ARRAY = new String[] {"red", "blue", "green", "red", "orange", "blue", "white", "yellow"};

    private Node rear;  // pointer to last node of CLL

    public LinkedList(Node rear) {
        this.rear = rear;
    }

    private static LinkedList createList(String[] array) {
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
        return new LinkedList(rear);
    }

    public boolean delete(String target) {
          /* COMPLETE THIS METHOD */
          return false;
    }

    @Override
    public String toString() {
        String result = "";
        if (rear == null) return result;
        
        Node node = rear;
        while (node.next != rear) {
            result = result  + node;
            node = node.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList list = createList(EXAMPLE_ARRAY);
        System.out.println(list);
        list.delete("red");
        System.out.println(list);
    }
}


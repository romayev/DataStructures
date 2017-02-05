public class Node {
    public String data;
    public Node next;

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        String next = (this.next != null) ? String.valueOf(this.next.data) : "null";
        return data + "->" + next + " ";
    }
}

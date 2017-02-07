public class DLLNode {
    public String data;
    public DLLNode prev;
    public DLLNode next;

    public DLLNode(String data, DLLNode next, DLLNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
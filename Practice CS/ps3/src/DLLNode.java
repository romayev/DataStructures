public class DLLNode {
    public String data;
    public DLLNode prev;
    public DLLNode next;

    public DLLNode(String data, DLLNode next, DLLNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;

    }
    @Override
    public String toString() {
        String next = "null";
        if (this.next != null) {
            next = this.next.data;
        }
        String prev = "null";
        if (this.prev != null) {
            prev = this.prev.data;
        }
        return "[" + prev + "<-" + data + "->" + next + "] ";
    }

}
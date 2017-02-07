public class Main {

    public static DLLNode moveToFront(DLLNode front, DLLNode target){
        if (target == null || front == null){
            return null;
        }
        target.prev.next = target.next; 
        if (target.next != null){
            target.next.prev = target.prev;
        }
        target.next = front;
        target.prev = null;
        front.prev = target;
        return target; 
    }
    public static void main(String[] args) {
        
    }
}

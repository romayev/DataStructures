public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static <T> int size(Stack<String> S) {
        Stack stack = new Stack();
        int sizeCount = 0;

        while (!S.isEmpty()) {
            stack.push(S.pop());
            sizeCount++;
        }

        
    }
}

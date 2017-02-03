public class StringNode {

    private static final String[] STRING_LIST  = new String[] { "Sasha", "Roma", "Julie", "Alex", "Rita", "Kuzya", "Julie", "Peter"};

    public String data;
    public StringNode next;
    
    public StringNode(String data, StringNode next) {
        this.data = data; this.next = next;
    }
    public String toString() {
        return data;
    }

    public static int numberOfOccurrences(StringNode front, String target) {
        int counter = 0;
        if (target == null) {
            return 0;
        }
        for (StringNode ptr = front; ptr != null; ptr = ptr.next) {
            if (target.equals(ptr.data)) {
                counter++;
            }
        }
        return counter;
    }

    private static StringNode createList(String[] array) {
        StringNode node = null;
        for (int i = array.length - 1; i >= 0; i--) {
            String data = array[i];
            node = new StringNode(data, node);
        }
        return node;
    }


    public static void main(String[] args) {

        StringNode family = createList(STRING_LIST);
        int result = numberOfOccurrences(null, "julie");
        System.out.println(result);

        // write your code here
    }
}

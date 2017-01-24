public class Main {

    private static final String STAR = "*";
    private static final int NUMBER_OF_LINES = 10;

    public static void main(String[] args) {
        printStars2();
    }

    private static void printStars1() {
        String line = "";
        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            // Create a new String (allocate object in memory) by taking existing String and adding another 'static' string to it
            line = line + STAR;
            System.out.println(line);
        }
    }

    private static void printStars2() {
        StringBuffer line = new StringBuffer();
        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            // Append 'static' string to existing StringBuffer object
            line.append(STAR);
            System.out.println(line);
        }
    }
}

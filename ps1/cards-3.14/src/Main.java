import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final int TOTAL_CARDS = 52;
    //             A  2  3  4  5  6  7  8  9  10 J  Q  K
    // SPADES:     0  1  2  3  4  5  6  7  8  9  10 11 12
    //  CLUBS:     13 14 15 16 17 18 19 20 21 22 23 24 25
    //  DIAMONDS:  26 27 28 29 30 31 32 33 34 35 36 37 38
    //  HEARTS:    39 40 41 42 43 44 45 46 47 48 49 50 51

    // Create an array to hold cards
    private static int[] cards = new int[TOTAL_CARDS];

    public static void main(String[] args) {
        createDeck();
        System.out.println(Arrays.toString(cards));

        shuffle();
        System.out.println(Arrays.toString(cards));

        unshuffle();
        System.out.println(Arrays.toString(cards));
    }

    private static void createDeck() {
        for (int i = 0; i < TOTAL_CARDS; i++) {
            cards[i] = i;
        }
    }

    private static void shuffle() {

        Random rnd = new Random();
        for (int i = TOTAL_CARDS - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            swapCardsAtIndexes(index, i);
        }
    }

    private static void swapCardsAtIndexes(int idx1, int idx2) {
        int card1 = cards[idx1];
        int card2 = cards[idx2];
        cards[idx1] = card2;
        cards[idx2] = card1;
    }

    private static void unshuffle() {
        // Sort using merge sort: http://www.java2novice.com/java-sorting-algorithms/merge-sort/
    }
}

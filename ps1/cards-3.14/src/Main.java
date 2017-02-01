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

    private static int[] tempDeck;

    public static void main(String[] args) {
        System.out.println("Creating deck...");
        createDeck();
        System.out.println(Arrays.toString(cards));

        System.out.println("Shuffling...");
        shuffle();
        System.out.println(Arrays.toString(cards));

        System.out.println("Unshuffling...");
        unshuffle(tempDeck);
        System.out.println(Arrays.toString(cards));

    }

    private static void createDeck() {
        for (int i = 0; i < TOTAL_CARDS; i++) {
            cards[i] = i;
        }
    }

    private static void shuffle() {
        Random random = new Random();
        for (int i = TOTAL_CARDS - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            swapCardsAtIndexes(index, i);
        }
    }

    private static void swapCardsAtIndexes(int idx1, int idx2) {
        int card1 = cards[idx1];
        int card2 = cards[idx2];
        cards[idx1] = card2;
        cards[idx2] = card1;
    }

    private static void unshuffle(int[] Array) {

        int size = Array.length;
        int mid = size/2;
        int leftside = mid;
        int rightside = size - mid;
        int left[] = new int[leftside];
        int right[] = new int[rightside];

            for (int i = 0; i < mid; i++){
                left[i] = Array[i];
            }

            for (int i = mid; i<size; i++){
                right[i-mid] = Array[i];
            }

        unshuffle(left);
        unshuffle(right);
        merge(left, right, Array);
            
        }
    private static void merge(int[] left, int[] right, int[]arr){

        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0; int j = 0; int k = 0;

        while ( i < leftSize && j < rightSize){

            if (left[i] <= right [j]){
                tempDeck[k] = left[i];
                i++;
                k++;
            } else {
                tempDeck[k] = right[j];
                k++;
                j++;
            }
        }

        while (i < leftSize){
            tempDeck[k]= left[i];
            k++;
            i++;
        }

        while (j < leftSize){
            tempDeck[k] = right[j];
            k++;
            j++;
        }
        

        // Sort using merge sort: http://www.java2novice.com/java-sorting-algorithms/merge-sort/
    }
}

package solitaire;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/**
 * This class implements a simplified version of Bruce Schneier's Solitaire Encryption algorithm.
 *
 * @author RU NB CS112
 */
public class Solitaire {

	/**
	 * Circular linked list that is the deck of cards for encryption
	 */

	CardNode deckRear;

	/**
	 * Makes a shuffled deck of cards for encryption. The deck is stored in a circular
	 * linked list, whose last node is pointed to by the field deckRear
	 */
	public void makeDeck() {
		// start with an array of 1..28 for easy shuffling
		int[] cardValues = new int[28];
		// assign values from 1 to 28
		for (int i=0; i < cardValues.length; i++) {
			cardValues[i] = i+1;
		}

		// shuffle the cards
		Random randgen = new Random();
 	        for (int i = 0; i < cardValues.length; i++) {
	            int other = randgen.nextInt(28);
	            int temp = cardValues[i];
	            cardValues[i] = cardValues[other];
	            cardValues[other] = temp;
	        }

	    // create a circular linked list from this deck and make deckRear point to its last node
	    CardNode cn = new CardNode();
	    cn.cardValue = cardValues[0];
	    cn.next = cn;
	    deckRear = cn;
	    for (int i=1; i < cardValues.length; i++) {
	    	cn = new CardNode();
	    	cn.cardValue = cardValues[i];
	    	cn.next = deckRear.next;
	    	deckRear.next = cn;
	    	deckRear = cn;
	    }
	}

	/**
	 * Makes a circular linked list deck out of values read from scanner.
	 */
	public void makeDeck(Scanner scanner)
	throws IOException {
		CardNode cn = null;
		if (scanner.hasNextInt()) {
			cn = new CardNode();
		    cn.cardValue = scanner.nextInt();
		    cn.next = cn;
		    deckRear = cn;
		}
		while (scanner.hasNextInt()) {
			cn = new CardNode();
	    	cn.cardValue = scanner.nextInt();
	    	cn.next = deckRear.next;
	    	deckRear.next = cn;
	    	deckRear = cn;
		}
		printList(deckRear);
	}

	/**
	 * Implements Step 1 - Joker A - on the deck.
	 */
	private void designateRearNode(CardNode node){
	   if (node == deckRear) {
	   		deckRear = node.next;
	   } else if (node.next == deckRear) {
	   		deckRear = node;
	   }
	}

	private CardNode findNodeBefore(int target){
		CardNode prev = deckRear;
		CardNode curr = deckRear.next;
		while (curr.cardValue != target) {
			prev = curr;
			curr = curr.next;
		}
		return prev;
	}

	private CardNode jokerASwap(CardNode prev) {
		CardNode one = prev;
		CardNode two = prev.next;
		designateRearNode(two);
		CardNode three = prev.next.next;
		CardNode four = three.next;
		one.next = three;
		two.next = four;
		three.next = two;
		return one;
	}

	private CardNode findNodeBeforeJoker(CardNode startNode) {
		CardNode prev = startNode;
		CardNode curr = startNode.next;
		while (curr.cardValue != 27 && curr.cardValue != 28) {
			prev = curr;
			curr = curr.next;
		}
		return prev;
	}

	private void jokerBSwap(CardNode prev) {
		CardNode one = jokerASwap(prev);
		jokerASwap(one.next);
	}

	private CardNode findNodeAtIndex(int index) {
		CardNode current = deckRear.next;
		for (int i = 1; i < index; i++){
			current = current.next;
		}
		return current;
	}

	void jokerA() {
		CardNode prev = findNodeBefore(27);
		jokerASwap(prev);
	}

	/**
	 * Implements Step 2 - Joker B - on the deck.
	 */
	void jokerB() {
		CardNode prev = findNodeBefore(28);
		jokerBSwap(prev);
	}
	/**
	 * Implements Step 3 - Triple Cut - on the deck.
	 */
	void tripleCut() {
		CardNode first = deckRear.next;
		CardNode beforeJoker1 = findNodeBeforeJoker(first);
		CardNode joker1 = beforeJoker1.next;
		CardNode beforeJoker2 = findNodeBeforeJoker(beforeJoker1.next.next);
		CardNode joker2 = beforeJoker2.next;

		if (first == joker1) {
			deckRear = joker2;
		} else if (deckRear == joker2) {
			deckRear = beforeJoker1;
		} else {
			beforeJoker1.next = joker2.next;
			joker2.next = first;
			deckRear.next = joker1;
			deckRear = beforeJoker1;
		}
	}
	/**
	 * Implements Step 4 - Count Cut - on the deck.
	 */
	void countCut() {
        int number = deckRear.cardValue;
        if (number == 28) {
            return;
        }
        CardNode target = findNodeAtIndex(number);
        CardNode originalFrontNode = deckRear.next;
        CardNode secondToLast = findNodeBefore(number);
        deckRear.next = target.next;
        target.next = deckRear;
        secondToLast.next = originalFrontNode;
	}


    /**
	 * Gets a key. Calls the four steps - Joker A, Joker B, Triple Cut, Count Cut, then
	 * counts down based on the value of the first card and extracts the next card value
	 * as key. But if that value is 27 or 28, repeats the whole process (Joker A through Count Cut)
	 * on the latest (current) deck, until a value less than or equal to 26 is found, which is then returned.
	 *
	 * @return Key between 1 and 26
	 */
	int getKey() {
		jokerA();
		jokerB();
		tripleCut();
		countCut();
		CardNode first = deckRear.next;
		int number = first.cardValue;
        if (number == 28) {
            number = 27;
        }
        CardNode target = findNodeAtIndex(number);
        int key = target.next.cardValue;
        while (key == 27 || key == 28) {
            key = getKey();
        }
        return key;
	}
	/**
	 * Utility method that prints a circular linked list, given its rear pointer
	 *
	 * @param rear Rear pointer
	 */
	private static void printList(CardNode rear) {
		if (rear == null) {
			return;
		}
		System.out.print(rear.next.cardValue);
		CardNode ptr = rear.next;
		do {
			ptr = ptr.next;
			System.out.print("," + ptr.cardValue);
		} while (ptr != rear);
		System.out.println("\n");
	}

	/**
	 * Encrypts a message, ignores all characters except upper case letters
	 *
	 * @param message Message to be encrypted
	 * @return Encrypted message, a sequence of upper case letters only
	 */
	public String encrypt(String message) {
		int[] numbers = messageToNumbers(message);
//        System.out.println(Arrays.toString(numbers));
		for (int i = 0; i < numbers.length; i++ ) {
			int result = numbers[i] + getKey();
			if (result > 26) {
				result = result - 26;
			}
			numbers[i] = result;
		}
        String encryptedMessage = numbersToMessage(numbers);
	    return encryptedMessage;
	}
	/**
	 * Decrypts a message, which consists of upper case letters only
	 *
	 * @param message Message to be decrypted
	 * @return Decrypted message, a sequence of upper case letters only
	 */
	public String decrypt(String message) {
		int[] numbers = messageToNumbers(message);
		for (int i = 0; i < numbers.length; i++) {
			int result = numbers[i] - getKey();
			if (result < 1) {
				result = result + 26;
			}
			numbers[i] = result;
		}
		String decryptedMessage = numbersToMessage(numbers);
		return decryptedMessage;
	}

    private int[] messageToNumbers(String message) {
		int[] numbers = new int[message.length()];
		for (int i = 0; i < message.length(); i++) {
			Character character = message.charAt(i);
			character = Character.toUpperCase(character);
			int interger = character - 'A' + 1;
			numbers[i] = interger;
		}
		return numbers;
	}

	private String numbersToMessage(int[] numbers) {
		String message = "";
		for (int i = 0; i < numbers.length; i++) {
			int interger = numbers[i];
			Character c = (char) (interger - 1 + 'A');
			message = message + c;
		}
		return message;
	}
}

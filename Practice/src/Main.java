import java.util.ArrayList;

public class Main {

    private void testStars(){
        int length = 5;

        StarCreator starCreator = new StarCreator();
        starCreator.printStars(length);
    }

    private void songComparer(){
        SongComparer songComparer = new SongComparer();
        String[] playlistOne = new String[]{"tasteless", "creep", "gemini", "youth", "wish I knew you"};
        String[] playlistTwo = new String[]{"cane shuga", "sweetie little Jean", "youth", "tasteless"};

        ArrayList commonSongs = songComparer.comparesSongs(playlistOne, playlistTwo);
        songComparer.printSongs(commonSongs);
    }

    private void testLinkedList1Delete() {
        int[] numberArray = new int[]{1,2,3,4,5,6,7};
        LinkedList linkedList = new LinkedList(numberArray);
        linkedList.print();
        System.out.println();

       linkedList.delete(7);
       linkedList.print();
    }

    private void testLinkedList2Delete() {
        System.out.println("testLinkedList2Delete");
        int[] numberArray = new int[] {1};
        LinkedList2 linkedList2 = new LinkedList2(numberArray);
        linkedList2.print();
        linkedList2.deleteSingle(1);
        System.out.println("target = 1");
        linkedList2.print();
        linkedList2.deleteSingle(4);
        System.out.println("target = 4");
        linkedList2.print();
        linkedList2.deleteSingle(44);
        System.out.println("target = 44");
        linkedList2.print();
        linkedList2.deleteSingle(7);
        System.out.println("target = 7");
        linkedList2.print();
    }

    private void testLinkedListDeleteEveryOther() {
        System.out.println("testLinkedListDeleteEveryOther");
        int[] numberArray = new int[] {1,2,3,4,5,6,7};
        LinkedList2 linkedList2 = new LinkedList2(numberArray);
        linkedList2.print();
        linkedList2.deleteEveryOther3();
        linkedList2.print();
    }
    private void testLinkedListReverse() {
        System.out.println("Reverse list");
        int[] numberArray = new int[] {1,2,3,4,5,6,7};
        LinkedList2 linkedList2 = new LinkedList2(numberArray);
        linkedList2.print();
        linkedList2.reverse();
        linkedList2.print();

    }

    private void testCircularList() {
        int[] numberArray = new int[]{1,2,3,4,5,6,7};
        CircularList circularList = new CircularList(numberArray);
    }

    private void testMoveUpOne() {
        System.out.println ("Moving test");
        int[] numberArray = new int[] {1,2,3,4,5,6};
        LinkedList2 linkedList2 = new LinkedList2(numberArray);
        linkedList2.print();
        linkedList2.moveUpOne(6);
        linkedList2.print();
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.testMoveUpOne();
    }
}

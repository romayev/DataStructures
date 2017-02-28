import java.util.ArrayList;

public class Main {

    public void testStars(){
        int length = 5;

        StarCreator starCreator = new StarCreator();
//        starCreator.printStars(length);
    }

    public void songComparer(){
        SongComparer songComparer = new SongComparer();
        String[] playlistOne = new String[]{"tasteless", "creep", "gemini", "youth", "wish I knew you"};
        String[] playlistTwo = new String[]{"cane shuga", "sweetie little Jean", "youth", "tasteless"};

        ArrayList commonSongs = songComparer.comparesSongs(playlistOne, playlistTwo);
        songComparer.printSongs(commonSongs);
    }

    public void linkedListTest() {
        int[] numberArray = new int[]{1,2,3,4,5,6,7};
//        LinkedList linkedList = new LinkedList(numberArray);
//        linkedList.print();
//        System.out.println();
//
//       linkedList.delete(7);
//       linkedList.print();
        LinkedList2 linkedList2 = new LinkedList2(numberArray);
//        linkedList2.print();
//        linkedList2.delete(1);
//        linkedList2.print();
//        linkedList2.delete(7);
//        linkedList2.print();
//        linkedList2.delete(4);
//        linkedList2.print();
//        linkedList2.delete(44);
//        linkedList2.print();
//        linkedList2.deleteEveryOther();
//        linkedList2.print();
//
    }

    public static void main(String[] args) {
        int[] numberArray = new int[]{1,2,3,4,5,6,7};
        CircularList circularList = new CircularList(numberArray);



    }
}

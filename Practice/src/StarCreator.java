/**
 * Created by Sasha on 2/23/17.
 */
class StarCreator {

    void printStars(int length) {
      String star = "";
      for (int i = 0; i < length; i ++) {
         star = star + "* ";
         System.out.println(star);
      }
    }
}

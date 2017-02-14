public class Main {
    
    public static <T> int size(Stack<T> S) {

       Stack<T> temp = new Stack<T>();
       int ctr = 0;
       while (S.isEmpty()){
           temp.push(S.pop());
           ctr++;
       }
       while (temp.isEmpty()){
           S.push(temp.pop());
       }
       return ctr;
    }
}
//push pop and empty are the operators
//each item is poped & pushed 2x, 4 checks for 'empty' total (one for each push & pop), one more check to end loop
//2n pushes + 2n pops + 2n + 2 = 6n +2
// O(n)
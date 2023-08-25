import java.util.Stack;
import java.util.Scanner;
public class q27 {
    public static void main(String[] args) {
        int array[] = new int[5];
        
        Stack<Integer> s = new Stack<>();

        s.push(10);
        s.push(20);
        s.push(30);

        int peek = s.peek();
        System.out.println(peek);

        s.pop();
        int poppedElement = s.pop();
        System.out.println(poppedElement);
    }
}

import java.util.Scanner;
import java.util.Stack;

public class q29 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your string with a space attached at the end : ");
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        stack.push('c');

        int i = 1;
        char next = s.charAt(0);
        while (next != 'c') {
            if (next == ' ') {
                System.out.println("Invalid String.");
                System.exit(0);
            } else {
                stack.push(next);
                next = s.charAt(i);
                i++;
            }
        }

        while (!stack.peek().equals('c')) {
            next = s.charAt(i);
            i++;
            char x = stack.pop();
            if (next != x) {
                System.out.println("Invalid String.");
                System.exit(0);
            }
        }

        next = s.charAt(i);
        if (next == ' ') {
            System.out.println("It is a valid string.");
        } else {
            System.out.println("Invalid String.");
        }
    }
}
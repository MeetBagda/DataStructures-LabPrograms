import java.util.Stack;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> s = new Stack<>();

        System.out.println("Enter the string with padded ) at rightmost place");
        String str = sc.nextLine();

        String polish = "";
        int rank = 0;

        for (int i = 0; i < str.length(); i++) {
            char next = str.charAt(i);

            if (next == '(') {
                s.push(next);
            } else if (next == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    polish += s.pop();
                }
                if (!s.isEmpty() && s.peek() == '(') {
                    s.pop(); // Pop '(' from the stack.
                } else {
                    System.out.println("Invalid");
                    System.exit(0);
                }
            } else if (Character.isLetterOrDigit(next)) {
                polish += next; // Append operand to the postfix expression.
                rank = rank + calculate(next);
            } else {
                while (!s.isEmpty() && stackPrec(s.peek()) >= inputPrec(next)) {
                    polish += s.pop();
                }
                s.push(next);
            }
        }

        while (!s.isEmpty()) {
            char ch = s.pop();
            if (ch != '(' && ch != ')') {
                polish += ch; // Append any remaining operators to the postfix expression.
            }
        }

        // Check for balanced parentheses and valid rank.
        if (!s.isEmpty() || rank != 1) {
            System.out.println("Invalid");
        } else {
            System.out.println("Valid");
        }
    }

    static int calculate(char temp) {
        return Character.isLetterOrDigit(temp) ? 1 : -1;
    }

    static int stackPrec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 3;
            case '^':
            case '$':
                return 6;
            case '(':
                return 9;
            default:
                return 0;
        }
    }

    static int inputPrec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 4;
            case '^':
            case '$':
                return 5;
            case '(':
                return 0;
            default:
                return 7;
        }
    }
}

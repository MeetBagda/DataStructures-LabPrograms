import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class q25{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Stack s = new Stack();

        int choice;
        do {
            System.out.println("Enter 1 to 5 to choose operation : ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    s.PUSH();
                    s.DISPLAY();
                    break;
                case 2:
                    s.POP();
                    s.DISPLAY();
                    break;
                case 3:
                    s.PEEP();
                    s.DISPLAY();
                    break;
                case 4:
                    s.CHANGE();
                    s.DISPLAY();
                    break;
                case 5:
                    s.DISPLAY();
                    break;
            
                default: 
                    System.out.println("Invalid choice !");
                    break;
            }
        
        } while (choice!=0);

    }
}

class Stack{
    Scanner sc = new Scanner(System.in);
    int TOP=-1;  
    int size;
    Stack(){
        System.out.println("Enter the size of the Stack : ");
        size = sc.nextInt();
    }

    // create a stack using list (Java)
    List<Integer> stack = new ArrayList<>();

    void PUSH(){
        System.out.println("Enter the element to be insert : ");
        int n = sc.nextInt();
        if(TOP>size){
            System.out.println("Stack Overflow");
        }else{
            TOP++;
            stack.add(TOP, n);
        }
    }

    void POP(){
        if(TOP<0){
            System.out.println("Stack Underflow");
            return;
        }else{
            int temp = stack.remove(TOP);
            TOP--;
            System.out.println("Popped : "+temp);
        }
    }

    void PEEP(){
        System.out.println("Enter the index : ");
        int index = sc.nextInt();
        if(TOP-index+1<=0){
            System.out.println("Stack Underflow");
            return;
        }else{
            System.out.println("Peeped : "+stack.get(TOP-index+1));
        }
    }

    void CHANGE(){
        System.out.println("Enter the index : ");
        int index = sc.nextInt();
        System.out.println("Enter the number : ");
        int num = sc.nextInt();
        if(TOP-index+1<=0){
            System.out.println("Stack Underflow");
            return;
        }else{
            stack.set(TOP-index+1, num);
            System.out.println("Successfully changed !");
            return;
        }
    }

    void DISPLAY(){
        for (int i = stack.size()-1; i >= 0; i--) {
            System.out.print(stack.get(i)+",");
        }
        System.out.print("\b");
    }
}
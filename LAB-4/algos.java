import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class algos{
    public static void main(String[] args) {
        
        Stack s = new Stack();
        
        s.PUSH(10);
        s.PUSH(11);
        s.PUSH(12);
        s.PUSH(13);
        s.PUSH(14);

        int popped = s.POP();
        System.out.println("Pop : "+popped);

        int peeped = s.PEEP(3);
        System.out.println("Peep : "+peeped);

        s.CHANGE(2, 20);
        
        s.DISPLAY();

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

    void PUSH(int n){
        if(TOP>size){
            System.out.println("Stack Overflow");
        }else{
            TOP++;
            stack.add(TOP, n);
        }
    }

    int POP(){
        if(TOP<0){
            System.out.println("Stack Underflow");
            return 0;
        }else{
            int temp = stack.remove(TOP);
            TOP--;
            return temp;
        }
    }

    int PEEP(int index){
        if(TOP-index+1<=0){
            System.out.println("Stack Underflow");
            return 0;
        }else{
            return stack.get(TOP-index+1);
        }
    }

    void CHANGE(int index,int num){
        if(TOP-index+1<=0){
            System.out.println("Stack Underflow");
            return;
        }else{
            stack.set(TOP-index+1, num);
            System.out.println("Successfully changed");
            return;
        }
    }

    void DISPLAY(){
        System.out.println(stack);
    }
}
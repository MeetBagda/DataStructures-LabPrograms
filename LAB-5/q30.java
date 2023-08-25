import java.util.*;
import java.util.Stack;

public class q30 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("enter a string to recognize:");
        String str = scn.next();
        
        boolean x = inputInStake(str);

        if(x==false) {
            System.out.println("this string is not valid");
        }else{
            System.out.println("this string is valid");            
        }
        
        
        
    }
    
    static public boolean inputInStake(String str){
        
        int length = str.length();
        int lenhalf = length/2;
        if(length%2 != 0){
            return false;
        }

        Stack<Character> stake = new Stack<Character>();
    
        for(int i = 0; i < lenhalf; i++){
            char x = str.charAt(i);
    
            if(x != 'b'){
                stake.push(x);
            }
            else{
                return false;
            }
        }

        for(int i = lenhalf; i < length; i++){
            char y = str.charAt(i);

            if(y != 'a'){
                stake.push(y);

            }
            else{
                return false;
            }
        }
    
        return true;
    }


}


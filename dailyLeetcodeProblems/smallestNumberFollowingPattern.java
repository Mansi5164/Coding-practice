import java.util.Scanner;
import java.util.Stack;

public class smallestNumberFollowingPattern {
    public static void printSmallestNumber(String str, int n){
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            if(ch == 'd'){
                stack.push(num);
                num++;
            }
            else{
                stack.push(num);
                num++;
                while(!stack.isEmpty()){
                    System.out.print(stack.pop()+" ");
                }
            }
        }
        // num++;
        stack.push(num);
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        printSmallestNumber(str,n);

        sc.close();
    }
}

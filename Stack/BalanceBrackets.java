// package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBrackets {
    public static boolean balancedBracets(String str){
        int i=0;
        Stack<Character> stack = new Stack<>();
        int length = str.length();

        while(i<length){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch=='{'){
                stack.push(ch);
            }
            else if(ch == ')' || ch == ']' || ch=='}' ){
                if(ch == ')' && stack.peek() == '('){
                    stack.pop();
                }
                else if(ch == ']' && stack.peek() == '['){
                    stack.pop();
                }
                else if(ch == '}' && stack.peek() == '{'){
                    stack.pop();
                }
                else return false;
            }
            i++;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter string : ");
        String str = sc.nextLine();

        boolean flag = balancedBracets(str);
        System.out.println(flag);

        sc.close();
    }
}

/*
enter string : [(a+b)+{(c+d)*(e/f)}]
true

enter string : [(a+b)+{(c+d)*(e/f)]}
false
 */
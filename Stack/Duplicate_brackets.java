import java.util.Scanner;
import java.util.Stack;

public class Duplicate_brackets {
    boolean duplicateBrackets(String s){
        Stack<Character> st = new Stack<>();
        int i=0, len = s.length();

        while(i < len){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                if(st.isEmpty()){
                    System.out.println("invalid expression");
                    return false;
                }
                while(!st.isEmpty() && st.peek() != '('){
                    st.pop();
                }
                st.pop();
            }
            else{
                st.push(ch);
            }
            i++;
        }
        if(st.isEmpty()) return false;
        else return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter string : ");
        String str = sc.nextLine();

        Duplicate_brackets obj = new Duplicate_brackets();
        boolean flag = obj.duplicateBrackets(str);
        System.out.println(flag);

        sc.close();
    }
}


/*
enter string : ((A+B)+(C+D))
false
enter string : ((a+b))+(c+d)
true
 */
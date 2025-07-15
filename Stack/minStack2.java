import java.util.Scanner;
import java.util.Stack;

public class minStack2 {
    public static class CustomStack{
        Stack<Integer> data;
        int min;
        CustomStack(){
            this.data = new Stack<>();
        }
        void push(int val){
            if(data.size() == 0){
                data.push(val);
                min = val;
            }
            else if(val >= min){
                data.push(val);
            }
            else{
                data.push(val+(val-min));
                min = val;
            }
        }
        int pop(){
            if(data.size()==0){
                System.out.println("stack underflow");
                return -1;
            }
            else{
                if(data.peek() > min){
                    return data.pop();
                }
                else{
                    int originalVal = min;
                    min = 2*min-data.peek();
                    return originalVal;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CustomStack obj = new CustomeStack();
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            obj.push(x);
        }
    }
}

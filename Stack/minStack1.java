import java.util.Scanner;
import java.util.Stack;

public class minStack1 {
    public static class customMinStack {
        
        Stack<Integer> minData;
        Stack<Integer> allData;

        customMinStack(){
            this.minData = new Stack<>();
            this.allData = new Stack<>();
        }

        public void push(int val){
            allData.push(val);
            if(minData.size() == 0 || minData.peek() >= val){
                minData.push(val);
            }
        }

        public int top(){
            if(allData.size()==0){
                System.out.println("stack underflow");
                return -1;
            }
            else{
                return allData.peek();
            }
        }
    
        public int min(){
            if(minData.size()==0){
                System.out.println("stack underflow");
                return -1;
            }
            else return minData.peek();
        }

        public int pop(){
            if(allData.size()==0){
                System.out.println("stack underflow");
                return -1;
            }
            else{
                int val = allData.pop();
                if(val == minData.peek()){
                    minData.pop();
                }
                return val;
            }
        }
        void display(){
            while(allData.size() > 0){
                System.out.print(allData.pop()+" ");
            }
            System.out.println();
        }
        void displayMinStack(){
            while(minData.size() > 0){
                System.out.print(minData.pop()+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        customMinStack obj = new customMinStack();
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            obj.push(x);
        }
        obj.display();
        obj.displayMinStack();
        sc.close();
    }
}

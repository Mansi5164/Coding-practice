import java.util.Scanner;
import java.util.Stack;
public class stockSpan {
    public static int[] nextGreaterElementOnLeft(int arr[] , int n){
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int result[] = new int[n];
        while(i < n){
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(i);
                result[i] = i+1;
            }
            else{
                int x= stack.peek();
                stack.push(i);
                result[i] = i-x;
            }
            i++;
        }
        return result;
    }
    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("enter size :");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("enter all the elements : ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        int stockSpanArray[] = nextGreaterElementOnLeft(arr,n);
        printArray(stockSpanArray,n);

        sc.close();

    }
}


/*
enter size :9
enter all the elements : 2 5 9 3 1 12 6 8 7
1 2 3 1 1 6 1 2 1


 */
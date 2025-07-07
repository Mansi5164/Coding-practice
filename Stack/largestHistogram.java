import java.util.Scanner;
import java.util.Stack;

public class largestHistogram {
    public static int[] nextSmallerElementOnLeft(int arr[],int n){
        int result[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(i < n){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(i);
                result[i] = -1;
            } else {
                int x = stack.peek();
                stack.push(i);
                result[i] = x;
            }
            i++;
        }

        return result;
    }
    public static int[] nextSmallerElementOnRight(int arr[],int n){
        int result[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        int i=n-1;
        while(i >= 0){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(i);
                result[i] = n;
            } else {
                int x = stack.peek();
                stack.push(i);
                result[i] = x;
            }
            i--;
        }

        return result;
    }
    public static int largestHistogramArea(int arr[],int NSER[],int NSEL[],int n){
        int maxArea = 0;
        for(int i=0;i<n;i++){
            int width = NSER[i] - NSEL[i] -1;
            int area = width * arr[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
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

        int nextSmallerElementOnLeft[] = nextSmallerElementOnLeft(arr, n);
        printArray(nextSmallerElementOnLeft,n);
        System.out.println();

        int nextSmallerElementOnRight[] = nextSmallerElementOnRight(arr, n);
        printArray(nextSmallerElementOnRight, n);
        System.out.println();

        int maxArea = largestHistogramArea(arr, nextSmallerElementOnRight, nextSmallerElementOnLeft, n);
        System.out.println("maximum area :"+maxArea);
        sc.close();

    }
}

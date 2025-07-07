import java.util.Scanner;
import java.util.Stack;

public class next_greater_element_on_right {
    public static void nextGreaterElementOnRight(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        int i = n - 1;
        while (i >= 0) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                arr[i] = -1;
            } else {
                int x = stack.peek();
                stack.push(arr[i]);
                arr[i] = x;
            }
            i--;
        }
    }

    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter size : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("enter the elements of an array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        nextGreaterElementOnRight(arr, n);
        printArray(arr, n);

        sc.close();
    }
}

/*
 * enter size : 9
 * enter the elements of an array : 2 5 9 3 1 12 6 8 7
 * 5 9 12 12 12 -1 8 -1 -1
 * 
 * 
 * enter size : 5
 * enter the elements of an array : 5 4 3 2 1
 * -1 -1 -1 -1 -1
 * 
 * 
 * enter size : 6
 * enter the elements of an array : 2 9 1 12 3 15
 * 9 12 12 15 15 -1
 */
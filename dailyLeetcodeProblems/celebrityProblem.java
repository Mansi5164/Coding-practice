/*
Celebrity is :
1. Known by everybody
2. but knows nobody 
 */

import java.util.Scanner;
import java.util.Stack;

public class celebrityProblem{
    public static int checkCelebrity(int arr[][],int n){
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            stack.push(i);
        }

        while(stack.size()>=2){
            int n1 = stack.pop();
            int n2 = stack.pop();

            if(arr[n1][n2] == 1){
                // it means n1 knows n2 that's why n1 is celebrity is not possible 
                stack.push(n2);
            }
            else{
                stack.push(n1);
            }
        }
        
        int last_element = stack.pop();
        if(arr[last_element][last_element] != 0){
            System.out.println("none");
            return 0;
        }
        for(int i=0;i<n;i++){
            if(i != last_element){
                if(arr[i][last_element] == 0 || arr[last_element][i] == 1){
                    System.out.println("none");
                    return ans;
                }
            }
        }
        return last_element;
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("enter size of 2d-array : ");
        int n = sc.nextInt();

        int arr[][] = new int[n][n];
        System.out.println("enter all the elements of 2d-array : ");

        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                arr[i][j]= sc.nextInt();
            }
        }

        int celebrity = checkCelebrity(arr,n);
        System.out.println("ans is : "+celebrity);

        sc.close();
    }
}


/*
enter size of 2d-array : 4
enter all the elements of 2d-array : 
0 1 1 1 
1 0 1 0
0 0 1 0
1 1 1 0
ans is : 0
 */
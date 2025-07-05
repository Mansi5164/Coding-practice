// package Arrays;

import java.util.Scanner;

public class Bar_chart {
    public static int maximum(int arr[] , int n){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max < arr[i]) max = arr[i];
        }
        return max;
    }
    public static void printBarChart(int arr[],int n,int rows){
        for(int i=rows;i>0;i--){
            for(int j=0;j<n;j++){
                if(arr[j] >= i){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter size : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("enter elements : ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int rows = maximum(arr, n);
        printBarChart(arr,n,rows);
    }
}


/*

enter size : 5
enter elements : 3 1 0 7 5 
      *
      *
      * *
      * *
*     * *
*     * *
* *   * *

 */
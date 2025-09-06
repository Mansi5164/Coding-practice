import java.util.Scanner;

public class CountingSort {

    public static int maximum(int arr[] , int n){
        int max = Integer.MIN_VALUE;
        for (int idx = 0; idx < arr.length; idx++) {
            max = Math.max(max, arr[idx]);
        }
        return max;
    }
    public static int[] sort(int arr[], int n){
        int maxEle = maximum(arr,n);
        int count[] = new int[maxEle+1];

        //fill values int count array
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }

        //update count array by adding up its previous values
        for(int i=1;i<=maxEle;i++){
            count[i] += count[i-1];
        }

        //fill the output array
        int result[] = new int[n];

        for(int i=n-1;i>=0;i--){
            int countArrayIndex = arr[i];
            int resultArrayIndex = count[countArrayIndex]-1;
            result[resultArrayIndex] = arr[i];
            count[countArrayIndex]-=1;
        }

        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter size of an array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.print("enter the elements of an array : ");
        for(int i=0;i<size;i++) arr[i] = sc.nextInt();

        int result[] = sort(arr, size);
        //after sorting print the element
        System.out.print("After sorting the elements of an array : ");
        for(int i=0;i<size;i++) System.out.print(result[i]+" ");
        
    }
}


/*

enter size of an array : 9
enter the elements of an array : 2 1 0 6 8 1 2 5 8
After sorting the elements of an array : 0 1 1 2 2 5 6 8 8 

 */
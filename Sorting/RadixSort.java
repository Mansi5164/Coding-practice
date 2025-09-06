import java.util.Scanner;

public class RadixSort {
    public static int maximum(int arr[] , int n){
        int max = Integer.MIN_VALUE;
        for (int idx = 0; idx < arr.length; idx++) {
            max = Math.max(max, arr[idx]);
        }
        return max;
    }
    public static int countDigits(int n){
        int digit = 0;

        while(n != 0){
            digit++;
            n/=10;
        }
        return digit;
    }

    public static void RadixSortAlgo(int arr[]){
        int n = arr.length;
        int maxEle = maximum(arr, n);
        int digit = countDigits(maxEle);
        for (int exp = 1; maxEle / exp > 0; exp *= 10) {
            CountingSortWithDigit(arr, exp);
        }
    }

    public static void CountingSortWithDigit(int[] arr, int digit){
        int n = arr.length , k = 9;
        int result[] = new int[n] , count[] = new int[k+1];

        //fill count array
        for (int i = 0; i < n; i++) {
            int index = (arr[i]/digit)%10;
            count[index]++;
        }

        //find cumulative frequency
        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        for(int i = n-1;i>=0;i--){
            int countArrayIndex = (arr[i]/digit)%10;
            int resultArrayIndex = count[countArrayIndex]-1;
            result[resultArrayIndex] = arr[i];
            count[countArrayIndex]-=1;
        }

        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = result[idx];
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter size of an array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.print("enter the elements of an array : ");
        for(int i=0;i<size;i++) arr[i] = sc.nextInt();

        RadixSortAlgo(arr);
        //after sorting print the element
        System.out.print("After sorting the elements of an array : ");
        for(int i=0;i<size;i++) System.out.print(arr[i]+" ");
        
    }
}

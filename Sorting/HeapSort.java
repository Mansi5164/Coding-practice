import java.util.Scanner;

public class HeapSort {
    public static void Heapify(int arr[] , int n , int i){
        int largest = i;    //0 -> 53
        int left = 2*i+1;    //1 -> 54
        int right = 2*i+2;   //2 -> 55

        if(left < n && arr[largest] < arr[left]){
            largest = left;
        }
        if(right < n && arr[largest] < arr[right]){
            largest = right;
        }

        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            Heapify(arr, n, largest);
        }
    }

    public static void heapSortAlgo(int arr[],int n){
        int i = n-1;
        while(i>0){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            i--;
            Heapify(arr, n, 0);
            
        }
    }

    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter size of an array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("enter all the elements of an array : ");
        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = sc.nextInt();
        }

        for(int i = (n/2)-1;i>=0;i--){
            Heapify(arr, n, i);
        }
        System.out.print("After Heapify the elements of an array : ");
        for (int idx = 0; idx < arr.length; idx++) {
            System.out.print(arr[idx]+" ");
        }
        System.out.println();
        heapSortAlgo(arr, n);
        System.out.print("After sorting the elements of an array : ");
        for (int idx = 0; idx < arr.length; idx++) {
            System.out.print(arr[idx]+" ");
        }

    }
}


/*
enter size of an array : 5
enter all the elements of an array : 54 53 55 52 50
After Heapify the elements of an array : 55 53 54 52 50 
After sorting the elements of an array : 55 54 53 50 52

 */
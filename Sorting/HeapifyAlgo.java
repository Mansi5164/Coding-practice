import java.util.Scanner;

public class HeapifyAlgo {
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

    }
}

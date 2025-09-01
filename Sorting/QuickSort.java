import java.util.Scanner;

public class QuickSort {
    public static int partition (int arr[] ,int st , int end){
        int index = -1,pivot = arr[end];
        for(int j=0;j<end;j++){
            if(arr[j] <= pivot){
                index++;
                //move the lesser elements to pivot left side
                int temp = arr[j];
                arr[j] = arr[index];
                arr[index] = temp;
            }
        }
        index++;
        // place the pivot element to its correct position
        int temp = arr[end];
        arr[end] = arr[index];
        arr[index] = temp;
        return index;
    }
    public static void quickSort(int arr[],int start, int end){
        if(start < end){
            int pivotInd = partition(arr,start, end);
            quickSort(arr,start, pivotInd-1);
            quickSort(arr, pivotInd+1,end);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter size of an array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.print("enter the elements of an array : ");
        for(int i=0;i<size;i++) arr[i] = sc.nextInt();

        quickSort(arr, 0, size-1);
        //after sorting print the element
        System.out.print("After sorting the elements of an array : ");
        for(int i=0;i<size;i++) System.out.print(arr[i]+" ");
        
    }
}


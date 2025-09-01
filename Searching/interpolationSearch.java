
import java.util.Scanner;

public class interpolationSearch {
    public static int checkPresentOrNot(int arr[],int target){
        int n = arr.length , start = 1, end = n-1, index = -1;
        while(start <= end){
            int pos = start + (target-arr[start]) * (end-start)/(arr[end]-arr[start]);
            if(arr[pos] == target){
                index = pos;
                break;
            }
            else if(arr[pos] < target){
                start = pos+1;
            }
            else end = pos -1;
        }
        return index;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter size of an array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.print("enter the element of an array : ");
        for(int i=0;i<size;i++) arr[i] = sc.nextInt();

        System.out.print("enter element which you want to found : ");
        int target = sc.nextInt();

        int index = checkPresentOrNot(arr, target);
        if(index != -1){
            System.out.println(target+" is present at index "+index);
        }
        else System.out.println(target+" is not present...");
    }
}

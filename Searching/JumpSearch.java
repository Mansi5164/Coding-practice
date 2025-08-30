import java.util.*;

public class JumpSearch {
    public static int  checkPresentOrNot(int arr[] , int target){
        int n = arr.length;
        int blockSize = (int)Math.sqrt(n);
        int start = 0, end = blockSize;
        while(end < n && arr[end] <= target){
            start = end;
            end = end +blockSize;
        }
        int index = -1;
        for(int i= start;i<=end;i++){
            if(arr[i] == target){
                index = i;
                break;
            }
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

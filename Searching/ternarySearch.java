// package Searching;

import java.util.Scanner;

public class ternarySearch {
    public static int checkPresentOrNot(int arr[],int target){
        int index = -1 , n = arr.length;
        int start = 0, end = n-1;
        while(start <= end){
            int mid1 = start + (end-start)/3;
            int mid2 = end - (end-start)/3;

            if(target <= arr[mid1]){
                if(target == arr[mid1]){
                    index = mid1;
                    break;
                }
                end = mid1-1;
            }
            else if(target >= arr[mid2]){
                if(target == arr[mid2]){
                    index = mid2;
                    break;
                }
                start = mid2+1;
            }
            else{
                start = mid1+1;
                end = mid2-1;
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

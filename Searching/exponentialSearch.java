// package Searching;

import java.util.Scanner;

public class exponentialSearch {
    public static int binarySearch(int[] arr, int target , int start,int end){
        int index = -1;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target){
                index = mid;
                break;
            }
            else if(arr[mid]<target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return index;
    }
    public static int checkPresentOrNot(int arr[],int target){
        int n = arr.length , start = 1;
        while(start < n && arr[start] <= target){
            start *= 2;
        }
        int end = Math.min(start,n-1);
        int index = binarySearch(arr, target, start/2,end);
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

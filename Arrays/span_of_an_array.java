import java.util.Scanner;

class span_of_an_array{
    public static int maximum(int arr[] , int n){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max < arr[i]) max = arr[i];
        }
        return max;
    }
    public static int minimum(int arr[] , int n){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(min > arr[i]) min = arr[i];
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter size : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("enter elements : ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int minimum = minimum(arr, n);
        int maximum = maximum(arr, n);
        System.out.println("span of an array : "+(maximum-minimum));
    }
}

/*
enter size : 6
enter elements : 15 30 40 4 9 11
span of an array : 36
 */
import java.util.Scanner;
public class printDecreasingNumber {
    public static void printDecreasing(int n){
        if(n==0)return ;
        else{
            System.out.println(n);
            printDecreasing(n-1);
        }
    }
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printDecreasing(n);

        sc.close();
    }
}

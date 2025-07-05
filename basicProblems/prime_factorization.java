package basicProblems;
import java.util.Scanner;

public class prime_factorization {
    public static void primeNumber(int n){

        //brute force approach
        for(int div = 2;div*div <= n;div++){
            while(n % div == 0){
                System.out.print(div+" ");
                n /= div;
            }
        }
        if(n!=1){
            System.out.print(n);
        }
    }
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print("enter number : ");
        int num = sc.nextInt();

        primeNumber(num);

        sc.close();
    }
}

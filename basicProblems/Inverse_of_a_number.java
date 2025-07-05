package basicProblems;
import java.util.Scanner;

public class Inverse_of_a_number {
    public static int inverseOfNumber(int n){
        int ans = 0 , element=1;
        while(n!=0){
            int pos = n % 10;
            ans += element * (int)Math.pow(10,pos-1);
            n /= 10;
            element++;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number : ");
        int n = sc.nextInt();

        int ans = inverseOfNumber(n);
        System.out.println(ans);

        sc.close();
    }
}

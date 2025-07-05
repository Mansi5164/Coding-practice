package playlistProblem;
import java.util.Scanner;

public class GCD_LCM {
    public static int greatestCommonDivisor(int n1 , int n2){
        while(n1 % n2 != 0){
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        return n2;
    }
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int on1 = n1;
        int on2 = n2;

        int gcd = greatestCommonDivisor(n1,n2);
        int lcm = (on1*on2)/gcd;

        System.out.println("Greatest Common Divisor is : "+ gcd + "\nLowest Common Multiple is : "+ lcm);

        sc.close();
    }
}

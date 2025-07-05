package basicProblems;
// package playlistProblem;
import java.util.Scanner;

public class decimal_to_any_base {
    public static int decimalToAnyBase(int n,int base){
        int ans = 0, m = 1;
        while(n != 0){
            int rem = n % base;
            ans += rem * m;
            m *= 10;
            n /= base;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number : ");
        int num = sc.nextInt();
        System.out.print("enter base : ");
        int base = sc.nextInt();
        int ans = decimalToAnyBase(num,base);
        System.out.println(ans);
        sc.close();
    }
}


/*
enter number : 634
enter base : 8
1172

enter number : 57
enter base : 2
111001
 */
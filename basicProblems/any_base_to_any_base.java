package basicProblems;
// package playlistProblem;

import java.util.Scanner;

public class any_base_to_any_base {
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
    public static int AnyBaseTodecimal(int n,int base){
        int ans = 0, m = 0;
        while(n != 0){
            int rem = n % 10;
            ans += rem * (int)Math.pow(base,m);
            m++;
            n /= 10;
        }
        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("enter number : ");
        int num = sc.nextInt();
        System.out.print("enter base 1 : ");
        int base1 = sc.nextInt();
        System.out.print("enter base 2 : ");
        int base2 = sc.nextInt();

        int decimalNumber = AnyBaseTodecimal(num,base1);
        int ans = decimalToAnyBase(decimalNumber,base2);

        System.out.println(ans);
        sc.close();
    }
}

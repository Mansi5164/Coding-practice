package basicProblems;
// package playlistProblem;

import java.util.Scanner;

public class Any_base_to_decimal {
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
        System.out.print("enter base : ");
        int base = sc.nextInt();
        int ans = AnyBaseTodecimal(num,base);
        System.out.println(ans);
        sc.close();
    }
}

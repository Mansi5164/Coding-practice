package basicProblems;
import java.util.Scanner;

class any_base_addition{
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
        
        System.out.print("enter base : ");
        int base = sc.nextInt();
        System.out.print("enter number : ");
        int n1 = sc.nextInt();
        System.out.print("enter number : ");
        int n2 = sc.nextInt();

        int n3 = AnyBaseTodecimal(n1,base);
        int n4 = AnyBaseTodecimal(n2,base);

        int sum = n3+n4;
        int ans = decimalToAnyBase(sum,base);
        System.out.println(ans);
        sc.close();
    }
}
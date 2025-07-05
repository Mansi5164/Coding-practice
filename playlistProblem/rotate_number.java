package playlistProblem;
import java.util.Scanner;

public class rotate_number {
    public static int rotateNumber(int n,int k){
        int totalDigit = 0,ans=0;
        int od = n;
        while(od != 0){
            od/=10;
            totalDigit++;
        }
        if(k > 0){
            int lastDig = n % (int)Math.pow(10,k);
            n = n / (int)Math.pow(10,k);
            lastDig = lastDig * (int)Math.pow(10,totalDigit-k);
            ans = lastDig+n;
        }
        else{
            int lastDig = n % (int)Math.pow(10,totalDigit+k);
            n = n / (int)Math.pow(10,totalDigit+k);
            lastDig = lastDig * (int)Math.pow(10,k*(-1));
            ans = lastDig+n;
        }
        return ans;
    }
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print("enter number : ");
        int num = sc.nextInt();
        System.out.print("enter rotation number : ");
        int k = sc.nextInt();

        int ans = rotateNumber(num,k);
        System.out.println(ans);

        sc.close();
    }
}

/*

enter number : 562984 
enter rotation number : -4
845629

enter number : 562984
enter rotation number : 2
845629

 */
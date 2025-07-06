import java.util.Scanner;

public class differenceOfTwoArrays {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
    
        System.out.print("enter size of 1st array: ");
        int n1 = sc.nextInt();
        int A1[] = new int[n1]; 
        System.out.print("enter elements of array 1 : ");
        for(int i=0;i<n1;i++) A1[i] = sc.nextInt();

        System.out.print("enter size of 2nd array: ");
        int n2 = sc.nextInt();
        int A2[] = new int[n2];
        System.out.print("enter elements of array 2 : ");
        for(int i=0;i<n2;i++) A2[i] = sc.nextInt();

        int diff[] = new int[n2];
        
        int i=A1.length - 1;
        int j=A2.length - 1;
        int k=diff.length - 1;
        int carry = 0;

        //subtract A1 from A2 array and create diff array 
        while(k >= 0){
            int d =0;
            int A1val = i>=0 ? A1[i] : 0;

            if(A2[j]+carry >= A1val){
                d = A2[j]+carry-A1val;
            }
            else{
                d = A2[j] + carry + 10 - A1[i];
                carry = -1;
            }
            diff[k] = d;
            i--;
            k--;
            j--;
        }

        //print difference array 
        System.out.println("difference array : ");
        for(int l=0;l<n2;l++){
            System.out.print(diff[l]+" ");
        }

        sc.close();
    }
}


/*

OUTPUT: 
enter size of 1st array: 5
enter elements of array 1 : 2 3 4 6 9
enter size of 2nd array: 6
enter elements of array 2 : 1 1 1 1 1 1 
difference array : 
0 8 7 6 4 2

 */
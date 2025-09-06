// package String;

import java.util.Scanner;

public class naivePattern {
    public static boolean patternFoundOrNot(String text , String pattern){
        int comp = 0;
        int n = text.length();
        int m = pattern.length();
        for(int i=0;i<=n-m;i++){
            int j = 0;
            for(;j<m;j++){
                if(pattern.charAt(j)!=text.charAt(i+j)){
                    comp++;
                    break;
                }
            }
            if(j == pattern.length()) return true;
        }
        System.out.println(comp);
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter text : ");
        String text = sc.nextLine();
        System.out.print("enter pattern : ");
        String pattern = sc.nextLine();
        boolean found = patternFoundOrNot(text,pattern);
        if(found){
            System.out.println("pattern found 😁");
        }else{
            System.out.println("pattern not found 😒");
        }
    }
}

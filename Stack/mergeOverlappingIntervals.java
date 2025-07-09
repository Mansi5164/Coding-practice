import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;
public class mergeOverlappingIntervals {
    public static class Pair implements Comparable<Pair>{
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
        //this > other return +ve;
        //this = other return 0;
        //this < other return -ve;
        public int compareTo(Pair other){
            if(this.start != other.start){
                return this.start - other.start;
            }
            else{
                return this.end-other.end;
            }
        }
    }
    public static void mergeOverlappingInterval(int arr[][],int n){
        Pair pairs[] = new Pair[n];

        for(int i=0;i<n;i++){
            pairs[i] = new Pair(arr[i][0],arr[i][1]);
        }

        Arrays.sort(pairs);     //it internally checks pairs[i].compareTo(pairs[j])

        Stack<Pair> stack = new Stack<>();
        for(int i=0;i<pairs.length;i++){
            if(i==0) stack.push(pairs[i]);
            else{
                Pair top = stack.peek();
                if(top.end < pairs[i].start){
                    stack.push(pairs[i]);
                }
                else{
                    top.end = Math.max(top.end,pairs[i].end);
                }
            }
        }

        Stack<Pair> stack2 = new Stack<>();
        while(!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        printIntervals(stack2);
    }
    public static void printIntervals(Stack<Pair> stack){
        System.out.println("after merging intervals would be : ");
        while(stack.size() > 0){
            Pair top = stack.pop();
            System.out.println(top.start + " " + top.end);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number of rows : ");
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        System.out.println("enter all the elements of an array : ");
        for(int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        mergeOverlappingInterval(arr, n);
        sc.close();
    }
}


/*
enter number of rows : 6
enter all the elements of an array : 
22 28
1 8
25 27
14 19
27 30
5 12
after merging intervals would be : 
1 12
14 19
22 30
 */
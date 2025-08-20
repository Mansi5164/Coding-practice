import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class mirrorImage {
    static class Node{
        int data;
        int size;
        ArrayList<Node> children = new ArrayList<>();
        Node(){

        }
        Node(int data){
            this.data = data;
            this.size = 0;
        }
    }
    public static int size(Node root){
        int size = 0;
        for(Node child:root.children){
            int childSize = size(child);
            size += childSize;
        }
        size += 1;
        return size;
    }

    // public static List<Integer> traversaList1(Node root){
    //     List<Integer> list = new ArrayList<>();

    //     return list;
    // }
    
    public static void mirror(Node root){
        for(Node child : root.children){
            mirror(child);
        }
        Collections.reverse(root.children);
    }
    public static int maximum(Node root){
        int max = root.data;
        for(Node child:root.children){
            int num = maximum(child);
            max = Math.max(max,num);
        }
        return max;
    }
    public static int minimum(Node root){
        int min = root.data;
        for(Node child:root.children){
            int num = minimum(child);
            min = Math.min(min,num);
        }
        return min;
    }
    public static List<Integer> levelOrderTraversal(Node root){
        List<Integer> list = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        list.add(null);
        q.add(root);

        while(q.size() > 0){
            int length = q.size();
            for(int i=0;i<length;i++){
                root = q.remove();
                list.add(root.data);
                for(Node child:root.children){
                    q.add(child);
                }
            }
            if(q.size() > 0) list.add(null);
        }
        return list;
    }
    public static void traversaList2(Node root){
        System.out.print(root.data + " -> ");
        for(Node child : root.children){
            traversaList2(child);
        }
    }

    public static void removeLeaves(Node root){
        for(int i=root.children.size()-1;i>=0;i--){
            Node child = root.children.get(i);
            if(child.children.size()==0){
                root.children.remove(child);
            }
        }
        for(Node child : root.children){
            removeLeaves(child);
        }
    }

    public static void linearize(Node root){
        for(Node child:root.children){
            linearize(child);
        }

        while(root.children.size() > 1){
            Node lc = root.children.remove(root.children.size()-1);
            Node sl = root.children.get(root.children.size()-1);
            Node slt = getTail(sl);
            slt.children.add(lc);
        }
    }
    public static Node getTail(Node root){
        while(root.children.size() == 1){
            root = root.children.get(0);
        }
        return root;
    }

    public static Node linearize2(Node root){
        if(root.children.isEmpty()) return root;
        Node lastNodeTail = linearize2(root.children.get(root.children.size()-1));
        while(root.children.size() > 1){
            Node last = root.children.remove(root.children.size()-1);
            Node secondLast = root.children.get(root.children.size()-1);
            Node secondLastKiTail = linearize2(secondLast);
            secondLastKiTail.children.add(last);
        }
        return lastNodeTail;
    }

    public static boolean findChildren(Node root,int data){
        if(root.data == data) return true;

        for(Node child : root.children){
            boolean flag = findChildren(child, data);
            if(flag) return true;
        }
        return false;

    }

    public static ArrayList<Integer> nodeToRootPath(Node root,int data){
        if(root.data == data){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(root.data);
            return arr;
        }
        for(Node child : root.children){
            ArrayList<Integer> ptc = nodeToRootPath(child,data);
            if(!ptc.isEmpty()){
                ptc.add(root.data);
                return ptc;
            }
            
        }
        return new ArrayList<>();
    }

    public static int lowestCommonAncestor(Node root,int d1,int d2){

        ArrayList<Integer> list1 = nodeToRootPath(root, d1);
        ArrayList<Integer> list2 = nodeToRootPath(root, d2);
        int i=list1.size() -1;
        int j=list2.size() -1;

        int ans = -1;
        while(i >= 0 && j >= 0){
            if(list1.get(i) == list2.get(j)){
                ans = list1.get(i);
            }else return ans;
            i--;
            j--;
        }
        return ans;
    }
    public static int totalDistanceBetweenNode(Node root , int d1, int d2){
        ArrayList<Integer> list1 = nodeToRootPath(root, d1);
        ArrayList<Integer> list2 = nodeToRootPath(root, d2);

        int i=list1.size() -1;
        int j=list2.size() -1;

        int ans = -1;
        while(i >= 0 && j >= 0 && (list1.get(i) == list2.get(j))){
            i--;
            j--;
        }
        i++;
        j++;
        return (i+j);

    }

    public static boolean areSimilar(Node n1,Node n2){
        if(n1.children.size() != n2.children.size()) return false;

        for(int i=0;i<n1.children.size();i++)
        {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);
            if(areSimilar(c1, c2) == false){
                return false;
            }
        }
        return true;
    }

    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;
    public static void ceilAndFloor(Node root,int data){
        if(root.data > data){
            if(root.data < ceil){
                ceil = root.data;
            }
        }
        if(root.data < data){
            if(root.data > floor){
                floor = root.data;
            }
        }
        for(Node child : root.children){
            ceilAndFloor(child, data);
        }
    }
    static Node predecessor;
    static Node successor;
    static int state = 0;
    public static void setPredecessorAndSuccessor(Node root,int data){
        if(state == 0){
            if(root.data == data){
                state = 1;
            }
            else{
                predecessor = root;
            }
        }
        else{
            if(state == 1){
                successor = root;
                state = 2;
            }
        }

        for(Node child : root.children){
            setPredecessorAndSuccessor(child, data);
        }
    }

    public static int KthLargest(Node root , int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            ceilAndFloor(root, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
    }

    static int maximumSum = Integer.MIN_VALUE;
    static int node = 0;
    public static int retSumAndCalculateMSST(Node root ){
        int sum = 0;

        for(Node child : root.children){
            int childSum = retSumAndCalculateMSST(child);
            sum += childSum;
        }
        sum += root.data;
        if(sum > maximumSum){
            maximumSum = sum;
            node = root.data;
        }
        return sum ;
    }
    public static void main(String[] args){
        int arr[] = {10,20,50,130,-1,-1,60,-1,-1,30,70,140,-1,-1,80,-1,90,150,-1,-1,-1,40,110,-1,120,160,-1,-1,-1,-1};
        Stack<Node> stack = new Stack<>();
        Node root = null;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == -1){
                stack.pop();
            }
            else{
                Node newNode = new Node(arr[i]);
                if(stack.size() > 0){
                    stack.peek().children.add(newNode);
                }else{
                    root = newNode;
                }
                stack.push(newNode);
            }
        }
        // System.out.println(size(root));
        // mirror(root);
        // removeLeaves(root);
        // linearize(root);
        // linearize2(root);
        // List<Integer> result = levelOrderTraversal(root);
        // int i=0;
        // for(Object num:result){
        //     if(num == null){
        //         System.out.println();
        //         System.out.print("level " + i + " -> ");
        //         i++;
        //     }
        //     else System.out.print(num+" ");
        // }
        /*
        level 0 -> 10 
        level 1 -> 20 30 40
        level 2 -> 50 60 70 80 90 110 120
        level 3 -> 130 140 150 160
         */

        //  System.out.println();

        //  System.out.println("maximum value : "+ maximum(root));
        //  System.out.println("minimum value : "+ minimum(root));
        // mirror(root);

        // traversaList2(root);

        // System.out.println(findChildren(root, 110));
        // ArrayList<Integer> ans = nodeToRootPath(root,150);
        // int k=0;
        // while(k<ans.size()){
        //     System.out.print(ans.get(k)+" ");
        //     k++;
        // }

        // System.out.println(lowestCommonAncestor(root,90,150));
        // System.out.println(totalDistanceBetweenNode(root,80,150));
        setPredecessorAndSuccessor(root,90);

        System.out.println("predecessor : "+predecessor.data);
        System.out.println("Successor : "+successor.data);

        ceilAndFloor(root,160);
        if(ceil == Integer.MAX_VALUE){
            System.out.println("Not found");
        }
        else System.out.println("ceil value : "+ceil);
        if(floor == Integer.MIN_VALUE){
            System.out.println("Not found");
        }
        else System.out.println("floor value : "+floor);

        System.out.println("kth largest : "+KthLargest(root, 3));
        System.out.println(retSumAndCalculateMSST(root ));
        System.out.print(node + " " + maximumSum);

    }
}

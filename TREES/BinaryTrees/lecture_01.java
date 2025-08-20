import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class lecture_01 {
    public static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }

        // Node (int data, Node left, Node right){
        //     this.left = left;
        //     this.right = right;
        //     this.data = data;
        // }
    }
    public static class Pair{
        Node node;
        int state;
        
        Pair(Node node , int state)
        {
            this.node = node;
            this.state = state;
        }
    }
    public static int size(Node root){
        if(root == null) return 0;
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        int size = leftSize+rightSize+1;

        return size;
    }
    public static int sum(Node root){
        if(root == null) return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int sum = leftSum+rightSum+root.data;

        return sum;
    }
    public static int max(Node root){

        if(root == null) return Integer.MIN_VALUE;
        int leftMax = max(root.left);
        int rightMax = max(root.right);
        int max = Math.max(root.data , Math.max(leftMax,rightMax));

        return max;
    }
    public static int height(Node root){
        if(root == null) return -1;     //-1 for edges and 0 for nodes
        int lh = height(root.left);
        int lr = height(root.right);
        int th = Math.max(lh, lr)+1;
        return th;
    }
    public static void display(Node root){

        if(root == null) return;

        String str = "";
        str += root.left==null? " n " : root.left.data;
        str += " <- " + root.data + " -> ";
        str += root.right==null? " n " : root.right.data;
        System.out.println(str);

        display(root.left);
        display(root.right);
        
    }

    public static void preOrder(Node root){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while(!stack.isEmpty()){
            Pair top = stack.peek();
            if(top.state == 1){
                list1.add(top.node.data);
                top.state++;

                if(top.node.left != null){
                    // Pair newPair = new Pair(top.node.left, 1);
                    stack.push(new Pair(top.node.left, 1));
                }
            }
            else if(top.state == 2){
                list2.add(top.node.data);
                top.state++;

                if(top.node.right != null){
                    // Pair newPair = new Pair(top.node.right, 1);
                    stack.push(new Pair(top.node.right, 1));
                }
            }
            else{
                list3.add(top.node.data);
                stack.pop();
            }
        }

        System.out.print("pre order : ");
        print(list1);
        System.out.print("in order : ");
        print(list2);
        System.out.print("post order : ");
        print(list3);
    }
    public static void print(ArrayList<Integer> list ){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
    static ArrayList<Integer> path =new ArrayList<>();
    public static boolean rootToNodePath(Node root,int data){
        if(root == null) return false;
        if(root.data == data){
            path.add(root.data);
            return true;
        }
        boolean findLeftChild = rootToNodePath(root.left, data);
        if(findLeftChild){
            path.add(root.data);
            return true;
        }
        boolean findRightChild = rootToNodePath(root.right, data);
        if(findRightChild){
            path.add(root.data);
            return true;
        }
        return false;
    }

    public static void KthLevel(Node root,int k ){
        if(k==0){
            System.out.println(root.data);
            return;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        int cnt = 1;

        while(!q.isEmpty()){
            if(cnt == k-1){
                int size = q.size();
                for(int i=0;i<size;i++){
                    Node temp = q.remove();
                    System.out.print(temp.data+" ");
                }
                return;
            }
            else{
                int size = q.size();
                for(int i=0;i<size;i++){
                    Node temp = q.remove();
                    q.add(temp.left);
                    q.add(temp.right);
                }
                cnt++;
            }
        }
    }

    static ArrayList<Node> path2 ;
    public static boolean  findPath(Node root , int data) {
        if(root == null) return false;
        if(data == root.data){
            path2.add(root);
            return true;
        }
        boolean filc = findPath(root.left, data);
        if(filc){
            path2.add(root);
            return true;
        }
        boolean firc = findPath(root.right, data);
        if(firc){
            path2.add(root);
            return true;
        }
        return false;
    }
    public static void KthLevelDown(Node root,int k , Node blocker ){
        if(root == null || k<0) return;
        if(k==0){
            System.out.print(root.data+" ");
        }
        KthLevelDown(root.left, k-1, blocker);
        KthLevelDown(root.right, k-1, blocker);
    }
    public static void kthFarNodes(Node root , int data , int k){
        path2 = new ArrayList<>();
        findPath(root, data);
        for(int i=0;i<path2.size();i++){
            KthLevelDown(path2.get(i), k-i,i==0?null:path2.get(k-i));
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};

        Node root = new Node(arr[0]);
        Pair rootPair = new Pair(root,1);

        Stack<Pair> stack = new Stack<>();
        stack.push(rootPair);
        
        int index = 0;
        while(!stack.isEmpty()){
            Pair top = stack.peek();
            if(top.state == 1){
                index++;
                if(arr[index]!=null){
                    top.node.left = new Node(arr[index]);
                    Pair leftpair = new Pair(top.node.left,1);
                    stack.push(leftpair);
                }
                else{
                    top.node.left = null;
                }
                top.state++;
            }
            else if(top.state == 2){
                index++;
                if(arr[index]!= null){
                    top.node.right = new Node(arr[index]);
                    Pair rightPair = new Pair(top.node.right,1);
                    stack.push(rightPair);
                } 
                else{
                    top.node.right = null;
                }
                top.state++;
            }
            else{
                stack.pop();
            }
        }
        // display(root);
        // System.out.println("sum : "+sum(root));
        // System.out.println("size : "+size(root));
        // System.out.println("height : "+height(root));
        // System.out.println("maximum : "+max(root));

        // preOrder(root);
        // path = new ArrayList<>();
        // boolean status = rootToNodePath(root,70);
        // System.out.println("status : "+status);
        // System.out.println("path : "+path);

        KthLevel(root,3);

    }
}

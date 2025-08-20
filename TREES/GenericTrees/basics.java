import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;


public class basics {
    static class Node{
        int data;
        int size;
        ArrayList<Node> children = new ArrayList<>();
        Node(){

        }
        Node(int data){
            this.data = data;
        }
    }
    private static class Pair{
        int level;
        Node node;
        Pair(Node node , int level){
            this.level = level;
            this.node = node;
        }
    }
    public static void levelOrderLineWiseApproach4(Node root){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 1));
        int level = 1;
        while(q.size() > 0){
            Pair p = q.remove();
            if(p.level > level){
                level = p.level;
                System.out.println();
            }
            System.out.println(p.node.data);
            for(Node child : p.node.children){
                Pair childPair = new Pair(child, p.level+1);
                q.add(childPair);
            }
        }
    }

    public static int size(Node root){
        int size = 0;   
        for(Node child : root.children){
            int children_size = size(child);
            size += children_size;
        }
        size += 1;
        return size;
    }

    public static int maximum(Node root){
        int max = root.data;
        for(Node child : root.children){
            int num = maximum(child);
            max = Math.max(max,num);
        }
        return max;
    }
    public static int minimum(Node root){
        int min = root.data;
        for(Node child : root.children){
            int num = minimum(child);
            min = Math.min(min,num);
        }
        return min;
    }
    public static int height(Node root) {
        int height = -1;
        for(Node child : root.children){
            int children_height = height(child);
            height = Math.max(height , children_height);
        }
        height += 1;
        return height;
    }
    public static void display(Node root){
        String str = root.data + " -> ";
        for(Node child : root.children){
            str += child.data + " ";
        }
        System.out.println(str);

        for(Node child : root.children){
            display(child);
        }
    }

    public static void levelOrderTraversal(Node root){
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0){
            root = q.remove();
            System.out.print(root.data + " ");
            for(Node child : root.children){
                q.add(child);
            }
        }
    }
    public static void levelOrderTraversalLineByLine(Node root){
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0){
            int length = q.size();
            for(int i=0;i<length;i++){
                root = q.remove();
                System.out.print(root.data+ " ");
                for(Node child : root.children){
                    q.add(child);
                }
            }
            System.out.println();
        }
    }

    public static void levelOrderLineWiseApproach2(Node root)
    {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        q.add(new Node(-1));
        while(q.size()>0){
            root = q.remove();
            if(root.data != -1){
                System.out.print(root.data+ " ");
                for(Node child : root.children){
                    q.add(child);
                }
            }
            else{
                if(q.size() > 0){
                    q.add(new Node(-1));
                    System.out.println();
                } 
            }
        }
    }
    public static void levelOrderLineWiseApproach3(Node root)
    {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while(q.size()>0){
            int length = q.size();
            for(int i=0;i<length;i++){
                root = q.remove();
                System.out.print(root.data+" ");
                for(Node child : root.children){
                    q.add(child);
                }
            }
            System.out.println();
        }
    }

    public static void levelOrderZigZag(Node root){
        Stack<Node> mainStack = new Stack<>();
        Stack<Node> childStack = new Stack<>();
        mainStack.push(root);
        int level=1;
        while(mainStack.size() > 0){
            root = mainStack.pop();
            System.out.print(root.data+" ");
            
            if(level % 2==1){
                for(int i=0;i<root.children.size() ;i++){
                    Node child = root.children.get(i);
                    childStack.push(child);
                }
            }
            else{
                for(int i=root.children.size()-1;i>=0;i--){
                    Node child = root.children.get(i);
                    childStack.push(child);
                }
            }
            if(mainStack.size()==0){
                mainStack = childStack;
                childStack = new Stack<>();
                level++;
            }
        }
    }

    public static void traversal(Node root){
        //Euler's left, on the way deep in the recusion , node's pre area
        System.out.println("Node pre "+root.data);
        for(Node child : root.children){
            System.out.println("Edge pre "+root.data + " -- "+ child.data);
            traversal(child);
            System.out.println("Edge post "+root.data + " -- "+ child.data);
        }

        //Euler's right, on the way deep in the recursion, node's post area
        System.out.println("Node post "+root.data);
    }
    public static void main(String[] args) {
        int arr[] = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = null;
        Stack<Node> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] == -1){
                stack.pop();
                
            }
            else{
                Node t = new Node();
                t.data = arr[i];
                
                if(stack.size() > 0){
                    stack.peek().children.add(t);
                }
                else{
                    root = t;
                }
                stack.push(t);
                root.size++;
            }
        }
        // display(root);
        // System.out.println(root.size);
        // System.out.println("size : " +size(root));
        // System.out.println("maximum : "+maximum(root));
        // System.out.println("minimum : "+minimum(root));
        // System.out.println("height : "+ height(root));
        // traversal(root);
        // levelOrderTraversal(root);
        // levelOrderTraversalLineByLine(root);
        // levelOrderZigZag(root);
        levelOrderLineWiseApproach3(root);
    }
}

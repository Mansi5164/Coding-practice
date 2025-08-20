
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class lecture_02 {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(int state, Node node) {
            this.state = state;
            this.node = node;
        }
    }

    public static void traversal(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " -> ");
        traversal(root.left);
        traversal(root.right);
    }

    public static int size(Node root) {
        // int size = 0;
        if (root == null)
            return 0;
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        int total = leftSize + rightSize + 1;
        return total;
    }

    public static int maximum(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int leftMax = maximum(root.left);
        int rightMax = maximum(root.right);
        int max = Math.max(Math.max(leftMax, rightMax), root.data);
        return max;
    }

    public static int minimum(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        int min = Math.min(Math.min(leftMin, rightMin), root.data);
        return min;
    }

    public static int height(Node root) {
        if (root == null)
            return -1;
        int left_height = height(root.left);
        int right_height = height(root.right);
        int height = Math.max(left_height, right_height) + 1;
        return height;
    }

    public static int diameter(Node root) {
        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);
        int leftheight = height(root.left) + 1;
        int rightHeight = height(root.right) + 1;
        int total = leftheight + rightHeight;
        return Math.max(total, Math.max(leftDia, rightDia));
    }

    public static int sum(Node root) {
        if (root == null)
            return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int sum = leftSum + rightSum + root.data;
        return sum;
    }

    static int tilt = 0;

    public static int tilt(Node root) {
        if (root == null)
            return 0;
        int leftTilt = tilt(root.left);
        int rightTilt = tilt(root.right);

        int localTilt = Math.abs(leftTilt - rightTilt);
        System.out.println("l: " + localTilt);

        tilt += localTilt;
        System.out.println("t : " + tilt);

        return leftTilt + rightTilt + root.data;
    }

    public static void levelOrderTraversal(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                System.out.print(temp.data + " -> ");
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            System.out.println();
        }
    }

    public static void preOrder(Node root) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        Pair pair = new Pair(1, root);
        stack.push(pair);

        while (!stack.isEmpty()) {
            Pair top = stack.peek();
            if (top.state == 1) {
                l1.add(top.node.data);
                if (top.node.left != null) {
                    Pair temp = new Pair(1, top.node.left);
                    stack.push(temp);
                }
                top.state++;

            } else if (top.state == 2) {
                l2.add(top.node.data);
                if (top.node.right != null) {
                    Pair temp = new Pair(1, top.node.right);
                    stack.push(temp);
                }
                top.state++;
            } else {
                l3.add(top.node.data);
                stack.pop();
            }
        }
        print(l1);
        print(l2);
        print(l3);
    }

    static ArrayList<Node> list;

    public static boolean find(Node root, int target) {

        if (root == null)
            return false;

        if (root.data == target) {
            list.add(root);
            return true;
        }
        boolean leftChild = find(root.left, target);
        if (leftChild) {
            list.add(root);
            return true;
        }

        boolean rightChild = find(root.right, target);
        if (rightChild) {
            list.add(root);
            return true;
        }

        return false;
    }

    public static void print(ArrayList<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void KthLevelDown(Node root, int k, Node blocker) {
        if (root == null || k < 0 || root == blocker)
            return;
        if (k == 0)
            System.out.print(root.data + " ");
        KthLevelDown(root.left, k - 1, blocker);
        KthLevelDown(root.right, k - 1, blocker);
    }

    public static void kthFarNodes(Node root, int k, int data) {
        list = new ArrayList<>();
        find(root, data);
        for (int i = 0; i < list.size(); i++) {
            KthLevelDown(list.get(i), k - i, i == 0 ? null : list.get(i - 1));
        }
    }

    public static Node CreateLeftClonedTree(Node root) {
        if (root == null) {
            return null;
        }
        Node lcr = CreateLeftClonedTree(root.left);
        Node rcr = CreateLeftClonedTree(root.right);

        Node newNode = new Node(root.data, lcr, null);
        root.left = newNode;
        root.right = rcr;

        return root;
    }

    public static Node transformBackLeftClonedTree(Node root) {
        if (root == null)
            return null;

        Node normalizeLeftNode = transformBackLeftClonedTree(root.left.left);
        Node normalizeRightNode = transformBackLeftClonedTree(root.right);

        root.left = normalizeLeftNode;
        root.right = normalizeRightNode;
        return root;
    }

    public static void printSingleChild(Node root, Node parent) {
        if (root == null)
            return;
        if (parent != null && parent.left == root && parent.right == null) {
            System.out.print(root.data + " ");
        }
        if (parent != null && parent.left == null && parent.right == root) {
            System.out.print(root.data + " ");
        }

        printSingleChild(root.left, root);
        printSingleChild(root.right, root);
    }

    public static void createMirror(Node root) {
        if (root == null)
            return;
        createMirror(root.right);
        System.out.print(root.data + " -> ");
        createMirror(root.left);
    }

    public static Node removeLeaves(Node root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);

        return root;
    }

    public static void pathToLeafFromRoot(Node root, String path, int sum, int low, int high) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sum += root.data;
            if (sum >= low && sum <= high) {
                System.out.println(path + root.data);
            }
            return;
        }
        pathToLeafFromRoot(root.left, path + root.data + " ", sum + root.data, low, high);
        pathToLeafFromRoot(root.right, path + root.data + " ", sum + root.data, low, high);
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };

        Node root = new Node(arr[0], null, null);
        Pair pair = new Pair(1, root);

        int index = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(pair);

        while (!stack.isEmpty()) {
            Pair top = stack.peek();
            if (top.state == 1) {
                index++;
                if (arr[index] != null) {
                    top.node.left = new Node(arr[index], null, null);
                    Pair newpair = new Pair(1, top.node.left);
                    stack.push(newpair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                index++;
                if (arr[index] != null) {
                    top.node.right = new Node(arr[index], null, null);
                    Pair newpair = new Pair(1, top.node.right);
                    stack.push(newpair);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                stack.pop();
            }
        }
        // traversal(root);
        // System.out.println();
        // System.out.println("size : " + size(root));
        // System.out.println("Maximum : " + maximum(root));
        // System.out.println("Minimum : " + minimum(root));
        // System.out.println("height : " + height(root));
        // System.out.println("sum : " + sum(root));
        // levelOrderTraversal(root);
        // preOrder(root);

        // list = new ArrayList<>();
        // boolean status = find(root, 70);
        // System.out.println("path : " + list.toString());
        // System.out.println("status : "+status);
        // KthLevelDown(root,3);
        // kthFarNodes(root,3,16);
        // pathToLeafFromRoot(root, "", 0, 150, 250);
        // Node clonedRoot = CreateLeftClonedTree(root);

        // System.out.println("Level Order Traversal of Left Cloned Tree:");
        // levelOrderTraversal(clonedRoot);

        // System.out.println("\nOriginal Tree Structure (skipping clones):");
        // traversal(clonedRoot);

        // root = transformBackLeftClonedTree(clonedRoot);
        // System.out.println("after normalize : ");
        // traversal(root);

        // printSingleChild(root,null);
        // Node temp = removeLeaves(root);
        // traversal(temp);

        // createMirror(root);
        // System.out.println("diameter : "+getHeight(root));

        System.out.println(tilt(root));
        System.out.println(tilt);

    }
}

// https://www.canva.com/design/DAGvmSn__yQ/tpmoJvaYo2Wz_ulSTlKypg/edit
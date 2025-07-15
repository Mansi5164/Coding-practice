import java.util.Scanner;

public class buildNormalStack {
    public static class customStack {
        int top = -1;
        int[] data;

        public customStack(int capacity) {
            data = new int[capacity];
        }

        public int size() {
            return top + 1;
        }

        public void push(int val) {
            if (top == data.length - 1) {
                int[] newData = new int[2 * data.length];
                for (int i = 0; i < data.length; i++) {
                    newData[i] = data[i];
                }
                data = newData;
            }
            top++;
            data[top] = val;
        }

        public int pop() {
            if (top == -1) {
                System.out.println("stack underflow");
                return -1;
            } else {
                int x = data[top];
                top--;
                return x;
            }
        }

        public void display() {
            for (int i = top; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        customStack obj = new customStack(n);
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            obj.push(x);
        }

        System.out.print("stack elements: ");
        obj.display();

        System.out.println("top element : " + obj.pop());
        System.out.println("size : " + obj.size());

        obj.push(12);
        obj.push(14);
        obj.push(16);
        obj.push(18);
        obj.push(20);

        obj.display();
        System.out.println("top element : " + obj.pop());
        System.out.println("size : " + obj.size());

        sc.close();
    }
}

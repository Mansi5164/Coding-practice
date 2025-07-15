import java.util.Scanner;

public class buildNormalQueue {
    public static class CustomQueue{
        int front ;
        int size;
        int data[];
        public CustomQueue(int capacity){
            data = new int[capacity];
            front = 0;
            size = 0;
        }
        void add(int val){
            if(size == data.length){
                System.out.println("queue overflow");
                return;
            }
            else{
                int rear = (front + size)%data.length;
                data[rear] = val;
                size++;
            }
        }
        int peek(){
            if(size == 0){
                System.out.println("queue underflow");
                return -1;
            }
            else{
                return data[front];
            }
        }
        int remove(){
            if(size == 0){
                System.out.println("queue underflow");
                return -1;
            }
            else{
                int x = data[front];
                front = (front+1)%data.length;
                size--;
                return x;
            }
        }
        void display(){
            for(int i=0;i<size;i++){
                int index = (i+front)%data.length;
                // int x = data[(front+size) % data.length];
                System.out.print(data[index]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter size:");
        int n = sc.nextInt();
        CustomQueue obj = new CustomQueue(n);
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            obj.add(x);
        }
        System.out.print("elements of queue : ");
        obj.display();
        System.out.println(obj.remove());
        System.out.println(obj.remove());
        obj.display();
        obj.add(70);
        obj.display();
    }
}

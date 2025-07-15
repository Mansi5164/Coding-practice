import  java.util.Scanner;

class Node{
    int data;
    Node next;
}

class LinkedLists{
    Node head;
    Node tail;
    int size;

    LinkedLists(){
        head= null;
        size = 0;
        tail = null;
    }
    void add(int val){
        Node temp = new Node();
        temp.data = val;
        if(size == 0){
            head = temp;
            tail = temp;
        }
        else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    void addFirst(int val){
        Node temp = new Node();
        temp.data = val;
        temp.next = head;
        head = temp;
        size++;
    }
    void addLast(int val){
        Node temp = new Node();
        temp.data = val;
        tail.next = temp;
        tail = temp;
        size++;
    }
    void display(){
        if(head == null){
            System.out.println("linked lists is empty...");
            return;
        }
        else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    int size(){
        return size;
    }
    int getValue(int index){
        if(index > size || index < 0){
            System.out.println("invalid index..");
            return -1;
        }
        int cnt = 0;
        Node temp = head;
        while(cnt < index && temp != null){
            temp = temp.next;
            cnt++;
        }
        return temp.data;
    }
    void addAtIndex(int val , int index){
        if(index > size || index < size){
            System.out.println("invalid index..");
            return;
        }
        Node temp = new Node();
        temp.data = val;
        if(size == 0){
            head = temp;
        }
        else{
            int cnt = 1;
            Node mover = new Node();
            while(cnt < index){
                mover = mover.next;
                cnt++;
            }
            temp.next = mover.next;
            mover.next = temp;
        }
        size++;
    }
}
public class basic {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int val = 5;
        LinkedLists ll = new LinkedLists();
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.add(9);
        // System.out.println(ll.head.data);
        ll.display();
        ll.addFirst(10);
        ll.addLast(100);
        ll.display();
        System.out.println(ll.getValue(0));
        // System.out.println(ll.size());
    }
}

// package Sorting;

import java.util.ArrayList;
import java.util.List;
public class Heap {
    public static List<Integer> list =new ArrayList<>();
    // public static int size =-1;
    
    public static void insert(int element){
        // size++;
        list.add(element);
        int index = list.size()-1;
        while(index>0){
            int parent = (index-1)/2;
            if(list.get(parent) < list.get(index)){
                //swap 
                int temp = list.get(parent);
                list.set(parent,list.get(index));
                list.set(index,temp);
                index = parent;
            }
            else return;
        }
    }
    public static void print(){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
    public static void delete(){
        int size = list.size();
        if(size == 0) {
            System.out.println("Nothing to delete");
            return;
        }
            int lastEle = list.get(size-1);
            list.set(0,lastEle);
            list.remove(size-1);
            
            //propagate root node to its correct position
            int i=0;
            int size2 = list.size();
            while(i<size2){
                int left = 2*i+1;
                int right = 2*i+2;

                if(left < size2 && list.get(i) < list.get(left)){
                    //swap
                    int temp = list.get(i);
                    list.set(i,list.get(left));
                    list.set(left,temp);
                    i = left;
                }
                else if(right < size2 && list.get(i) < list.get(right)){
                    //swap
                    int temp = list.get(i);
                    list.set(i,list.get(right));
                    list.set(right,temp);
                    i = right;
                }
                else return;
            }
        
    }
    public static void main(String[] args) {
        insert(50);
        insert(55);
        insert(53); 
        insert(52);
        insert(54);
        print();

        delete();
        print();
    }
}

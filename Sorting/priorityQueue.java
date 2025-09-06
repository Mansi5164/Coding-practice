import java.util.Collections;
import java.util.PriorityQueue;


class NewStudent implements Comparable<NewStudent>{
    int marks;
    String name;
    public NewStudent(String name , int marks) {
        this.name = name;
        this.marks = marks; 
    }

    @Override
    public String toString(){
        return "Student name : "+this.name + " , marks : "+ this.marks ;
    }

    @Override
    public int compareTo(NewStudent that){
        if(this.marks == that.marks){
            return this.name.compareTo(that.name);      //neg 0 pos
        }
        return this.marks - that.marks;     //inc - asc
        // return that.marks - this.marks;     //dec - des
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof NewStudent){
            NewStudent that = (NewStudent) obj;
            if(this.marks == that.marks && (this.name.compareTo(that.name))==0) 
                return true;
        }
        return false;
    }
    
}
public class priorityQueue {
    public static void main(String[] args) {

        //------------------- MIN - PRIORITY QUEUE -------------------------------
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        pqMin.offer(19);
        pqMin.offer(5);
        pqMin.offer(10);
        pqMin.offer(10);
        pqMin.offer(8);
        pqMin.remove(10);

        System.out.println("Highest priority element is : "+pqMin.peek());
        for(int num : pqMin){
            System.out.print(num + " ");
        }
        System.out.println();

        //------------------- MIN - PRIORITY QUEUE -------------------------------
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        pqMax.offer(19);
        pqMax.offer(5);
        pqMax.offer(10);
        pqMax.offer(8);

        // System.out.println("max pq : Highest priority element is : "+pqMax.peek());
        // System.out.println(pqMax.contains(19));
        // System.out.println("deleted : "+pqMax.poll());
        // System.out.println("max pq : Highest priority element is : "+pqMax.peek());
        // System.out.println(pqMax.contains(19));

        
        // PriorityQueue<NewStudent> minStudentpq = new PriorityQueue<>();
        // minStudentpq.offer(new NewStudent("Ram", 80));
        // minStudentpq.offer(new NewStudent("Akshay", 98));
        // minStudentpq.offer(new NewStudent("Ramya", 89));
        // System.out.println(minStudentpq.peek());
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Representation {
    int adjMatrix[][];

    List<List<Integer>> list;
    int [] Indegree;
    int [] Outdegree;
    int [] degree;

    public Representation(int nodes) {
        adjMatrix = new int[nodes][nodes];
        list = new ArrayList<>();
        for(int i=0;i<nodes;i++){
            list.add(new ArrayList<>());
        }
        Indegree = new int[nodes];
        Outdegree = new int[nodes];
        degree = new int[nodes];
    }

    public void addEdgesInMatrix(int edges[][],boolean isDirected) {       // -> [[0,2],[0,1]]
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            // directed
            if(isDirected)
                adjMatrix[u][v] = 1;

            //undirected
            else{
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }
        }
    }

    public void addEdgesWithWeightInMatrix(int edges[][],boolean isDirected) {       // -> [[0,2],[0,1]]
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            // directed
            if(isDirected)
                adjMatrix[u][v] = weight;

            //undirected
            else{
                adjMatrix[u][v] = weight;
                adjMatrix[v][u] = weight;
            }
        }
    }

    public void addEdgesInList(int edges[][], boolean isDirected){

        for(int[] edge : edges){

            int u = edge[0];
            int v = edge[1];

            if(isDirected){
                list.get(u).add(v);
            }
            else{
                list.get(u).add(v);
                list.get(v).add(u);
            }
        }
    }
    
    public void printMatrix(){
        int row = 0;
        for(int[] mat : adjMatrix){
            System.out.print(row+" -> ");
            for(int ele : mat){
                System.out.print(ele + " ");
            }
            System.out.println();
            row++;
        }
    }

    public void addDegreeInList(int edges[][],boolean isDirected){
        for(int[] edge : edges){

            int u = edge[0];
            int v = edge[1];

            if(isDirected){
                Indegree[v]++;
                Outdegree[u]++;
            }
            else{
                degree[u]++;
                degree[v]++;
            }
        }
    }

    public void printList(){
        for(List<Integer> sublist : list){
            System.out.print("[");
            for(int ele : sublist){
                System.out.print(ele + ",");
            }
            System.out.println("]");
        }
    }

    public void printDegreeList(){
        System.out.print("Indegree -> ");
        for(int i=0;i<Indegree.length;i++){
            System.out.print(Indegree[i]+" ");
        }
        System.out.println();
        System.out.print("Outdegree -> ");
        for(int i=0;i<Outdegree.length;i++){
            System.out.print(Outdegree[i]+" ");
        }
        System.out.println();
        System.out.print("Degree -> ");
        for(int i=0;i<degree.length;i++){
            System.out.print(degree[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edges[][] = {{0,2,20},{0,1,10},{1,3,30}};
        // int edges[][] = {{0,2,20},{0,1,10},{1,3,30}};
        int nodes = 4;
        Representation obj = new Representation(nodes);
        boolean isDirected = false;
        // obj.addEdgesInMatrix(edges, isDirected);
        // System.out.println("undirected graph : ");
        // obj.printMatrix();
        // System.out.println();
        // Representation obj2 = new Representation(nodes);
        // isDirected = true;
        // obj2.addEdgesInMatrix(edges, isDirected);
        // System.out.println("directed graph : ");
        // obj2.printMatrix();

        // obj2.addEdgesWithWeightInMatrix(edges,isDirected);
        // System.out.println();
        // System.out.println("weighted directed graph : ");
        // obj2.printMatrix();

        // obj2.addEdgesWithWeightInMatrix(edges,false);
        // System.out.println();
        // System.out.println("weighted undirected graph : ");
        // obj2.printMatrix();

        // obj.addEdgesInList(edges, isDirected);
        // obj.printList();
        // System.out.println("");
        Representation obj2 = new Representation(4);
        obj2.addDegreeInList(edges, true);
        obj2.printDegreeList();

        Representation obj3 = new Representation(4);
        obj3.addDegreeInList(edges,false);
        obj3.printDegreeList();
    }

}
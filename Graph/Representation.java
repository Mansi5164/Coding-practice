import java.util.Scanner;

public class Representation {
    int adjMatrix[][];

    public Representation(int nodes) {
        adjMatrix = new int[nodes][nodes];
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edges[][] = {{0,2,20},{0,1,10},{1,3,30}};
        int nodes = 4;
        Representation obj = new Representation(nodes);
        boolean isDirected = false;
        obj.addEdgesInMatrix(edges, isDirected);
        System.out.println("undirected graph : ");
        obj.printMatrix();
        System.out.println();
        Representation obj2 = new Representation(nodes);
        isDirected = true;
        obj2.addEdgesInMatrix(edges, isDirected);
        System.out.println("directed graph : ");
        obj2.printMatrix();

        obj2.addEdgesWithWeightInMatrix(edges,isDirected);
        System.out.println();
        System.out.println("weighted directed graph : ");
        obj2.printMatrix();

        obj2.addEdgesWithWeightInMatrix(edges,false);
        System.out.println();
        System.out.println("weighted undirected graph : ");
        obj2.printMatrix();
    }

}
package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by livetolove128 on 19/9/15.
 */
public class Graph {

    // Attributes
    List<List<Integer>> adjList;
    List <Integer> vertices;
    List <String> edges;

    // Constructors
    public Graph(){
        adjList = new ArrayList<>();
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    // Methods
    public int addVertex(int vertex){
        adjList.add(vertex, new ArrayList<>());
        vertices.add(vertex);
        return vertex;
    }

    public boolean isVertex(int vertex){

        // Check in vertices list
        for(int item: vertices){
            if(item == vertex){
                return true;
            }
        }
        return false;
    }

    public boolean addEdge(int first, int second){
        adjList.get(first).add(second);
        adjList.get(second).add(first);
        edges.add(Integer.toString(first) + Integer.toString(second));
        return true;
    }

    public boolean isEdge(int first, int second){

        for (int item: adjList.get(first)){
            if(item == second){
                return true;
            }
        }
        return false;
    }

    public List <Integer> getIncidentVertices(int vertex){
        return adjList.get(vertex);
    }

    public void printGraph(){

        // Print all vertices
        System.out.print("Vertices: ");
        for(int item: vertices){
            System.out.print(item + " ");
        }
        System.out.println("");

        // Print all edges
        System.out.print("Edges: ");
        for(String item: edges){
            System.out.print(item + " ");
        }
    }

    public List<Integer> getVertices(){
        return vertices;
    }
}
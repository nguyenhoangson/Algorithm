package Graph;

import DataStructure.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by livetolove128 on 19/9/15.
 */
public class GraphExplorer {

    // Methods
    public List<Integer> BFS(int startVertex, Graph g){

        Queue visitList =  new Queue();
        List <Integer> exploredVertices = new ArrayList<>();
        int item;

        visitList.enqueue(startVertex);
        exploredVertices.add(startVertex);


        while(visitList.size() > 0) {
            item = visitList.dequeue();
            for(int incident: g.getIncidentVertices(item)){
                if (!exploredVertices.contains(incident)) {
                    exploredVertices.add(incident);
                    visitList.enqueue(incident);
                }
            }
        }

        return exploredVertices;
    }

    public List<Integer> DFS(Graph g){

        List <Integer> exploredVertices = new ArrayList<>();

        for(int vertex: g.getVertices()){
            DFSVisit(vertex, g, exploredVertices);
        }

        return exploredVertices;
    }

    // Traverse through all reachable vertices from vertex
    public void DFSVisit(int vertex, Graph g, List<Integer> exploredVertices){

        for(int item: g.getIncidentVertices(vertex)){
            if(!exploredVertices.contains(item)){
                exploredVertices.add(item);
                DFSVisit(item, g, exploredVertices);
            }
        }
        return;
    }
}

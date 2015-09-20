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
        int item = 0;

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

    public List<Integer> DFS(int startVertex, Graph g){

        List <Integer> exploredVertices = new ArrayList<>();
        return exploredVertices;
    }
}

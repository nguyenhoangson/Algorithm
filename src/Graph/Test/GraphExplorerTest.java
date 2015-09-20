package Graph.Test;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;
import Graph.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by livetolove128 on 19/9/15.
 */
public class GraphExplorerTest {

    public Graph g;
    public GraphExplorer explorer;

    @Before
    public void setUp() throws Exception {
        g = new Graph();
        explorer = new GraphExplorer();

        // Add vertices
        for(int i = 0; i <= 7; i++){
            g.addVertex(i);
        }

        // Add edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 5);
        g.addEdge(3, 5);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 7);
        g.addEdge(5, 6);
        g.addEdge(6, 7);

    }

    @After
    public void tearDown() throws Exception {
        g = null;
        explorer = null;
    }

    @Test
    public void testBFS(){

        List<Integer> list =  explorer.BFS(0, g);

        System.out.println("BFS: ");
        for(int item: list){
            System.out.print(item);
        }
        System.out.println("");
    }

    @Test
    public void testDFS(){
        List<Integer> list = explorer.DFS(g);

        System.out.println("DFS: ");
        for(int item: list){
            System.out.print(item);
        }
        System.out.println("");
    }
}
package Graph.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import Graph.Graph;

/**
 * Created by livetolove128 on 19/9/15.
 */
public class GraphTest {

    // Class under test
    Graph g = new Graph();

    @Before
    public void setUp(){

        g = new Graph();

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
    public void tearDown(){
        g = null;
    }


    // It should add vertex
    @Test
    public void itShouldAddVertex() {
        int testInput = 0;
        int actual = g.addVertex(testInput);
        assertSame("Should add vertex", true, g.isVertex(testInput));
        assertSame("Should return vertex added", testInput, actual);
    }

    // It should add edge
    @Test
    public void itShouldAddEdge(){

        int first = 0;
        int second = 1;

        // Add vertices
        g.addVertex(first);
        g.addVertex(second);

        // Add edges
        g.addEdge(first, second);

        assertSame("Should add edge", true, g.isEdge(first, second));
        assertSame("Should add edge", true, g.isEdge(second, first));
    }

    @Test
    public void itShouldGetAllIncidentEdges(){

        // Add vertices
        for(int i = 0; i <= 7; i++){
            g.addVertex(i);
        }

        // Add edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 5);

        for(int item: g.getIncidentVertices(0)){
            System.out.print(item + " ");
        }
    }


}
package Graph.Test;

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

        g.addVertex(first);
        g.addVertex(second);

    }


}
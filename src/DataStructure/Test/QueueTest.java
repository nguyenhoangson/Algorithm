package DataStructure.Test;

import DataStructure.Queue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by livetolove128 on 20/9/15.
 */
public class QueueTest {

    @Test
    public void testDequeue(){
        int testInput0 = 0;
        int testInput1 = 1;
        int testInput2 = 2;

        Queue q = new Queue();

        q.enqueue(testInput0);
        q.enqueue(testInput1);
        q.enqueue(testInput2);

        assertSame("Should dequeue the first element", testInput0, q.dequeue());
        assertSame("Should dequeue the second element", testInput1, q.dequeue());
        assertSame("Should dequeue the third element", testInput2, q.dequeue());
    }
}
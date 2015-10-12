package DataStructure.Test;

import DataStructure.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by livetolove128 on 11/10/15.
 */
public class LinkedListTest {

    @Test
    public void itShouldReturnANullHeadWhenTheListIsFirstCreated(){
        /* Test input */
        LinkedList testList1 = new LinkedList();

        assertNull(testList1.getHead());
    }

    @Test
    public void itAddElementAtTheEndOfListWhenPositionIsNotSpecifiedInAddMethod(){
        /* Test Input */
        LinkedList testInput1 = new LinkedList();
        testInput1.add(5);
        testInput1.add(6);
        testInput1.add(7);
        assertSame(7, testInput1.getTail().getData());
        assertSame(3, testInput1.size());
    }

    @Test
    public void itShouldGetTheProperNode(){
        /* Test Input */
        LinkedList testInput1 = new LinkedList();
        testInput1.add(5);
        testInput1.add(6);
        testInput1.add(7);
        testInput1.add(10);

        assertSame(5, testInput1.get(0));
        assertSame(6, testInput1.get(1));
        assertSame(7, testInput1.get(2));
        assertSame(10, testInput1.get(3));
    }

    @Test
    public void itShouldAddElementIntoExactPositionSpecified(){
        /* Test Input */
        LinkedList testInput1 = new LinkedList();
        testInput1.add(5);
        testInput1.add(6);
        testInput1.add(7);
        testInput1.add(10);

        testInput1.add(4, 19);
        testInput1.add(2, 20);
        assertSame(19, testInput1.get(4));
        assertSame(20, testInput1.get(2));
    }
}
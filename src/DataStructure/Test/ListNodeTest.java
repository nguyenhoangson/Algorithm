package DataStructure.Test;

import DataStructure.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by livetolove128 on 11/10/15.
 */
public class ListNodeTest {

    @Test
    public void itShouldInitializeListNodeProperly(){
        /* Test ListNode */
        ListNode testNode = new ListNode(1, 34);
        assertSame(1, testNode.getKey());
        assertSame(34, testNode.getData());
        assertNull(testNode.getNext());

    }

    @Test
    public void isShouldPointToProperNextListNode(){
        /* Test ListNodes */
        ListNode testNode1 = new ListNode(1,5);
        ListNode testNode2 = new ListNode(2,6);
        testNode1.setNextListNode(testNode2);
        assertSame(testNode2, testNode1.getNext());
        assertNull(testNode1.getNext().getNext());
    }
}
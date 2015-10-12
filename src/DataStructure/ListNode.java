package DataStructure;

/**
 * Created by livetolove128 on 11/10/15.
 */
public class ListNode {


    private int key;
    private int data;
    private ListNode next;

    public ListNode(int key, int data){
        this.key = key;
        this.data = data;
        this.next = null;
    }

    public void setNextListNode(ListNode nextListNode){
        this.next = nextListNode;
    }

    public int getKey(){
        return this.key;
    }

    public int getData(){
        return this.data;
    }

    public ListNode getNext(){
        return this.next;
    }
}

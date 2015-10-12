package DataStructure;

/**
 * Created by livetolove128 on 11/10/15.
 */
public class LinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public ListNode getHead(){
        return this.head;
    }

    public ListNode getTail(){
        return this.tail;
    }

    public int size(){
        return this.size;
    }

    public int add(int data){

        ListNode temp = new ListNode(0, data);

        if(this.head == null){
            this.head = temp;
            this.tail = this.head;
            this.size++;
            return this.head.getData();
        }

        // Update the tail
        tail.setNextListNode(temp);
        tail = temp;
        this.size++;
        return tail.getData();

    }

    public int get(int position){
        ListNode temp = this.head;
        int count = 0;

        while(count < this.size){

            if(count == position){
                return temp.getData();
            }
            temp = temp.getNext();
            count++;
        }
        return -1000;
    }

    public int add(int position, int data){
        ListNode temp1 = this.head;
        ListNode temp2 = new ListNode(0, data);

        int count = 0;
        if(position == this.size){
            return this.add(data);
        }
        while(count < this.size){
            if(count == position-1){
                temp2.setNextListNode(temp1.getNext());
                temp1.setNextListNode(temp2);
                return temp2.getData();
            }
            temp1 = temp1.getNext();
            count--;
        }

        return -1110;
    }
}

package DataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by livetolove128 on 20/9/15.
 */
public class Queue {

    // Attributes
    List<Integer> list = new ArrayList<>();

    // Methods
    public int dequeue(){
        int number = list.get(0);
        list.remove(0);
        return number;
    }

    public int enqueue(int number){
        list.add(number);
        return number;
    }

    public int size(){
        return list.size();
    }

}

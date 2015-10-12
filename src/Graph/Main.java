package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by livetolove128 on 19/9/15.
 */
public class Main {


    public static void main(String[] arg){

        TestJavaBehavior test1 = new TestJavaBehavior(3,4);
        TestJavaBehavior test2 =  test1;
        TestJavaBehavior test3;

        test1.setA(6);
        System.out.println("test1.a = " + test1.getA());
        System.out.println("test2.a = " + test2.getA());
        System.out.println("test2.change(test1)");
        test2.change(test1);
        System.out.println("test1.a = " + test2.getA());
        System.out.println("test2.a = " + test2.getA());
        System.out.println("test3 = test2.getThis()");
        test3 = test2.getThis();
        test3.setA(100);
        System.out.println("test1.a = " + test2.getA());
        System.out.println("test2.a = " + test2.getA());

    }
}



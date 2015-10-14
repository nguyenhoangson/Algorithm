package HaveFun;

import java.util.ArrayList;
import java.util.List;


public class TestJavaBehaviours {
    public static void main(String arg[]){
        int test = 0;
        for(int i = 0; i<10; i++){
            for(int j = 0; j<= 10; j ++){
                test = j;
                if(j == 9)
                    continue;
                System.out.print(j);
                System.out.println(i);
            }
            System.out.println(test);
        }

    }

}

package HaveFun;

import java.io.IOException;
import java.util.Hashtable;



public class Main {
    public static void main(String arg[]) throws IOException {

        /* Skiing in Singapore problem */
        SkiingInSingapore ski = new SkiingInSingapore();
        String pathFile = "/home/livetolove128/IdeaProjects/Algorithm/src/HaveFun/map.txt";
        int[][] matrix;
        Hashtable<String, Integer> result;

        matrix = ski.makeMatrix(pathFile);
        result = ski.findLongestPathOfAMatrix(matrix);

        System.out.println(result.get("Length"));
        System.out.println(result.get("Drop"));
    }

}

package HaveFun.Test;

import HaveFun.SkiingInSingapore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Hashtable;

import static org.junit.Assert.*;

public class SkiingInSingaporeTest {

    SkiingInSingapore ski;
    int[][] testInput = new int[4][4];

    @Before
    public void setUp(){
        ski = new SkiingInSingapore();
        testInput[0][0] = 4;
        testInput[0][1] = 8;
        testInput[0][2] = 7;
        testInput[0][3] = 3;
        testInput[1][0] = 2;
        testInput[1][1] = 5;
        testInput[1][2] = 9;
        testInput[1][3] = 3;
        testInput[2][0] = 6;
        testInput[2][1] = 3;
        testInput[2][2] = 2;
        testInput[2][3] = 5;
        testInput[3][0] = 4;
        testInput[3][1] = 4;
        testInput[3][2] = 1;
        testInput[3][3] = 6;
    }

    @After
    public void tearDown(){
        ski = null;
    }

    @Test
    public void itShouldReturnTheLongestPathForACertainPoint(){

        /* Test input:
         * 4 8 7 3
         * 2 5 9 3
         * 6 3 2 5
         * 4 4 1 6
         */
        Hashtable<String, Integer> actual;
        /* Generate test input */

        // Test
        actual = ski.findLongestPathOfAPoint(1, 2, testInput);
        assertSame(5, actual.get("Length"));
        assertSame(8, actual.get("Drop"));

    }

    @Test
    public void itShouldReturnTheLongestPathOfAMatrix(){
        /* Test input:
         * 4 8 7 3
         * 2 5 9 3
         * 6 3 2 5
         * 4 4 1 6
         */
        Hashtable<String, Integer> actual;
        // Test
        actual = ski.findLongestPathOfAMatrix(testInput);
        assertSame(5, actual.get("Length"));
        assertSame(8, actual.get("Drop"));

    }

    @Test
    public void itShouldReturnAMatrixWithSizeSpecifiedInTheFirstLineOfATextFile() throws IOException {

        /* File content test.txt
         * 6 6
         * 2 3 5 6 4 2
         * 7 9 0 10 4 6
         * 23 4 6 7 11 13
         * 8 9 0 1 2 6
         * 2 3 15 11 2 6
         * 9 8 6 22 11 7
        * */
        String pathFile = "/home/livetolove128/IdeaProjects/Algorithm/src/HaveFun/test.txt";
        int[][] test;
        test = ski.makeMatrix(pathFile);

        assertSame(6, test.length);
        assertSame(6, test[0].length);

    }

    @Test
    public void itShouldReturnMatrixWithProperValueForEachCell() throws IOException {
        /* File content test.txt
         * 6 6
         * 2 3 5 6 4 2
         * 7 9 0 10 4 6
         * 23 4 6 7 11 13
         * 8 9 0 1 2 6
         * 2 3 15 11 2 6
         * 9 8 6 22 11 7
        * */
        String pathFile = "/home/livetolove128/IdeaProjects/Algorithm/src/HaveFun/test.txt";
        int[][] test;
        test = ski.makeMatrix(pathFile);

        assertSame(2, test[0][0]);
        assertSame(6, test[2][2]);
        assertSame(23, test[2][0]);
        assertSame(0, test[3][2]);
    }

    @Test
    public void itShouldReturnMatrixWithMapFile() throws IOException {

        String pathFile = "/home/livetolove128/IdeaProjects/Algorithm/src/HaveFun/map.txt";
        int[][] test;
        test = ski.makeMatrix(pathFile);

        assertEquals(1000, test.length);
        assertEquals(1000, test[0].length);
        assertEquals(50, test[0][0]); // test first cell of matrix

        // test some middle random cells of matrix
        assertEquals(1198, test[14][11]);
        assertEquals(803, test[992][5]);
        assertEquals(952, test[993][8]);
        assertEquals(1460, test[999][999]); // test last cell of matrix

    }

    @Test
    public void itShouldReturnTheProperLongestPath() throws IOException{
        String pathFile = "/home/livetolove128/IdeaProjects/Algorithm/src/HaveFun/test.txt";
        int[][] matrix;
        Hashtable<String, Integer> result;

        matrix = ski.makeMatrix(pathFile);
        result = ski.findLongestPathOfAMatrix(matrix);
        System.out.println("Start point: " + result.get("StartRow") + " " + result.get("StartCol"));
        System.out.println("End point: " + result.get("EndRow") + " " + result.get("EndCol"));
        System.out.println("Start point: " + matrix[1][2]);
        System.out.println("End point: " + matrix[3][2]);
        assertSame(5, result.get("Length"));

    }
}
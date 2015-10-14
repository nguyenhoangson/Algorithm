package HaveFun.Test;

import HaveFun.SkiingInSingapore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
}
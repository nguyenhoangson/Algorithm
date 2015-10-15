package HaveFun;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/*** Problem:

Well you can’t really ski in Singapore. But let’s say you hopped on a flight to the Niseko ski resort in Japan.
Being a software engineer you can’t help but value efficiency, so naturally you want to ski as long as possible and as
fast as possible without having to ride back up on the ski lift. So you take a look at the map of the mountain and try
to find the longest ski run down.

In digital form the map looks like the number grid below.

4 4
4 8 7 3
2 5 9 3
6 3 2 5
4 4 1 6

The first line (4 4) indicates that this is a 4x4 map. Each number represents the elevation of that area of the mountain.
From each area (i.e. box) in the grid you can go north, south, east, west - but only if the elevation of the area you
are going into is less than the one you are in. I.e. you can only ski downhill. You can start anywhere on the map and
you are looking for a starting point with the longest possible path down as measured by the number of boxes you visit.
And if there are several paths down of the same length, you want to take the one with the steepest vertical drop,
i.e. the largest difference between your starting elevation and your ending elevation.

On this particular map the longest path down is of length=5 and it’s highlighted in bold below: 9-5-3-2-1.

4 4
4 8 7 3
2 5 9 3
6 3 2 5
4 4 1 6

There is another path that is also length five: 8-5-3-2-1. However the tie is broken by the first path being steeper,
dropping from 9 to 1, a drop of 8, rather than just 8 to 1, a drop of 7.

Your challenge is to write a program in your favorite programming language to find the longest (and then steepest) path
on this map specified in the format above. It’s 1000x1000 in size, and all the numbers on it are between 0 and 1500.

Send your code or a github link (and a resume if you like) to [?????? at redmart dot com], replacing “??????” with
the concatenation of the length of the longest path with the largest drop, and the size of the drop.
So in the simple example above length=5, drop=8, so the email address would be [58 at redmart dot com].
If your e-mail gets through - you got the right answer.

***/

public class SkiingInSingapore {

    public class Node{
        public int row;
        public int col;
        public int data;

        public Node(int row, int col, int data){
            this.row = row;
            this.col = col;
            this.data = data;
        }
    }

    /* TODO: make matrix based on input file */
    /* Make multi-dimension array from input file */
    public int[][] makeMatrix(String filePath) throws IOException {
        int[][] myMatrix = new int[0][];
        int line = 0;
        int count;
        int row = 0;
        int col = 0;

        // read file from filePath
        for (String lineContent : Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8)){
            line++;
            count = 0;
            for (String part : lineContent.split("\\s+")){
                Integer i = Integer.valueOf(part);

                // get size of the matrix
                if(line == 1){
                    if(count == 0){
                        row = i;
                    }

                    if(count == 1){
                        col = i;
                    }
                }

                // get number for each cell of the matrix
                if(line > 1 && line < row + 2){
                    if(count < col){
                        myMatrix[line-2][count] = i;
                    }
                }
                count++;


            }
            if(line == 1)
                myMatrix = new int[row][col];
            if(line > row + 1)
                break;
        }
        return myMatrix;
    }

    public Hashtable<String, Integer> findLongestPathOfAPoint(int row, int col, int[][] matrix){
        int level = 1;
        int rowMatrix = matrix.length - 1;
        int colMatrix = matrix[0].length - 1;
        int min;
        int data;
        int nodeData = matrix[row][col];

        // auxiliary data structures
        List<Node> temp;
        Hashtable<Integer, List<Node>> pathList = new Hashtable<>(); // node list for each level
        Hashtable<String, Integer> result = new Hashtable<>();

        // initialization
        pathList.put(1, new ArrayList<>()); // level 1: the specified node
        pathList.get(1).add(new Node(row, col, matrix[row][col]));

        result.put("Length", 1); // result returned tells us about information of the path
        result.put("Drop", 0);
        result.put("StartRow", row);
        result.put("StartCol", col);

        /* algorithm */

        // build node at each level
        while(pathList.get(level).size() != 0){

            pathList.put(level + 1, new ArrayList<>()); // Initialize next level
            temp = pathList.get(level+1);

            for(Node node: pathList.get(level)){
                row = node.row;
                col = node.col;
                data = node.data;
                if(row >= 1 && data > matrix[row-1][col]){
                    temp.add(new Node(row - 1, col, matrix[row-1][col]));
                }
                if(row < rowMatrix && data > matrix[row+1][col]){
                    temp.add(new Node(row + 1, col, matrix[row+1][col]));
                }
                if(col >= 1 && data > matrix[row][col-1]){
                    temp.add(new Node(row, col - 1, matrix[row][col-1]));
                }
                if(col < colMatrix && data > matrix[row][col+1]){
                    temp.add(new Node(row, col + 1, matrix[row][col+1]));
                }
            }
            level++;
        }

        // get the smallest node in the last level
        min = pathList.get(level - 1).get(0).data;
        result.put("EndRow", pathList.get(level - 1).get(0).row);
        result.put("EndCol", pathList.get(level - 1).get(0).col);
        for(Node node: pathList.get(level-1)){
            if(min < node.data){
                min = node.data;
                result.put("EndRow", node.row);
                result.put("EndCol", node.col);
            }
        }

        result.put("Length", level-1);
        result.put("Drop", nodeData - min);

        return result;
    }

    public Hashtable<String, Integer> findLongestPathOfAMatrix(int[][] matrix){
        int row;
        int col;
        Hashtable<String, Integer> result = new Hashtable<>();
        Hashtable<String, Integer> temp;

        // initialize
        row = matrix.length;
        col = matrix[0].length;
        result.put("Length", 1);
        result.put("Drop", 0);

        // get the longest path
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i >= 1 && matrix[i][j] < matrix[i-1][j])
                    continue;
                if(i < row - 1 && matrix[i][j] < matrix[i+1][j])
                    continue;
                if(j >= 1 && matrix[i][j] < matrix[i][j-1])
                    continue;
                if(j < col - 1 && matrix[i][j] < matrix[i][j+1])
                    continue;

                temp = findLongestPathOfAPoint(i, j, matrix);
                if(temp.get("Length") > result.get("Length")){
                    result.put("Length", temp.get("Length"));
                    result.put("Drop", temp.get("Drop"));
                    result.put("StartRow", temp.get("StartRow"));
                    result.put("StartCol", temp.get("StartCol"));
                    result.put("EndRow", temp.get("EndRow"));
                    result.put("EndCol", temp.get("EndCol"));
                }

                if(temp.get("Length").equals(result.get("Length")) && temp.get("Drop") > result.get("Drop")){
                    result.put("Drop", temp.get("Drop"));
                    result.put("StartRow", temp.get("StartRow"));
                    result.put("StartCol", temp.get("StartCol"));
                    result.put("EndRow", temp.get("EndRow"));
                    result.put("EndCol", temp.get("EndCol"));
                }
            }
        }

        return result;
    }

    public void printMatrix(int[][] matrix){
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        for(int i = 0; i <= row; i++){
            for(int j = 0; j <= col; j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}


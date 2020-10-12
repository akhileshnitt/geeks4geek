package misc;

import java.util.LinkedList;
import java.util.Queue;

public class GuardBank {

    public static void main(String[] args) {

        // G = 1
        //empty = 0
        // wall = -1
        char matrix[][] =
                {
                        {'O', 'O', 'O', 'O', 'G'},
                        {'O', 'W', 'W', 'O', 'O'},
                        {'O', 'O', 'O', 'W', 'O'},
                        {'G', 'W', 'W', 'W', 'O'},
                        {'O', 'O', 'O', 'O', 'G'}
                };

        int output [][] = new int [matrix.length][matrix[0].length];

        Queue<QNode> qNodes = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output [i][j] = -1;
                if (matrix[i][j] == 'G') {
                    qNodes.add(new QNode(i, j, 0));
                    output [i][j] = 0;
                }

            }
        }




        while (!qNodes.isEmpty()) {
            QNode temp = qNodes.poll();
            int tempI = temp.i;
            int tempJ = temp.j;
            int tempD = temp.distance;

            //top
            if (isSafe(tempI - 1, tempJ, matrix.length, matrix[0].length,output,matrix)) {
                if (matrix[tempI - 1][tempJ] != 'W' && matrix[tempI - 1][tempJ] != 'G') {

                    output[tempI-1][tempJ] = tempD + 1;
                    qNodes.add(new QNode(tempI - 1, tempJ, tempD + 1));
                }

            }
            // down   , i+1,j
            if (isSafe(tempI + 1, tempJ, matrix.length, matrix[0].length, output, matrix)) {
                if (matrix[tempI + 1][tempJ] != 'W' && matrix[tempI + 1][tempJ] != 'G') {
                    output[tempI+1][tempJ] = tempD + 1;
                    qNodes.add(new QNode(tempI + 1, tempJ, tempD + 1));
                }
            }

            //left  , i,j-1
            if (isSafe(tempI, tempJ - 1, matrix.length, matrix[0].length, output, matrix)) {
                if (matrix[tempI][tempJ - 1] != 'W' && matrix[tempI][tempJ - 1] != 'G') {
                    output[tempI][tempJ -1] = tempD + 1;
                    qNodes.add(new QNode(tempI, tempJ - 1, tempD + 1));
                }
            }
            //right , i,j+1
            if (isSafe(tempI, tempJ + 1, matrix.length, matrix[0].length, output, matrix)) {
                if (matrix[tempI][tempJ + 1] != 'W' && matrix[tempI][tempJ + 1] != 'G') {
                    output[tempI][tempJ+1] = tempD + 1;
                    qNodes.add(new QNode(tempI, tempJ + 1, tempD + 1));
                }
            }
        }

       // System.out.println(output);

        for (int[] ints : output) {
            for (int anInt : ints) {
                System.out.print(anInt+",");
            }
            System.out.println();
        }

    }

    private static boolean isSafe(int i, int j, int row, int col, int[][] output, char[][] matrix) {
        if ((i >= 0 && i < row) && (j >= 0 && j < col)) {
            if(output[i][j] == -1 && matrix[i][j] == 'O') {
                return true;
            }
        }
        return false;
    }
}

class QNode {
    int i, j, distance;

    public QNode(int i, int j, int distance) {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }
}

package matrix;

import java.util.Arrays;

public class RotateMatrixBy90AntiClock {

    public static void main(String[] args) {
        int mat[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        /**
         * 1 4 7
         * 2 5 8
         * 3 6 9
         *
         * 3 6 9
         * 2 5 8
         * 1 4 7
         */


        for(int i=1;i<=4;i++){
            System.out.println("rotating by "+ 90*i +" anticlock wise");
            rotateByAntiClockWise(mat);
        }
    }

    private static void rotateByAntiClockWise(int[][] mat) {
        transpose(mat);
        rotate(mat);
        prettyPrint(mat);
    }

    private static void rotate(int[][] mat) {
        for(int i=0;i<mat.length-1;i++){
            for(int j=0;j<mat[i].length;j++){
                //mat[i][j]  , mat[mat.length-1][j]
                int temp = mat[i][j];
                mat[i][j] = mat[mat.length-1-i][j];
                mat[mat.length-1-i][j] = temp;
            }
        }
    }

    private static void prettyPrint(int[][] mat) {
        Arrays.stream(mat).forEach(e-> {
            System.out.println();
            Arrays.stream(e).forEach(f-> System.out.print(f+","));
        } );
        System.out.println();
    }
    private static void transpose(int[][] mat) {

        for(int i=0;i<mat.length;i++){
            for(int j=i;j<mat[i].length;j++){

                //  swap(mat[i][j],mat[j][i]);

                swap(mat, i, j);
            }
        }
    }

    private static void swap(int[][] mat, int i, int j) {
        int temp = mat[j][i];
        mat[j][i] = mat[i][j];
        mat[i][j] =temp;
    }
}

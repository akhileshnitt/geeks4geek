package matrix;

import java.util.Arrays;

public class RotateBy90ClockWise {


    public static void main(String[] args) {
        int mat[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

       /* int mat[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };*/

        /**
         * transpose
         * 1 4 7
         * 2 5 8
         * 3 6 9
         *
         * rotation
         * 7 4 1
         * 8 5 2
         * 9 6 3
         */

        for(int i=1;i<=4;i++){
            System.out.println("rotating by "+ 90*i);
            rotateByClockWise(mat);
        }
       /* transpose(mat);

        System.out.println("transpose\n");
        prettyPrint(mat);

        System.out.println("\nrotation by 90 clockwise\n");
        rotateBy90ClockWise(mat);

        prettyPrint(mat);*/
    }

    private static void rotateByClockWise(int[][] mat){
        transpose(mat);
        rotateBy90ClockWise(mat);
        prettyPrint(mat);

    }
    private static void rotateBy90ClockWise(int[][] mat) {
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length-1;j++){
                 //mat[i][j] , mat[i][mat[i].length -1 -i];

                int temp = mat[i][j];
                mat[i][j] = mat[i][mat[i].length -1 -j];
                mat[i][mat[i].length -1 -j] =temp;
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

    private static void swap(int i, int j) {
    }
}

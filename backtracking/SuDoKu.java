package backtracking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SuDoKu {

    public static void main(String[] args) {

        int matrix[][] = new int[9][9];
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("/Users/z002x5k/Downloads/untitled/src/backtracking/input.txt")));
            String line= null;
            int i=0;
            while((line = br.readLine() )!= null){


                String tokens [] = line.split(",");
                for(int j=0; j<tokens.length;j++){
                    matrix[i][j] = Integer.valueOf(tokens[j]);
                }
                i++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        System.out.println("Before solving");

        prettyPrint(matrix);

        int N = matrix.length;

        if (solveSudoku(matrix, N))
        {
            prettyPrint(matrix); // print solution
        }
        else
        {
            System.out.println("No solution");
        }

    }



    public static boolean solveSudoku(int[][] board, int n)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0)
                {
                    row = i;
                    col = j;

                    // we still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty)
            {
                break;
            }
        }

        // no empty space left
        if (isEmpty)
        {
            return true;
        }

        // else for each-row backtrack
        for (int num = 1; num <= n; num++)
        {
            if (isSafe(board, row, col, num))
            {
                board[row][col] = num;
                if (solveSudoku(board, n))
                {
                    // print(board, n);
                    return true;
                }
                else
                {
                    board[row][col] = 0; // replace it
                }
            }
        }
        return false;
    }


    private static boolean solveSudoKu(int[][] matrix) {


        int row = -1;
        int col = -1;
        boolean isEmpty=true ;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){

                if(matrix[i][j] ==0){
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }

            }
            if (!isEmpty)
            {
                break;
            }
        }

        if(isEmpty){
            return true;
        }


        for(int k=1;k<=matrix.length;k++){
            int num = k;
            if(isSafe(matrix,row,col,k)){
                matrix[row][col] = num;

                if(solveSudoKu(matrix)){
                    return true;
                }
                else{
                    matrix[row][col] = 0;
                    System.out.println("backtracking");
                }
            }
        }

        return false;

    }



    private static boolean isSafe(int [][] mat, int row, int col, int number) {
        System.out.println("isSafe row :"+row+" col :"+col);

        if( validateRow(mat,row,col,number) && validateColumn(mat,row,col,number) && validateSubMatrix(mat,row,col,number)){

            return true;
        }
        return false;
    }

    private static boolean validateSubMatrix(int[][] mat, int row1,int col1,int number) {

        int sqrt = (int) Math.sqrt(mat.length);
        int boxRowStart = row1 - row1 % sqrt;
        int boxColStart = col1 - col1 % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++)

        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (mat[r][d] == number)
                {
                    return false;
                }
            }
        }
        return true;


    }

    private static boolean validateColumn(int[][] mat, int row1,int coll1,int number) {

        int col = coll1;
        System.out.println("validateColumn row :"+row1+" col :"+col);


        for(int i=0;i<9;i++){
            if(number == mat[i][col]){
                return false;
            }
        }

        return true;
    }

    private static boolean validateRow(int [][] mat,int row1,int col1,int number) {

        int row = row1;
        if(row <0) return false;

        System.out.println("validateRow row :"+row+" col :"+col1);

        for(int i=0;i<9;i++){
            if(number == mat[row][i]){
                return false;
            }
        }

        return true;
    }



    private static void prettyPrint(int [][] a) {
        System.out.println("\t-------------------------------------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print("\t| "+a[i][j]);
            }

            System.out.print("\t|");
            System.out.println();

            System.out.println("\t-------------------------------------");
        }

    }

}

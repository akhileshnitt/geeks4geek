package backtracking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class SudoKuSolver {

    public static void main(String[] args) {

        Cell matrix[][] = new Cell[9][9];

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("/Users/z002x5k/Downloads/untitled/src/backtracking/input.txt")));
            String line= null;
            int i=0;
            while((line = br.readLine() )!= null){


                String tokens [] = line.split(",");
                for(int j=0; j<tokens.length;j++){
                    matrix[i][j] = new Cell(i,j,Integer.parseInt(tokens[j]));
                }
                i++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


       // interInput(matrix);
        System.out.println("Before solving");

        prettyPrint(matrix);

        solveSudoKu(matrix);

        System.out.println("After solving");

        prettyPrint(matrix);
    }

    private static void solveSudoKu(Cell [][] matrix) {
        Stack<Cell> stack = new Stack<>();
        for(int row=0;row<matrix.length;row++) {
            for (int col = 0; col < matrix[row].length; ) {

                System.out.println(row +" ,"+col);
                if (matrix[row][col].number == 0) {
                    if (!solve(matrix, matrix[row][col])) {
                        boolean successs = false;
                        while (!stack.isEmpty() && !successs) {
                            Cell cell = stack.pop();
                            if (solve(matrix, cell)) {
                                //row = cell.i;
                               // col = cell.j -1;
                                col = cell.j;

                                successs = true;
                                stack.push(cell);
                        //        break;
                            }

                        }

                    } else {
                        stack.push(matrix[row][col]);
                        col++;
                    }
                }
                if (stack.size() == 81) {

                    System.out.println("solution found");
                    prettyPrint(matrix);
                    break;
                }
                if (stack.isEmpty()) {
                    System.out.println("No Solution found");
                    break;
                }
            }
        }
    }

    private static boolean solve(Cell [][] mat,Cell cell) {

        for(int i=1;i<=9;i++){
            int number =0;
            if(cell.number != i) {
                number = i;
            }
            if(validateCell(mat,cell,number)){
                return true;
            }
        }
        return false;
    }

    private static boolean validateCell(Cell [][] mat,Cell cell,int number) {

        if( validateRow(mat,cell,number) && validateColumn(mat,cell,number) && validateSubMatrix(mat,cell,number)){
            cell.number = number;
            return true;
        }
        return false;
    }

    private static boolean validateSubMatrix(Cell[][] mat, Cell cell,int number) {

        int row = cell.i - (cell.i %3);
        int col = cell.j - (cell.j %3);


        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
               if(mat[row][col].number == number && mat[row][col] != null){
                   return false;
               }
            }
        }
        return true;


    }

    private static boolean validateColumn(Cell[][] mat, Cell cell,int number) {

        int col = cell.j;



        for(int i=0;i<9;i++){
            if(number == mat[i][col].number && mat[i][col]!= cell){
                return false;
            }
        }

        return true;
    }

    private static boolean validateRow(Cell [][] mat,Cell cell,int number) {

        int row = cell.i;



        for(int i=0;i<9;i++){
          if(number == mat[row][i].number && mat[row][i] != cell){
              return false;
          }
        }

        return true;
    }


    private static void interInput(Cell[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        for(int row1 = 0; row1< matrix.length; row1++){
            System.out.println("enter  row : "+row1);
            for(int col1 = 0 ;col1< matrix[row1].length; col1++){
                System.out.println("enter the elementss for the column :"+col1);
                matrix[row1][col1] = new Cell(row1,col1,scanner.nextInt());
            }
        }
    }

    private static void prettyPrint(Cell[][] a) {
        System.out.println("\t-------------------------------------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print("\t| "+a[i][j].number);
            }

            System.out.print("\t|");
            System.out.println();

            System.out.println("\t-------------------------------------");
        }

    }
}

class  Cell{

    int i;
    int j;
    int number;

    public Cell(int i, int j, int number) {
        this.i = i;
        this.j = j;
        this.number = number;
    }


    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getNumber() {
        return number;
    }
}

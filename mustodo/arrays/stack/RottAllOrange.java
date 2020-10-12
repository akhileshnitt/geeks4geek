package mustodo.arrays.stack;

import java.util.LinkedList;
import java.util.Queue;

public class RottAllOrange {

    static int X[] = {-1,1,0,0};
    static int Y[] = {0,0,-1,1};

    public static void main(String[] args) {


        int mat[][] = {
                {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1},
        };

       /* int minTime = minTime(mat, mat.length, mat[0].length);
        System.out.println(minTime);*/

        int minTime1 = minTime1(mat, mat.length, mat[0].length);
        System.out.println(minTime1);
    }

    private static int minTime1(int[][] mat, int row, int col) {
        Queue<Cell> cells = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j] == 2){
                    cells.add(new Cell(i,j));
                }
            }
        }
        int time=0;
        while (!cells.isEmpty()){
            int size = cells.size();
            boolean isUpdate = false;
            for(int i=0;i<size;i++){
                Cell  cell = cells.poll();

                for(int j =0;j<X.length;j++){
                    if(isSafe(mat,cell.i+X[j],cell.j+Y[j])){
                        mat[cell.i+X[j]][cell.j+Y[j]] =2;
                        cells.add(new Cell(cell.i+X[j],cell.j+Y[j]));
                        isUpdate = true;
                    }
                }
            }
            if(isUpdate){
                time++;
            }
        }

        return allRotted(mat).size()!=0?-1:time;
    }

    private static int minTime(int[][] mat, int row, int col) {
        int totalTime=0;
        int preRot = Integer.MAX_VALUE;

        while (true){
            int size = allRotted(mat).size();
            if(size ==preRot){
                return -1;
            }
            if(size ==0) return totalTime;
            if(size>0){
                preRot = size;
                totalTime++;
                rotCell(mat, row, col);
            }
        }

    }

    private static Queue<Cell> allRotted(int[][] mat) {

        Queue<Cell> cells = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 1){
                    cells.add(new Cell(i,j));
                }
            }
        }
        return cells;
    }

    private static void rotCell(int[][] mat, int row, int col) {
        Queue<Cell> cells = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j] == 2){
                    cells.add(new Cell(i,j));
                }
            }
        }

        while (!cells.isEmpty()){
            Cell cell = cells.remove();
            rot(mat,cell);
        }
    }

    private static void rot(int[][] mat, Cell cell) {
        for(int i =0;i<X.length;i++){
            if(isSafe(mat,cell.i+X[i],cell.j+Y[i])){
                mat[cell.i+X[i]][cell.j+Y[i]] =2;
            }
        }
    }

    private static boolean isSafe(int[][] mat, int i, int j) {
        if(i<0|| i>=mat.length || j<0 ||j>=mat[0].length ) return false;
        return mat[i][j] != 0 && mat[i][j] != 2;
    }


    static class Cell{
        int i,j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

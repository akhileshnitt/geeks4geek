package graph;

public class NumberOfIsland {

    public static void main(String[] args) {
        int mat[][] = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        int row = mat.length;
        int col = mat[0].length;

        System.out.println("Row :" + mat.length);
        System.out.println("Col :" + mat[0].length);

        boolean visited[][] = new boolean[row][col];
        int noOfIsland = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && !visited[i][j]) {
                    noOfIsland++;
                    visited[i][j] = true;
                    dfs(mat, visited, i, j, row, col);
                }
            }
        }

        System.out.println("Number of Island :" + noOfIsland);


    }

    private static void dfs(int[][] mat, boolean[][] visited, int i, int j, int row, int col) {

        if ((i >= 0 && i < row) && (j >= 0 && j < col)) {

            //up
            if (isSafe(i-1,j,row,col) && mat[i - 1][j] == 1 && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                dfs(mat, visited, i - 1, j, row, col);
            }
            //down
            else  if (isSafe(i+1,j,row,col)&& mat[i + 1][j] == 1 && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                dfs(mat, visited, i + 1, j, row, col);
            }
            //left
            else  if (isSafe(i,j-1,row,col) && mat[i][j-1] == 1 && !visited[i][j-1]) {
                visited[i ][j-1] = true;
                dfs(mat, visited, i, j-1, row, col);
            }
            //right
            else  if (isSafe(i,j+1,row,col) && mat[i][j+1] == 1 && !visited[i][j+1]) {
                visited[i ][j+1] = true;
                dfs(mat, visited, i, j+1, row, col);
            }
            //diagonalTopLeft
            else  if (isSafe(i-1,j-1,row,col) && mat[i-1][j-1] == 1 && !visited[i-1][j-1]) {
                visited[i-1 ][j-1] = true;
                dfs(mat, visited, i-1, j-1, row, col);
            }
            //diagonalTopRight
            else  if (isSafe(i-1,j+1,row,col) && mat[i-1][j+1] == 1 && !visited[i-1][j+1]) {
                visited[i-1 ][j+1] = true;
                dfs(mat, visited, i-1, j+1, row, col);
            }
            //diagonalBottomLeft
            else  if (isSafe(i+1,j-1,row,col) && mat[i+1][j-1] == 1 && !visited[i+1][j-1]) {
                visited[i+1 ][j-1] = true;
                dfs(mat, visited, i+1, j-1, row, col);
            }
            //diagonalBottomRight
            else  if (isSafe(i+1,j+1,row,col) && mat[i+1][j+1] == 1 && !visited[i+1][j+1]) {
                visited[i+1 ][j+1] = true;
                dfs(mat, visited, i+1, j+1, row, col);
            }

        }
    }

    private static boolean isSafe(int i, int j, int row, int col) {
        return  ( (i>=0 && i<row) && (j>=0 && j<col));
    }
}

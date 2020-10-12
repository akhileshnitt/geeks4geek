package misc;

public class WordExist {

    public static void main(String[] args) {
        char grid[][] = { "axmy".toCharArray(),
                          "bgdf".toCharArray(),
                          "xeet".toCharArray(),
                          "raks".toCharArray() };

        // Function to check if word exists or not
        if (checkMatch(grid, "geeks", grid.length, grid[0].length))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    private static boolean checkMatch(char[][] grid, String word, int row, int col) {
        int i1=-1,j1=-1;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if(grid[i][j] == word.charAt(0)){
                    i1 = i;
                    j1= j;
                    break;
                }
            }
        }

        if(i1 ==-1 || j1 == -1) return false;


        boolean [][] visited = new boolean[row][col];
        visited[i1][j1] = true;
        StringBuffer sb = new StringBuffer();
        sb.append(word.charAt(0));
        visited[i1][j1] = true;
        return checkWordCanFormed(grid,word,i1,j1,0,grid.length,grid[0].length);


    }

    private static boolean checkWordCanFormed(char[][] grid, String word, int i1, int j1, int index, int row, int col) {


       if((i1 <0 || i1>=row|| j1<0 ||j1>=col))
           return false;


       if(word.length() == index)
           return true;

       if(grid[i1][j1] == word.charAt(index) ){

           char temp = grid[i1][j1];
           grid[i1][j1] = '#';

           boolean res = checkWordCanFormed(grid,word,i1-1,j1,index+1,row,col) |
                   checkWordCanFormed(grid,word,i1+1,j1,index+1,row,col) |
                   checkWordCanFormed(grid,word,i1,j1-1,index+1,row,col) |
                   checkWordCanFormed(grid,word,i1,j1+1,index+1,row,col) ;

           grid[i1][j1] = temp;
           return res;
       }
       else
           return false;
        //top  i-1,j

        // down   , i+1,j


        //left  , i,j-1

        //right , i,j+1





    }


    private static boolean isSafe(int i, int j, int row, int col, char[][] matrix, boolean[][] visited, int index, String word) {
        if ((i >= 0 && i < row) && (j >= 0 && j < col) && !visited[i][j]) {
            if(index<word.length() && matrix[i][j] == word.charAt(index)) {
                visited[i][j] = true;
                return true;
            }
        }
        return false;
    }
}

package misc;

import java.util.LinkedList;
import java.util.Queue;

public class PatternSsearch {

    public static void main(String[] args) {
        String words[] = {"GEEKSFORGEEKS",
                          "GEEKSQUIZGEEK",
                          "IDEQAPRACTICE"};

        String  word = "GEEKS";
        int row = words.length;
        int col = words[0].length();


        Queue<Cell> queue = new LinkedList<>();
        char [][] mat = new char[row][col];
        for (int i = 0; i <row ; i++) {
            for (int j=0;j<col;j++){
                mat[i][j] = words[i].toCharArray()[j];
                if(mat[i][j] == 'G'){
                    queue.add(new Cell(i,j));
                }
            }
        }




        boolean [][] visited = new boolean[row][col];
        while (!queue.isEmpty()){
            Cell cell = queue.poll();

            visited[cell.i][cell.j] = true;
            StringBuffer sb = new StringBuffer();
            sb.append(mat[cell.i][cell.j]);
            int r=cell.i;
            int c= cell.j;
          //  System.out.println("****************** "+ r+","+c);
            doDfs(cell.i,cell.j,mat,cell.i,cell.j,word,sb,visited,1);
        }



    }

    private static void doDfs(int r, int c, char[][] matrix, int tempI, int tempJ, String word, StringBuffer s, boolean[][] visited, int index) {
        if(index > word.length()) return;
     //   System.out.println(s);
        if(s.toString().equals(word)){
            System.out.println("Pattern found at : ("+r+","+c+")");
        //    System.out.println("Pattern found at : ("+tempI+","+tempJ+")");
            return;
        }

        //top
        if (isSafe(tempI - 1, tempJ, matrix.length, matrix[0].length,matrix,visited,index,word)) {
            index = index+1;
           doDfs(r, c, matrix,tempI-1,tempJ,word,s.append(matrix[tempI - 1][tempJ]), visited, index);
           s.deleteCharAt(s.length()-1);
            index = index-1;
        }
        // down   , i+1,j
         if (isSafe(tempI + 1, tempJ, matrix.length, matrix[0].length,  matrix,visited, index, word)) {
             index = index+1;
            doDfs(r, c, matrix,tempI+1,tempJ,word,s.append(matrix[tempI + 1][tempJ]), visited, index);
            s.deleteCharAt(s.length()-1);
             index = index-1;

        }

        //left  , i,j-1
         if (isSafe(tempI, tempJ - 1, matrix.length, matrix[0].length,  matrix, visited, index, word)) {
             index = index+1;
            doDfs(r, c, matrix,tempI,tempJ-1,word,s.append(matrix[tempI][tempJ-1]), visited, index);
            s.deleteCharAt(s.length()-1);
            index = index -1;
        }
        //right , i,j+1
         if (isSafe(tempI, tempJ + 1, matrix.length, matrix[0].length,  matrix, visited, index, word)) {
             index = index+1;
            doDfs(r, c, matrix,tempI,tempJ+1,word,s.append(matrix[tempI][tempJ+1]), visited, index);
            s.deleteCharAt(s.length()-1);
             index = index-1;
        }


         if (isSafe(tempI-1, tempJ - 1, matrix.length, matrix[0].length,  matrix, visited, index, word)) {
             index = index+1;
            doDfs(r, c, matrix,tempI -1,tempJ-1,word,s.append(matrix[tempI-1][tempJ -1]), visited, index);
            s.deleteCharAt(s.length()-1);
             index = index-1;
        }

         if (isSafe(tempI+1, tempJ - 1, matrix.length, matrix[0].length,  matrix, visited, index, word)) {
             index = index+1;
            doDfs(r, c, matrix,tempI +1,tempJ - 1,word,s.append(matrix[tempI+1][tempJ -1]), visited, index);
            s.deleteCharAt(s.length()-1);
             index = index-1;
        }

         if (isSafe(tempI-1, tempJ + 1, matrix.length, matrix[0].length,  matrix, visited, index, word)) {
             index = index+1;
            doDfs(r, c, matrix,tempI -1,tempJ + 1,word,s.append(matrix[tempI-1][tempJ +1]), visited, index);
            s.deleteCharAt(s.length()-1);
             index = index-1;
        }

         if (isSafe(tempI + 1, tempJ + 1, matrix.length, matrix[0].length,  matrix, visited, index, word)) {
             index = index+1;
            doDfs(r, c, matrix,tempI +1,tempJ + 1,word,s.append(matrix[tempI+1][tempJ +1]), visited, index);
            s.deleteCharAt(s.length()-1);
             index = index-1;
        }

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


class Cell{
    int i;
    int j;

    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
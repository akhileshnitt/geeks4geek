package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AllOccurenceOfWord {

    static int rowNum[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int colNum[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    static  List<IndexHolder> list = new ArrayList<>();


    public static void main(String[] args) {

        char grid [][] = { {'B', 'N', 'E', 'Y', 'S'},
                           {'H', 'E', 'D', 'E', 'S'},
                           {'S', 'G', 'N', 'D', 'E'}
                         };

        String word = "DES";


        boolean [][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 'D'){

                    System.out.println();
                    IndexHolder [] holder = new IndexHolder[word.length()];
                    findOccurence1(grid,word,i,j,0,visited,list,"",word.length()-1,holder);
                }
            }
        }
    }

    private static void findOccurence(char[][] grid, String word, int i, int j, int index, boolean[][] visited, List<IndexHolder> list, String path, int n) {

        if(index >n) return;
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j] != word.charAt(index)|| visited[i][j]){
            return;
        }

        path += "("+word.charAt(index)+","+i+","+j+") ";

        if (index == n)
        {
            System.out.print(path +"\n");

          //  list.forEach(e-> System.out.print("("+e.data+","+e.i+","+e.j+") "));
          //  System.out.println();
            return;
        }

        visited[i][j] = true;

        for(int k=0;k<rowNum.length;k++){
            findOccurence(grid,word,i+rowNum[k],j+colNum[k],index+1, visited, list, path, n);
            visited[i][j] = false;
        }

    }


    private static void findOccurence1(char[][] grid, String word, int i, int j, int index, boolean[][] visited, List<IndexHolder> list, String path, int n, IndexHolder[] holder) {

        if(index >n) return;
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j] != word.charAt(index)|| visited[i][j]){
            return;
        }
        holder[index] = new IndexHolder(i,j,word.charAt(index));
        path += "("+word.charAt(index)+","+i+","+j+") ";

        if (index == n)
        {
           // System.out.print(path +"\n");

            //  list.forEach(e-> System.out.print("("+e.data+","+e.i+","+e.j+") "));
            //  System.out.println();
            for (int i1 = 0; i1 < holder.length; i1++) {
                IndexHolder e = holder[i1];
                System.out.print("("+e.data+","+e.i+","+e.j+") ");

            }
            System.out.println();
            return;
        }

        visited[i][j] = true;

        for(int k=0;k<rowNum.length;k++){

            findOccurence1(grid,word,i+rowNum[k],j+colNum[k],index+1, visited, list, path, n, holder);
            visited[i][j] = false;
        }

    }



}
class IndexHolder{
    int i;
    int j;
    char data;

    public IndexHolder(int i, int j, char data) {
        this.i = i;
        this.j = j;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndexHolder that = (IndexHolder) o;
        return i == that.i &&
                j == that.j &&
                data == that.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j, data);
    }
}

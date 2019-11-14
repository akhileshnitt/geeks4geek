package dp;

public class MaxLengthPath {

    public static void main(String[] args) {
      /*  int mat[][] = { { 1, 2, 9 },
                        { 5, 3, 8 },
                        { 4, 6, 7 } };*/

        int mat[][] = { { 1, 2, 3 },
                        { 6, 5, 4 },
                        { 7, 8, 9 } };

        System.out.println("Length of the longest path is :  " + finLongestOverAll(mat));
    }

    private static String finLongestOverAll(int[][] mat) {
        int maxLength = 0;
        String maxString = null;
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               boolean visited [][] = new boolean[3][3];
               StringBuffer sb = new StringBuffer();
               sb.append(mat[i][j]+"->");

               visited[i][j] = true;
               visit(mat,i,j,sb,visited);

               if(sb.length() > maxLength) {
                   maxLength = sb.length();
                   maxString = sb.toString();
                 //  System.out.println(sb.toString());
               }

           }
       }
       return maxString;
    }

    private static void visit(int[][] mat, int i, int j, StringBuffer sb, boolean[][] visited) {


        if( (i <3 ||i>=0) && ( j<3 || j>=0) ){

            //right
            if( j+1 <3 && !visited[i][j+1] && mat[i][j+1] - mat[i][j] == 1){
                sb.append(mat[i][j+1]+"->");
                visited[i][j+1] = true;
                visit(mat,i,j+1,sb, visited);
            }
            //left
            if(j-1 >=0 && !visited[i][j-1] && mat[i][j-1] - mat[i][j] == 1){
                sb.append(mat[i][j-1]+"->");
                visited[i][j-1] = true;
                visit(mat,i,j-1,sb, visited);
            }
            //top


            if(i-1 >=0 && !visited[i-1][j] && mat[i-1][j] - mat[i][j] == 1){
                sb.append(mat[i-1][j]+"->");
                visited[i-1][j] = true;
                visit(mat,i-1,j,sb, visited);
            }

            //down
            if(i+1 <3 &&  !visited[i+1][j] && mat[i+1][j] - mat[i][j] == 1){
                sb.append(mat[i+1][j]+"->");
                visited[i+1][j] = true;
                visit(mat,i+1,j,sb, visited);
            }



        }
    }
}

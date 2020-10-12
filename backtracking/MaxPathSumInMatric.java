package backtracking;

public class MaxPathSumInMatric {

    static  int MAX_SUM = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int [][] mat = {
                {100,-350,-200},
                {-100,-300,700}};
        //oop - 500
        // move -> right,down, diagonal  right

        int startRow =0,startCol=0;
        int endRow = 1,endCol = 2;

        findMaxPathSum(mat,startRow,startCol,endRow,endCol,mat[startRow][startCol]);

        System.out.println(MAX_SUM);

    }

    private static void findMaxPathSum(int[][] mat, int startRow, int startCol, int endRow, int endCol,int totalSum) {

        if(startRow == endRow &&  startCol == endCol){
            if(totalSum >MAX_SUM){
                MAX_SUM = totalSum;
            }
        }

        //right
        if((startRow>=0 && startRow<=endRow) && (startCol >=0 && startCol+1<=endCol )){
            findMaxPathSum(mat,startRow,startCol+1,endRow,endCol,totalSum+mat[startRow][startCol+1]);
        }

        // down

        if((startRow>=0 && startRow+1<=endRow) && (startCol >=0 && startCol<=endCol )){
            findMaxPathSum(mat,startRow+1,startCol,endRow,endCol,totalSum+mat[startRow+1][startCol]);
        }

        // diagonal right
        if((startRow>=0 && startRow+1<=endRow) && (startCol >=0 && startCol+1<=endCol )){
            findMaxPathSum(mat,startRow+1,startCol+1,endRow,endCol,totalSum+mat[startRow+1][startCol+1]);
        }

    }
}

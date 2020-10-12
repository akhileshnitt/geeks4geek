package mustodo.arrays.recursion;

public class CountAllPath {

    static int count =0;
    public static void main(String[] args) {
        //int row =3,col=3;
        int row =3,col=3;
        int [][] mat = new int [row][col];

        countPath(mat,0,0,row-1,col-1,row,col);
        System.out.println(count);
    }

    private static void countPath(int[][] mat, int startI, int startJ, int endI, int endJ,int row,int col) {
        if(startI <0 ||startI>row ||startJ <0 ||startJ >col ||endI <0 ||endI >row||  endJ <0 ||endJ >col) return;
        if(startI == endI && startJ == endJ){
            count = count+1;
            return;
        }

        // i j - 1,1,
        // i , j+1
        //i+1,j
        countPath(mat,startI,startJ+1,endI,endJ,row,col);
        countPath(mat,startI+1,startJ,endI,endJ,row,col);
    }
}

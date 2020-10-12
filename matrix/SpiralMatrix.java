package matrix;

public class SpiralMatrix {

    public static void main(String[] args) {

        int row = 4;
        int col = 4;

        int[][] mat = new int[row][col];

        int no = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = no++;
            }
        }


        // print matrix

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j] + ",");
            }
            System.out.println();
        }


        System.out.println();
        printSpiral(mat, row, col, Direction.RIGHT);
    }




    private static void printSpiral(int[][] mat, int row, int col, Direction direction) {
        int count =0;
        int row1 =0,col1=0, rowLength = row, colLength=col;
        while(count < row*col) {
            if (direction.name().equals("RIGHT")) {
                //   System.out.println("right");
                int rowNum = row1;
                for (int i = col1; i < colLength; i++) {
                    System.out.print(mat[rowNum][i] + ",");
                    count++;
                }
                row1++;
                direction = Direction.DOWN;
            }
            else if (direction.name().equals("DOWN")) {
                //   System.out.println("right");
                int colTo = colLength-col1 -1;
                int rowTo = row1;

                for (int i = rowTo; i < rowLength-row1; i++) {
                    System.out.print(mat[i][colTo] + ",");
                    count++;
                }
               // col1++;
                direction = Direction.LEFT;
            }
            else if(direction.name().equals("LEFT")){
                int rowNum = rowLength-row1;
                int colNum = colLength - col1 -1 ;
                for(int j=colNum;j>=0;j--){
                    System.out.print(mat[rowNum][j]+",");
                    count++;
                }

                direction = Direction.UP;
            }
            else if(direction.name().equals("UP")){

                int colTo = col1;
                int rowTo = rowLength -1;

                for(int j=rowTo;j>=0;j--){
                    System.out.print(mat[j][colTo]+",");
                    count++;
                }
                col1++;
                direction = Direction.RIGHT;
            }

        }
    }



    private static void printSpiralrow(int[][] mat, int row, int col, Direction direction) {
        int count =0;
        int row1 =0,col1=0, rowLength = row, colLength=col;
        while(count < row*col) {
            if (direction.name().equals("RIGHT")) {
                //   System.out.println("right");
                int rowNum = row1;
                for (int i = col1; i < colLength; i++) {
                    System.out.print(mat[rowNum][i] + ",");
                    count++;
                }
                row1++;
                direction = Direction.LEFT;
            }
            else if(direction.name().equals("LEFT")){
                int rowNum = rowLength-row1;
                int colNum = colLength - col1 -1 ;
                for(int j=colNum;j>=0;j--){
                    System.out.print(mat[rowNum][j]+",");
                    count++;
                }

                direction = Direction.RIGHT;
            }

        }
    }


    private static void printSpiral1(int[][] mat, int row, int col, Direction direction) {
        int count =0;
        int row1 =0,col1=0, rowLength = row, colLength=col;
        while(count < row*col) {
            if (direction.name().equals("RIGHT")) {
             //   System.out.println("right");
                for (int i = col1; i < colLength; i++) {
                    System.out.print(mat[row1][i] + ",");
                    count++;
                }

                direction = Direction.DOWN;
            } else if (direction.name().equals("DOWN")) {
                //System.out.println("Down");
                for (int j = row1; j < colLength; j++) {
                    System.out.print(mat[j][colLength-1]+",");
                    count++;
                }

                direction = Direction.LEFT;
            }
            else if (direction.name().equals("LEFT")) {
             //   System.out.println("LEFT");
                for (int j = rowLength-row1-1; j >=0; j--) {
                    System.out.print(mat[j][j]+",");
                    count++;
                }

                direction = Direction.UP;
            }
            else if(direction.name().equals("UP")){
                for(int j=row-1;j>=0;j--){
                    System.out.print(mat[j][0]+",");
                    count++;
                }

                direction = Direction.RIGHT;
            }
            row1++;
        }
    }
}

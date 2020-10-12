package misc;

public class ShortestDistance {

    static int shortestDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {

        char[][] matrix =
                {{'0', '*', '0', 's'},
                {'*', '0', '*', '*'},
                {'0', '*', '*', '*'},
                {'d', '*', '*', '*'}};

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        findShortest(matrix, visited);


        System.out.println("******************");
        System.out.println(shortestDistance);
    }

    private static void findShortest(char[][] matrix, boolean[][] visited) {

        int sourceI = -1, sourceJ = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 's') {
                    sourceI = i;
                    sourceJ = j;
                }
            }
        }


        destDistance(matrix, sourceI, sourceJ, 0, visited);
    }

    private static void destDistance(char[][] matrix, int tempI, int tempJ, int distance, boolean[][] visited) {
        if (matrix[tempI][tempJ] == 'd') {
            if (distance < shortestDistance) {
                System.out.println(distance);
                shortestDistance = distance;
                return;
            }
        }

        //top
        if (isSafe(tempI - 1, tempJ, matrix.length, matrix[0].length, visited,matrix)) {
            visited[tempI - 1][tempJ] = true;
            destDistance(matrix, tempI - 1, tempJ, distance + 1, visited);
            visited[tempI-1][tempJ ] = false;
        }
        // down   , i+1,j
         if (isSafe(tempI + 1, tempJ, matrix.length, matrix[0].length, visited, matrix)) {
            visited[tempI + 1][tempJ] = true;
            destDistance(matrix, tempI + 1, tempJ, distance + 1, visited);
            visited[tempI + 1][tempJ] = false;
        }
        //left  , i,j-1
         if (isSafe(tempI, tempJ - 1, matrix.length, matrix[0].length, visited, matrix)) {
            visited[tempI][tempJ - 1] = true;
            destDistance(matrix, tempI, tempJ - 1, distance + 1, visited);
            visited[tempI][tempJ - 1] = false;
        }
        //right , i,j+1
         if (isSafe(tempI, tempJ + 1, matrix.length, matrix[0].length, visited, matrix)) {
            visited[tempI][tempJ + 1] = true;
            destDistance(matrix, tempI, tempJ + 1, distance + 1, visited);
            visited[tempI][tempJ + 1] = false;
        }


    }


    private static boolean isSafe(int i, int j, int row, int col, boolean[][] visited, char[][] matrix) {
        if ((i >= 0 && i < row) && (j >= 0 && j < col) && !visited[i][j]  && matrix[i][j] != 's' && matrix[i][j] != '0') {

            return true;

        }
        return false;
    }
}

package misc;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MInStepByKnightBfs {

    static int MINIMU_DISTANCE = Integer.MAX_VALUE;

    public static void main(String[] args) {
       /* int N = 30;
        int knight[] = {1, 1};
        int target[] = {N - 1, N - 1};*/


        int N=6;
        int knight [] = {4,5};
        int target [] = {1,1};

        boolean[][] visited = new boolean[N][N];

        int minimu = findMinimumDistance(knight[0], knight[1], target, visited,N);

        System.out.println();
        System.out.println(" MINIMU_DISTANCE  :" + minimu);


        //  list.forEach(e-> System.out.print("--> ("+e.i+","+e.j+")"));

        // i-2 , j+1  --
        // i-2, j-1   --
        // i-1 , j-2  --
        // i+1 , j-2  --

        // i+2 , j-1  --
        // i+2 , j+1 --
        // i-1 , j+2  --
        // i+1 , j+2  --
    }

    private static int  findMinimumDistance(int sourceI, int sourceJ, int[] target, boolean[][] visited,int N) {

        visited[sourceI][sourceJ] = true;
        Queue<Pair1> queue = new LinkedList<>();
        queue.add(new Pair1(sourceI,sourceJ,0));

        while(!queue.isEmpty()){
            Pair1 temp = queue.poll();

            if(temp.i == target[0] && temp.j==target[1]){
                return temp.distance;
            }


            // traverse in 8 direction
            // i-2 , j+1
            if(isSafe(temp.i-2 , temp.j+1,visited,target,N)){
             queue.add(new Pair1(temp.i-2 , temp.j+1,temp.distance+1));
            }
            // i-2, j-1
            if(isSafe(temp.i-2 , temp.j-1,visited,target,N)){
                queue.add(new Pair1(temp.i-2 , temp.j-1,temp.distance+1));
            }

            // i-1 , j-2
            if(isSafe(temp.i-1 , temp.j-2,visited,target,N)){
                queue.add(new Pair1(temp.i-1 , temp.j-2,temp.distance+1));
            }


             // i+1 , j-2
            if(isSafe(temp.i+1 , temp.j-2,visited,target,N)){
                queue.add(new Pair1(temp.i+1 , temp.j-2,temp.distance+1));
            }

           // i+2 , j-1
            if(isSafe(temp.i+2 , temp.j-1,visited,target,N)){
                queue.add(new Pair1(temp.i+2 , temp.j-1,temp.distance+1));
            }
            // i+2 , j+1 --
            if(isSafe(temp.i+2 , temp.j+1,visited,target,N)){
                queue.add(new Pair1(temp.i+2 , temp.j+1,temp.distance+1));
            }
            // i-1 , j+2  --
            if(isSafe(temp.i-1 , temp.j+2,visited,target,N)){
                queue.add(new Pair1(temp.i-1 , temp.j+2,temp.distance+1));
            }

            // i+1 , j+2  --
            if(isSafe(temp.i+1 , temp.j+2,visited,target,N)){
                queue.add(new Pair1(temp.i+1 , temp.j+2,temp.distance+1));
            }
        }

        return 0;
    }

    private static boolean isSafe(int i, int j, boolean[][] visited, int[] target,int N) {
        if((i>=0 && i<N) && (j>=0 && j<N) && !visited[i][j] ) {
            visited[i][j]= true;
            return  true;
        }
        return false;
    }


}

class Pair1 {
    int i,j,distance;

    public Pair1(int i, int j,int distance) {
        this.i = i;
        this.j = j;
        this.distance = distance;

    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair1 pair1 = (Pair1) o;
        return i == pair1.i &&
                j == pair1.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

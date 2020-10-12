package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MInStepByKnight {

    static int MINIMU_DISTANCE = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int N=30;
        int knight [] = {1,1};
        int target [] = {N-1,N-1};

/*
        int N=6;
        int knight [] = {4,5};
        int target [] = {1,1};*/

        boolean [][] visited = new boolean[N][N];




        visited[knight[0]][knight[1]] = true;
        findMinimumDistance(knight[0],knight[1],target,visited,0,N, new ArrayList<>());

        System.out.println();
        System.out.println(" MINIMU_DISTANCE  :"+MINIMU_DISTANCE);


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

    private static void findMinimumDistance(int i, int j, int[] target, boolean[][] visited, int distance, int N, List<Pair1> list) {

       // System.out.println("i :"+i+ "  j  "+j);
        if( i == target[0] && j == target[1]){
           // System.out.println("i :"+i+ "  j  "+j);


            if(distance <=MINIMU_DISTANCE){
                System.out.println();
                System.out.println("distance :"+distance);
              //  list.forEach(e-> System.out.print("--> ("+e.i+","+e.j+")"));
                MINIMU_DISTANCE = distance;

            }
            return;
        }

        // i-2 , j+1
        if(isSafe(i-2 , j+1,visited,N,target)){
            visited[i-2][j+1] = true;
           // list.add(new Pair(i-2,j+1));
            findMinimumDistance(i-2,j+1,target,visited,distance+1,N, list);
            visited[i-2][j+1] = false;
          //  list.remove(new Pair(i-2,j+1));
        }

        // i-2, j-1
        if(isSafe(i-2 , j-1,visited,N, target)){
            visited[i-2][j-1] = true;
           // list.add(new Pair1(i-2,j-1));
            findMinimumDistance(i-2,j-1,target,visited,distance+1,N, list);
            visited[i-2][j-1] = false;
          //  list.remove(new Pair1(i-2,j-1));
        }

        // i-1 , j-2
        if(isSafe(i-1 , j-2,visited,N, target)){
            visited[i-1][j-2] = true;
           // list.add(new Pair1(i-1,j-2));
            findMinimumDistance(i-1,j-2,target,visited,distance+1,N, list);
            visited[i-1][j-2] = false;
          //  list.remove(new Pair1(i-1,j-2));
        }

        // i+1 , j-2
        if(isSafe(i+1 , j-2,visited,N, target)){
            visited[i+1][j-2] = true;
          //  list.add(new Pair1(i+1,j-2));
            findMinimumDistance(i+1,j-2,target,visited,distance+1,N, list);
            visited[i+1][j-2] = false;
         //   list.remove(new Pair1(i+1,j-2));
        }

        // i+2 , j-1
        if(isSafe(i+2 , j-1,visited,N, target)){
           // list.add(new Pair1(i+2,j-1));
            visited[i+2][j-1] = true;
            findMinimumDistance(i+2,j-1,target,visited,distance+1,N, list);
            visited[i+2][j-1] = false;
          //  list.remove(new Pair1(i+2,j-1));
        }

        // i+2 , j+1
        if(isSafe(i+2 , j+1,visited,N, target)){
          //  list.add(new Pair1(i+2,j+1));
            visited[i+2][j+1] = true;
            findMinimumDistance(i+2,j+1,target,visited,distance+1,N, list);
            visited[i+2][j+1] = false;
          //  list.remove(new Pair1(i+2,j+1));
        }

        //i-1 , j+2
        if(isSafe(i-1 , j+2,visited,N, target)){
           // list.add(new Pair1(i-1,j+2));
            visited[i-1][j+2] = true;
            findMinimumDistance(i-1,j+2,target,visited,distance+1,N, list);
         //   visited[i-1][j+2] = false;
          //  list.remove(new Pair1(i-1,j+2));
        }

        //i+1 , j+2
        if(isSafe(i+1 , j+2,visited,N, target)){
         //   list.add(new Pair1(i+1,j+2));
            visited[i+1][j+2] = true;
            findMinimumDistance(i+1,j+2,target,visited,distance+1,N, list);
            visited[i+1][j+2] = false;
         //   list.remove(new Pair1(i+1,j+2));
        }

    }

    private static boolean isSafe(int i, int j, boolean[][] visited, int N, int[] target) {
        if((i>=0 && i<N) && (j>=0 && j<N) && !visited[i][j] ) { return  true;}
        return false;
    }


}

class Pair{
    int i,j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
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
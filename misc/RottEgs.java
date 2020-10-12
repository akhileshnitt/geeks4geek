package misc;

import java.util.LinkedList;
import java.util.Queue;

public class RottEgs {

    public static void main(String[] args) {
        int arr[][] = { {2, 1, 0, 2, 1},
                        {1, 0, 1, 2, 1},
                        {1, 0, 0, 2, 1}};


        // 1 fresh
        // 0 empty
        // 2 rotten


        System.out.println("Total time : "+rottEggs(arr));


    }

    private static int rottEggs(int[][] arr) {

        int x [] = {-1,1,0,0};
        int y [] = {0,0,-1,1};

        int totalTime=0;

        Queue<Element> rottenQueue = new LinkedList<>();

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j] ==2)
                rottenQueue.add(new Element(i,j));
            }
        }


        while (!rottenQueue.isEmpty()){

            int size = rottenQueue.size();
            totalTime++;

         //   System.out.println(size);
            for(int i=0;i<size;i++){

                Element element = rottenQueue.poll();

                for(int j=0;j<x.length;j++){
                    int row = element.i+x[j];
                    int col = element.j+y[j];
                    if(row >=0 && row <arr.length && col >=0 && col <arr[0].length){
                        if(arr[row][col] == 1){
                            //rott eggs
                            arr[row][col] = 2;
                            rottenQueue.add(new Element(row,col));
                        }
                    }

                }
            }

            if(allRooten(arr)) return totalTime;

        }
        return -1;
    }

    private static boolean allRooten(int[][] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j] ==1)
                    return false;
            }
        }
        return true;
    }

    static  class Element{
        int i;
        int j;

        public Element(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

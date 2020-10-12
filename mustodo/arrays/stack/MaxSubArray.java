package mustodo.arrays.stack;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxSubArray {

    public static void main(String[] args) {
        //1 2 3 1 4 5 2 3 6
        //3 3 4 5 5 5 6

       /* int a [] = {1 ,2, 3, 1, 4, 5, 2, 3, 6};
        int k=3;*/

        int a [] = {8 ,5 ,10, 7 ,9 ,4 ,15, 12, 90, 13};
        int k=4;

        PriorityQueue<Integer> pq = new PriorityQueue<>(3, Collections.reverseOrder());

        for(int i=0;i<=a.length-k;i=i+1){
            int max = insertAndReturnMax(pq,a,i,i+k,k);
            System.out.println(max);
        }
    }

    private static int insertAndReturnMax(PriorityQueue<Integer> pq, int[] a, int i, int j,int size) {
        for(int k=i;k<j;k++){
           if(pq.size() ==size ){
               if(pq.peek() < a[k]){
                   pq.remove();
                   pq.add(a[k]);
               }
           }else{
               pq.add(a[k]);
           }
        }
        return pq.peek();
    }
}

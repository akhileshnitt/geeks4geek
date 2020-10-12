package mustodo.arrays.arrys;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Ksmallest {
    public static void main(String[] args) {
        /*int a [] = {7, 10 ,4,3, 20, 15};
        int k=3;*/

        int a [] = {7 ,10, 4 ,20 ,15};
        int k=4;

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.reverseOrder());
        for(int i=0;i<a.length;i++){

            pq.add(a[i]);
            if(pq.size() > k) pq.remove();
        }


            System.out.println( pq.remove());


    }
}

package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestUnsorted {
    public static void main(String[] args) {
       /* int arr[] = {10, 2, 14, 4, 7, 6};
        int b = 5, k = 3;*/

        int arr[] = {-10, -50, 20, 17, 80};
        int b = 20, k = 2;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1-b)<Math.abs(o2-b)){
                    return 1;
                }
                else {

                    return -1;
                }
            }
        });

        for(int a1:arr ){
            if(priorityQueue.size() == k){
                priorityQueue.poll();
            }
            priorityQueue.add(a1);
        }

        while (!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.poll()+",");
        }

    }
}
